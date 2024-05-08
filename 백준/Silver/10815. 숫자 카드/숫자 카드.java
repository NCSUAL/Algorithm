import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main{
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        array = new int[length];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        int length2 = Integer.parseInt(br.readLine());
        int[] arr = new int[length2];

        st =new StringTokenizer(br.readLine());

        for(int a=0; a<length2; a++){
            arr[a] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for(int a=0; a<length2; a++){
            if(search(0,length-1,arr[a])){
                sb.append(1).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }

    public static boolean search(int start, int end,int target){

        while (start<=end) {
            int mid = (start+end)/2;

            if (target == array[mid]) {
                return true;
            }
            else if(array[mid]>target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }

        return false;
    }

}