import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[][] array = new int[length][2];
        StringTokenizer st ;

        for(int a=0; a<length; a++){
            st = new StringTokenizer(br.readLine());

            array[a][0] = Integer.parseInt(st.nextToken());
            array[a][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[1] == a2[1]){
                    return a1[0] - a2[0];
                }
                else{
                    return a1[1] - a2[1];
                }
            }
        });

        for(int[] arg: array){
            System.out.println(arg[0] +" "+arg[1]);
        }
    }
}