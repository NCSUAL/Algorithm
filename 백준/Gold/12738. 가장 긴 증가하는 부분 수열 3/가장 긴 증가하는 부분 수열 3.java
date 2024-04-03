import java.util.*;
import java.io.*;

public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[length];
        Arrays.fill(dp, -1000000001);
        int answer = 0;
        for(int a=0; a<length; a++){
            int value = Integer.parseInt(st.nextToken());
            int idx = search(value,0,answer);

            if(idx == -1){
                dp[answer ++] = value;
            }
            else{
                dp[idx] = value;
            }
        }

        System.out.println(answer);
    }

    public static int search(int value ,int start, int end){
        int max = end +1;
        while(start<=end){
            int mid = (start + end)/ 2;

            if(value> dp[mid]){
                start = mid +1;
            }
            else if(value == dp[mid]){
                start = mid;
                end = mid-1;
            }
            else{
                end = mid -1;
            }
        }

        if(start == max){
            return -1;
        }
        else{
            return start;
        }
    }
}