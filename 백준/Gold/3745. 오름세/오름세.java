import java.util.*;
import java.io.*;

public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String length;
        StringBuffer sb = new StringBuffer();
            while((length = br.readLine())!=null){
                int len = Integer.parseInt(length.trim());
                StringTokenizer st = new StringTokenizer(br.readLine());

                dp = new int[len];

                int LIS =0;

                for(int a=0; a<len; a++){
                    int value = Integer.parseInt(st.nextToken());
                    int search = search(0,LIS,value);

                    if(search == -1){
                        dp[LIS++] = value;
                    }
                    else{
                        dp[search] = value;
                    }
                }

                sb.append(LIS).append("\n");
            }
                 System.out.println(sb);
        }



    public static int search(int start, int end, int target){
        int max = end +1;

        while(start<=end){
            int mid = (start+end)/2;

            if(dp[mid] >= target){
                end = mid - 1;
            }
            else if(dp[mid] < target){
                start = mid +1;
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