package 적록색약;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int row_column = Integer.parseInt(br.readLine());
        char[][] board= new char[row_column][row_column];
        char[][] new_board= new char[row_column][row_column];

        for(int a=0; a<row_column; a++){
            String s = br.readLine();

            for(int b=0; b<row_column; b++){
                char value = s.charAt(b);
                board[a][b] = value;
                if(value== 'G'){
                    new_board[a][b] = 'R';
                }
                else{
                    new_board[a][b] = value;
                }
            }
        }

        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        int answer1 = 0;
        for(int a=0; a<row_column; a++){
            for(int b=0; b<row_column; b++){
                if(board[a][b] != 'X'){
                    answer1 ++;
                    char value = board[a][b];

                    Queue<Node> que = new LinkedList<Node>();
                    board[a][b] = 'X';
                    que.add(new Node(b,a));
                    while(!que.isEmpty()){
                        Node node = que.remove();

                        for(int k=0; k<4; k++){
                            int dx = node.x + move[k][1];
                            int dy = node.y + move[k][0];

                            if(dx>=0 && dy>=0 && dx<row_column && dy<row_column && board[dy][dx]== value){
                                board[dy][dx] = 'X';
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }

        int answer2 = 0;
        for(int a=0; a<row_column; a++){
            for(int b=0; b<row_column; b++){
                if(new_board[a][b] != 'X'){
                    answer2 ++;
                    char value = new_board[a][b];

                    Queue<Node> que = new LinkedList<Node>();
                    new_board[a][b] = 'X';
                    que.add(new Node(b,a));
                    while(!que.isEmpty()){
                        Node node = que.remove();

                        for(int k=0; k<4; k++){
                            int dx = node.x + move[k][1];
                            int dy = node.y + move[k][0];

                            if(dx>=0 && dy>=0 && dx<row_column && dy<row_column && new_board[dy][dx]== value){
                                new_board[dy][dx] = 'X';
                                que.add(new Node(dx, dy));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer1+" "+answer2);
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x =x ;
        this.y = y;
    }
}