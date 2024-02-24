package 일로만들기;


import java.io.*;
public class Dp {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int[] dp = new int[number +1];
        for(int a=2; a<=number; a++){
            dp[a] = dp[a-1] +1;
            if(a%2==0){
                dp[a] = Math.min(dp[a], dp[a/2] +1);
            }
            if(a%3==0){
                dp[a] = Math.min(dp[a],dp[a/3] +1);
            }
        }

        System.out.println(dp[number]);
    }
}
