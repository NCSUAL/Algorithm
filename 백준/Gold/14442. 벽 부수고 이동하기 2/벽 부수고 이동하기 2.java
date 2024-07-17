import java.util.*;
import java.io.*;

public class Main{
    final static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sts = br.readLine().split(" ");
        int column = toInt(sts[0]);
        int row = toInt(sts[1]);
        int count = toInt(sts[2]);
        int[][] board = new int[column][row];

        String s;
        for(int a=0; a<column; a++){
            s = br.readLine();
            for(int b=0; b<row; b++){
                board[a][b] = s.charAt(b)-48;
            }
        }

        boolean[][][] used = new boolean[count+1][column][row];
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(0,0,0,0));


        while (!que.isEmpty()) {
            Node node = que.remove();

            if(node.x == row - 1 && node.y == column -1){
                System.out.println(node.dist+1);
                System.exit(0);
            }

            for(int a=0; a<4; a++){
                int dy = node.y + move[a][0];
                int dx = node.x + move[a][1];

                if(dx>=0 && dy>=0 && dx<row && dy<column){
                    if(board[dy][dx]== 0  && !used[node.broken][dy][dx]) {
                        used[node.broken][dy][dx] = true;
                        que.add(new Node(dx, dy, node.broken,node.dist+1));
                    }
                    else if(board[dy][dx] == 1 && node.broken<count  && !used[node.broken+1][dy][dx]){
                        used[node.broken+1][dy][dx] = true;
                        que.add(new Node(dx, dy, node.broken+1,node.dist+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static int toInt(String s){
        return Integer.parseInt(s);
    }
}

class Node{
    int x;
    int y;
    int broken;
    int dist;

    public Node(int x, int y, int broken,int dist){
        this.x = x;
        this.y = y;
        this.broken = broken;
        this.dist = dist;
    }
}