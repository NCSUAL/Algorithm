import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[length];
        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int answer = 1;
        
        for(int a=0; a<length; a++){
            for(int b=0; b<=a; b++){
                //점화식
                if(array[a]>array[b]){
                    dp[a] = Math.max(dp[a],dp[b] +1);
                }
            }
            answer = Math.max(dp[a], answer);
        }
        System.out.println(answer);
    }
}