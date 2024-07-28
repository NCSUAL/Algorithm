import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        used = new boolean[N];
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

        for(int a=current; a<used.length; a++){
            if(!used[a]){
                used[a] = true;
                arr[depth] = a;
                dfs(a, depth+1);
                used[a] = false;
            }
        }
    }
}