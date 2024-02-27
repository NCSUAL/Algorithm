package 불_느낌표;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        char[][] board = new char[column][row];

        Queue<Node> que = new LinkedList<Node>();
        Queue<Node> fire_que = new LinkedList<Node>();
        for(int a=0; a<column; a++){
            String s = br.readLine();
            for(int b=0; b<row; b++){
                char value = s.charAt(b);
                board[a][b] = value;
                if(value == 'J'){
                    que.add(new Node(b, a,0));
                }
                if (value == 'F') {
                    fire_que.add(new Node(b,a,0));
                }
            }
        }

        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!que.isEmpty()){
            Queue<Node> current = new LinkedList<Node>();

            while(!que.isEmpty()){
                Node node = que.remove();

                for(int a=0; a<4; a++){
                    int dx = node.x + move[a][1];
                    int dy = node.y + move[a][0];

                    if(dx<0 || dy<0 || dx>=row || dy>= column){
                        if(board[node.y][node.x]== 'J'){
                            System.out.println(node.time+1);
                            System.exit(0);
                        }
                    }

                    if(dx>=0 && dy>=0 && dx<row && dy<column && board[dy][dx] == '.'){
                        board[dy][dx] = 'J';
                        current.add(new Node(dx, dy, node.time +1));
                    }
                }
            }

            que.addAll(current);
            current.clear();

            while(!fire_que.isEmpty()){
                Node node = fire_que.remove();

                for(int a=0; a<4; a++){
                    int dx = node.x + move[a][1];
                    int dy = node.y + move[a][0];

                    if(dx>=0 && dy>=0 && dx<row && dy<column){
                        if(board[dy][dx] == '.' || board[dy][dx] == 'J'){
                            board[dy][dx] = 'F';
                            current.add(new Node(dx, dy ,0));
                        }
                    }
                }
            }

            fire_que.addAll(current);
            current.clear();
        }
        System.out.println("IMPOSSIBLE");


    }
}

class Node{
    int x;
    int y;

    int time;
    public Node(int x, int y,int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
