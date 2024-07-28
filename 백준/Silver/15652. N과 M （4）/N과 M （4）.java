import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0,0);
    }

    static void dfs(int current, int depth){
        if(depth == arr.length){
            for(int a=0; a<arr.length; a++){
                System.out.print(arr[a]+1+" ");
            }
            System.out.println();
            return;
        }

        for(int a=current; a<N; a++){
            if(depth==0){
                arr[depth] = a;
                dfs(a,depth+1);
            }
            if(depth>0 && arr[depth-1] <= a){
                arr[depth] = a;
                dfs(a, depth+1);
            }
        }
    }
}