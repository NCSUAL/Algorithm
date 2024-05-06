import java.util.*;
import java.io.*;

public class Main{
    static int[] array;
    static int[] index;
    static boolean[] used;
    static int current;
    static ArrayList<Integer> answer = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        array = new int[length];
        index = new int[length];
        used = new boolean[length];
        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(br.readLine());
            index[a] = a+1;
        }

        for(int a=0; a<length; a++){
            current = index[a];
            dfs(index[a], 0);
        }

        System.out.println(answer.size());
        for(int a=0; a<answer.size();a++){
            System.out.println(answer.get(a));
        }
    }

    static void dfs(int cur, int depth){


        if(array[cur-1] == current){
            answer.add(current);
        }
        else if(!used[cur-1]){
            used[cur-1] = true;
            dfs(array[cur-1],depth+1);
            used[cur-1] = false;
        }
    }
}