import java.util.*;
import java.io.*;

public class BFS_1 {
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] board = new int[column][row];
        boolean [][][] check = new boolean[2][column][row];
        int[][] count = new int[column][row];

        for(int a=0; a<column; a++){
            String s = br.readLine();
            for(int b=0; b<row; b++){
                board[a][b] = s.charAt(b) - '0';
            }
        }

        for(int a=0; a<count.length; a++){
            Arrays.fill(count[a], -1);
        }
        count[0][0] = 1;
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(0,0,false));

        while (!que.isEmpty()) {
            Node node = que.remove();

            if(node.y == column-1 && node.x == row -1){
                break;
            }

            for(int a=0; a<4; a++){
                int dx = node.x + move[a][1];
                int dy = node.y + move[a][0];

                if(dx>=0 && dy>=0 && dx<row && dy<column ){
                    if(board[dy][dx] == 0 && !check[node.visit? 1: 0][dy][dx]){
                        count[dy][dx] = count[node.y][node.x] +1;
                        que.add(new Node(dx , dy , node.visit));
                        check[node.visit? 1: 0][dy][dx] = true;
                    }
                    else if(board[dy][dx] == 1 && !node.visit && !check[node.visit? 1: 0][dy][dx]){
                        count[dy][dx] = count[node.y][node.x] +1;
                        que.add(new Node(dx , dy , true));
                        check[node.visit? 1: 0][dy][dx] = true;
                    }
                }
            }
        }
        System.out.println(count[column-1][row-1]);


    }

}

class Node{
    int x;
    int y;
    boolean visit;
    public Node(int x, int y,boolean visit){
        this.x = x;
        this.y = y;
        this.visit = visit;
    }
}


