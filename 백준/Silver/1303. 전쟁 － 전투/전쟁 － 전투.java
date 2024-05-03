import java.util.*;
import java.io.*;

public class Main{
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] board= new char[col][row];
        for(int a=0; a<col; a++){
            String s =  bufferedReader.readLine();

            for(int b=0; b<row ; b++){
                board[a][b] = s.charAt(b);
            }
        }

        boolean[][] used = new boolean[col][row];
        int my = 0;
        int enemy = 0;
        char current;
        Queue<Node> que = new LinkedList<Node>();
        for(int a=0; a<col; a++){
            for(int b=0; b<row; b++){
                if(!used[a][b]){

                    //탐색 시작
                    current = board[a][b];
                    int sum = 1;
                    que.add(new Node(b,a));
                    used[a][b] = true;

                    while (!que.isEmpty()) {
                        Node node = que.remove();

                        for(int k=0; k<4; k++){
                            int dx = node.x + move[k][1];
                            int dy = node.y + move[k][0];

                            if(dx>=0 && dy>=0 && dx<row && dy<col && board[dy][dx] == current && !used[dy][dx]){
                                que.add(new Node(dx, dy));
                                used[dy][dx] = true;
                                sum +=1;
                            }
                        }
                    }
                    
                    if (current == 'W') {
                        my += Math.pow(sum,2);
                    }
                    else{
                        enemy += Math.pow(sum,2);
                    }
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(my +" "+ enemy);

        System.out.println(sb);
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x =x ;
        this.y =y;
    }
}