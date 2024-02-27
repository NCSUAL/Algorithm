package 계단오르기;


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int event = Integer.parseInt(br.readLine());
        int[] board = new int[event];
        for(int a=0; a<event; a++){
            board[a] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[event];
        //solved
        dp[0] = board[0];
        if(event>1){
            dp[1] = board[0] + board[1];
        }
        if(event>2){
            dp[2] = Math.max(board[0],board[1]) + board[2];
        }
;
        for(int a=3; a<event; a++){
           dp[a] = Math.max(dp[a-2],dp[a-3]+board[a-1]) + board[a];
        }

        System.out.println(dp[dp.length-1]);
    }
}
