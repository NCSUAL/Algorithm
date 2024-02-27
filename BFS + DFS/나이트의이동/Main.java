package 나이트의이동;


import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int event = Integer.parseInt(br.readLine());
        int[] answer = new int[event];

        int[][] move = {{2,1},{1,2},{-2,1},{-1,2},{2,-1},{-2,-1},{1,-2},{-1,-2}};
        for(int a=0; a<event; a++){
            int length = Integer.parseInt(br.readLine());
            int[][] board = new int[length][length];

            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            Queue<Node> que = new LinkedList<Node>();
            que.add(new Node(start[1],start[0]));
            board[start[0]][start[1]] = 1;

            while(!que.isEmpty()){
                Node node = que.remove();

                if(node.x == end[1] && node.y == end[0]){
                    answer[a] = board[node.y][node.x];
                    break;
                }

                for(int k=0; k<move.length; k++){
                    int dx = node.x + move[k][1];
                    int dy = node.y + move[k][0];

                    if(dx>=0 && dy>=0 && dx<length && dy<length && board[dy][dx]==0){
                        board[dy][dx] = board[node.y][node.x] +1;
                        que.add(new Node(dx, dy));
                    }
                }
            }

        }

        for(int a: answer){
                System.out.println(a-1);
        }
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
