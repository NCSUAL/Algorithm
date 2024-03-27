import java.util.*;
import java.io.*;

public class Main{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp  = new int[length];
        int[] dps = new int[length];
        int[] array = new int[length];
        //LIS
        int answer = 0;


        for(int a=0; a<length; a++){
            int value = Integer.parseInt(st.nextToken());
            array[a] = value;

            int result = search(value,0,answer, answer+1);

            if(result == -1){
                dp[answer] = value;
                answer++;
                dps[a] = answer;
            }
            else{
                dp[result] = value;
                dps[a] = result+1;
            }
        }

        System.out.println(answer);
        Stack<Integer> stack = new Stack<Integer>();
        for(int a=dps.length-1 ; a>=0; a--){
            if(answer == dps[a]){
                stack.push(array[a]);
                answer --;
            }
        }
        StringBuffer sb= new StringBuffer();

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }

    private static int search(int value,int start, int end, int max){
        //이분탐색
        int res = 0;
        while(start<=end){
            int median =  (start+ end)/2;

            if(value>dp[median]){
                start = median +1;
            }
            else{
                end = median -1;
                res = median;
            }
        }

        if(start== max){
            return -1;
        }
        else{
            return start;
        }
    }
}
