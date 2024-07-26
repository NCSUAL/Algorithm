import java.util.*;
import java.io.*;

public class Main{
    final static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] board = new int[length][length];
        boolean[][] used = new boolean[length][length];

        for(int a=0; a<length; a++){
            String s = br.readLine();
            for(int b=0; b<length; b++){
                board[a][b] = s.charAt(b)-48;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                return o1.dispose - o2.dispose;
            }
        });

        pq.add(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node node = pq.remove();

            if (node.y == length-1 && node.x == length-1) {
                System.out.println(node.dispose);
                System.exit(0);
            }

            for(int a=0; a<4; a++){
                int dx = node.x + move[a][1];
                int dy = node.y + move[a][0];

                if(dx>=0 && dy>=0 && dx<length && dy<length && !used[dy][dx]){
                    used[dy][dx] = true;
                    pq.add(new Node(dx,dy,board[dy][dx]==0? node.dispose +1 : node.dispose));
                }
            }
        }

    }
}

class Node{
    int x;
    int y;
    int dispose;

    public Node(int x, int y, int dispose){
        this.x = x;
        this.y =y;
        this.dispose = dispose;
    }
}