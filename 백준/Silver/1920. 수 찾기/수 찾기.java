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

        Arrays.sort(array);

        int len = Integer.parseInt(br.readLine());

        int[] answer = new int[len];

        st = new StringTokenizer(br.readLine());
        for(int a=0; a<len; a++){
            if(search(Integer.parseInt(st.nextToken()))){
                answer[a] = 1;
            }
            else{
                answer[a] = 0;
            }
        }

        for(int arg : answer){
            System.out.println(arg);
        }
    }

    public static boolean search(int target){
        int start = 0;
        int end = array.length -1;
        while (start<=end) {
            int mid = (start+end)/2;
            
            if(array[mid]== target){
                return true;
            }
            else if(array[mid]>target){
                end = mid -1;
            }
            else{
                start = mid+ 1;
            }
        }

        return false;
    }
}