package 영역구하기;


import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int event = Integer.parseInt(st.nextToken());

        int[][] board = new int[column][row];
        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for(int b=start[1]; b<end[1]; b++){
                for(int c= start[0]; c<end[0]; c++){
                    if(board[b][c]==0){
                        board[b][c] = 1;
                    }
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[][] move = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int a=0; a<column; a++){
            for(int b=0; b<row; b++){
                if(board[a][b] == 0){
                    int count =0;

                    Queue<Node> que = new LinkedList<Node>();
                    que.add(new Node(b,a));
                    board[a][b] =1;
                    while(!que.isEmpty()){
                        Node node = que.remove();
                        count++;

                        for(int k=0; k<4; k++){
                            int dx = node.x + move[k][1];
                            int dy = node.y + move[k][0];

                            if(dx>=0 && dy>=0 && dx<row && dy<column && board[dy][dx]==0){
                                board[dy][dx] = 1;
                                que.add(new Node(dx, dy));
                            }
                        }
                    }

                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a=0; a<answer.size();a++){
            System.out.print(answer.get(a)+" ");
        }
    }
}

class Node{
    int x;
    int y;
    public Node(int x ,int y){
        this.x = x;
        this.y = y;
    }
}