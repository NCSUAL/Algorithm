package 상범빌딩;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while(true){
            String[] val = br.readLine().split(" ");
            int z_length = Integer.parseInt(val[0]);
            int y_length = Integer.parseInt(val[1]);
            int x_length = Integer.parseInt(val[2]);

            if(z_length ==0 && y_length==0 && x_length==0){
                break;
            }

            char[][][] board = new char[z_length][y_length][x_length];
            int[][][] count = new int[z_length][y_length][x_length];
            int[] end = new int[3];
            Queue<Node> que = new LinkedList<Node>();

            for(int a=0; a<z_length; a++){
                for(int b=0; b<y_length; b++){
                    String s = br.readLine();
                    for(int c=0; c<x_length; c++){
                        char value = s.charAt(c);
                        if(value == 'S'){
                            que.add(new Node(c,b,a));
                            count[a][b][c] = 1;
                        }
                        else if(value == 'E'){
                            end = new int[]{c,b,a};
                        }
                        board[a][b][c] = value;
                    }
                }
                br.readLine();
            }

            //BFS
            int[] move_dx = {-1,1,0,0,0,0};
            int[] move_dy = {0,0,-1,1,0,0};
            int[] move_dz = {0,0,0,0,-1,1};

            while(!que.isEmpty()){
                Node node = que.remove();

                if(node.x == end[0] && node.y == end[1] && node.z == end[2]){
                    break;
                }

                for(int a=0; a<6; a++){
                    int dx = node.x + move_dx[a];
                    int dy = node.y + move_dy[a];
                    int dz = node.z + move_dz[a];

                    if(dx>=0 && dy>=0 && dz>=0 && dx<x_length && dy<y_length && dz<z_length && count[dz][dy][dx] == 0 && board[dz][dy][dx] != '#'){
                        if(board[dz][dy][dx] == '.' || board[dz][dy][dx] == 'E'){
                            count[dz][dy][dx] = count[node.z][node.y][node.x] +1;
                            que.add(new Node(dx, dy, dz));
                        }
                    }
                }
            }

            answer.add(count[end[2]][end[1]][end[0]]);
        }

        for(int a=0; a<answer.size(); a++){
            if(answer.get(a)==0){
                System.out.println("Trapped!");
            }
            else{
                System.out.println("Escaped in "+(answer.get(a)-1)+" minute(s).");
            }
        }

    }

}

class Node{
    int x;
    int y;
    int z;
    public Node(int x, int y , int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
