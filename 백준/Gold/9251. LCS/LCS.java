import org.w3c.dom.Node;

import  java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a1 = br.readLine();
        String a2 = br.readLine();

        int[][] board = new int[a1.length()][a2.length()];

        for(int a=0; a<a1.length(); a++){
            for(int b=0; b<a2.length(); b++){
                if(a1.charAt(a) == a2.charAt(b)){
                    if(a-1 >=0 && b-1 >=0){
                        board[a][b] = board[a-1][b-1] +1;
                    }
                    else{
                        board[a][b] = 1;
                    }
                }
                else if(a-1>= 0 && b-1 >= 0){
                    board[a][b] = Math.max(board[a-1][b],board[a][b-1]);
                }
                else if(a-1>=0){
                    board[a][b] = board[a-1][b];
                }
                else if(b-1>=0){
                    board[a][b] = board[a][b-1];
                }

            }
        }

        int answer = 0;
        for(int[] arg: board){
            for(int arg2 : arg){
                answer = Math.max(answer, arg2);
            }
        }
        System.out.println(answer);
    }
}