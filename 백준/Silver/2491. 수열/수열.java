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

        for(int a=1; a<length; a++){
            if(array[a] >= array[a-1]){
                dp[a] = dp[a-1] +1;
            }
            answer = Math.max(dp[a], answer);
        }

        dp = new int[length];
        Arrays.fill(dp,1);
        for(int a=1; a<length; a++){
            if(array[a] <= array[a-1]){
                dp[a] = dp[a-1] +1;
            }
            answer = Math.max(dp[a], answer);
        }
        System.out.println(answer);
    }
}