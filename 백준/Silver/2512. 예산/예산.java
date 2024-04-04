import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[length];

        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = array[array.length -1];

        int mid = 0;
        long sum = 0;
        while(start<=end){
            mid = (start + end)/2;

            sum = 0;
            for(int a=0; a<array.length; a++){
                if(array[a]>mid){
                    sum += mid;
                }
                else{
                    sum += array[a];
                }
            }


            if(sum> target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }

        System.out.println(end);
    }
}