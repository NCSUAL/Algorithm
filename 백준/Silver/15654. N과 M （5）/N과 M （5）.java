import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int[] array;
    static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        array = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int a=0; a<N; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        dfs(0,0);
    }

    static void dfs(int current, int depth){
        if(depth == arr.length){
            for(int a=0; a<arr.length; a++){
                System.out.print(arr[a]+" ");
            }
            System.out.println();
            return;
        }

        for(int a=current; a<array.length; a++){
            if(!used[a]){
                used[a] = true;
                arr[depth] = array[a];
                dfs(0, depth+1);
                used[a] = false;
            }
        }
    }
}