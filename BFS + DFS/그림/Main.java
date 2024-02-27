package 그림;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] board = new int[column][row];
        for(int a=0; a<column; a++){
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<row; b++){
                board[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int a=0; a<column; a++){
            for(int b=0; b<row; b++){

                if(board[a][b] ==1){
                    count++;
                    int area =0;
                    Queue<Node> que = new LinkedList<Node>();
                    que.add(new Node(b,a));
                    board[a][b] = 0;
                    while(!que.isEmpty()){
                        Node node = que.remove();
                        area ++;

                        for(int k=0; k<4; k++){
                            int dx = node.x + move[k][1];
                            int dy = node.y + move[k][0];

                            if(dx>=0 && dy>=0 && dx<row && dy<column && board[dy][dx]==1){
                                board[dy][dx] = 0;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }

                    answer.add(area);
                }
            }
        }

        System.out.println(count);
        if(answer.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(Collections.max(answer));
        }
    }
}

class Node{
    int x;
    int y;
    public Node(int x , int y) {
        this.x = x;
        this.y = y;
    }
}
