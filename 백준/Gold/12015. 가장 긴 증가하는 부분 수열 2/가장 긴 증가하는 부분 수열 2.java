import java.util.*;
import java.io.*;

public class Main{
    static int[] array, dp;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[length];
        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        dp = new int[length];

        int LIS = 0;
        for(int a=0; a<length; a++){
            int idx = search(array[a], 0, LIS, LIS+1 );

            if(idx == -1){
                dp[LIS++] = array[a];
            }
            else{
                dp[idx] = array[a];
            }

        }

        System.out.println(LIS);
    }

    public static int search(int value,int start, int end, int max){
        while(start<=end){
            int mid = (start+ end)/2;

            if(value>dp[mid]){
                start = mid +1;
            }
            else if(value<dp[mid]){
                end = mid-1;
            }
            else{
                start = mid;
                end = mid-1;
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