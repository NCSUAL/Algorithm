
import java.util.*;
import java.io.*;

public class Main{
    static int answer = 0;
    static int[][] board;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        board=  new int[column][row];

        for(int a=0; a<column; a++){
            st=  new StringTokenizer(bufferedReader.readLine());

            for(int b=0; b<row; b++){
                board[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }


        for(int a=0; a<board.length; a++){
            for(int b=0; b<board[a].length; b++){
                if(board[a][b] == 0){
                    board[a][b] = 1;
                    dfs(depth +1);
                    board[a][b] = 0;
                }
            }
        }
    }

    public static void bfs(){
        int[][] newArray = new int[board.length][board[0].length];
        for(int a=0; a<board.length; a++){
            for(int b=0; b<board[a].length; b++){
                newArray[a][b] = board[a][b];
            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        for(int a=0; a<board.length; a++){
            for(int b=0; b<board[a].length; b++){
                if(board[a][b] == 2){
                    queue.add(new Node(b,a));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.remove();

            for(int a=0; a<4; a++){
                int dx = node.x + move[a][1];
                int dy = node.y + move[a][0];

                if(dx>=0 && dy>=0 && dy<board.length && dx<board[0].length){
                    if(newArray[dy][dx] ==0){
                        newArray[dy][dx] = 2;
                        queue.add(new Node(dx, dy));
                    }
                }
            }
        }

        int count = 0;
        for(int a=0; a<newArray.length; a++){
            for(int b=0; b<newArray[a].length; b++){
                if(newArray[a][b] ==0){
                    count++;
                }
            }
        }

        answer = Math.max(answer,count);
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y =y ;
    }
}