import  java.util.*;
import java.io.*;

public class Main {
    static int[] array;
    static boolean[] used;
    static int len;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        array = new int[length];
        used = new boolean[10001];

        st = new StringTokenizer(br.readLine());
        for (int a = 0; a < length; a++) {
            array[a] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0,new int[len],0);
    }

    public static void dfs(int depth,int[] arr,int current){
        if(depth == len){
            for(int arg: arr){
                System.out.print(arg);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        int check = 0;
        for(int a=current; a<array.length; a++){
            if(check != array[a]){
                check = array[a];
                arr[depth] = array[a];
                dfs(depth+1,arr,a);
            }
        }
    }
}
