import java.util.*;
import java.io.*;

public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        dp = new int[length];

        int current = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int a=0; a<length; a++){
            int value = Integer.parseInt(st.nextToken());
            int k = search(0,current,value);
            if(k == -1){
                dp[current] = value;
                current ++;
            }
            else{
                dp[k] = value;
            }
        }

        System.out.println(length - current );
    }


    public static int search(int start, int end,int target){
        int max = end+1;
        while(start<=end){
            int mid = (start+end)/2;

            if(dp[mid] > target){
                end = mid -1;
            }
            else if(dp[mid] == target){
                start = mid;
                break;
            }
            else{
                start = mid +1;
            }
        }

        if (start == max) {
            return -1;
        }
        else{
            return start;
        }
    }
}