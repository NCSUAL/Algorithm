import java.util.*;
import java.io.*;

public class Main{
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] board = new int[col][row];
        String s;

        for(int a=0; a<col; a++){
            s = br.readLine();
            for(int b=0; b<row ;b++){
                board[a][b] = s.charAt(b)-48;
            }
        }

        PriorityQueue<Node> pr_queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist - o2.dist;
            }
        });

        boolean[][] used = new boolean[col][row];
        used[0][0] = true;

        pr_queue.add(new Node(0,0,0));

        while(!pr_queue.isEmpty()){
            Node node = pr_queue.remove();

            if(node.x == row-1 && node.y == col-1){
                System.out.println(node.dist);
                System.exit(0);
            }

            for(int a=0; a<4; a++){
                int dx = node.x + move[a][0];
                int dy = node.y + move[a][1];

                if(dx>=0 && dy>=0 && dx<row && dy<col && !used[dy][dx]){
                    used[dy][dx] = true;
                    if(board[dy][dx] == 1){
                        pr_queue.add(new Node(dx, dy, node.dist +1));
                    }
                    else{
                        pr_queue.add(new Node(dx, dy, node.dist));
                    }
                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    int dist;

    public Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}