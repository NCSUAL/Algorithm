import java.util.*;
import java.io.*;

public class Main{
    static int answer = 1;
    static boolean[] used;
    static char[][] main_board;

    static int column;
    static int row;
    static int[][] move ={{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        char[][] board= new char[column][row];
        for(int a=0; a<column; a++){
            String s = br.readLine();
            for(int b=0; b<row; b++){
                board[a][b] = s.charAt(b);
            }
        }

        used = new boolean[26];
        used[board[0][0] - 65] =true;

        main_board = board;

        dfs(0,0,1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y,int count){
        answer = Math.max(answer, count);
        for(int a=0; a<4; a++){
            int dx = move[a][1] + x;
            int dy = move[a][0] + y;

            if(dx>=0 && dy>=0 && dx<row && dy<column){
                if(!used[main_board[dy][dx]-65]){
                    used[main_board[dy][dx]-65] = true;
                    dfs(dx, dy , count +1);
                    used[main_board[dy][dx]-65] = false;
                }
            }
        }
    }


}
