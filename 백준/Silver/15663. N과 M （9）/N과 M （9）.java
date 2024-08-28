import java.util.*;
import java.io.*;


public class Main{
    static int[] array;
    static int len;
    static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());

        array = new int[length];
        used=  new boolean[length];
        st= new StringTokenizer(br.readLine());

        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0,0,new int[len]);
    }

    public static void dfs(int start,int depth,int[] arr){
        if(depth == len){
            for(int arg: arr){
                System.out.print(arg);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        int check = 0;
        for(int a=0; a<array.length; a++){
            if(check!= array[a] && !used[a]){
                check = array[a];
                used[a] = true;
                arr[depth] = array[a];
                dfs(a,depth+1,arr);
                used[a] = false;
            }
        }
    }
}