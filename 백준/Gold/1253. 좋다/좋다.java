import java.util.*;
import java.io.*;

public class Main{
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[length];
        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int answer = 0;
        for(int a=0; a<length; a++){
            if(search(0,length-1,a)){
                answer +=1;
            }
        }
        System.out.println(answer);
    }

    public static boolean search(int start, int end, int index){
        int target = array[index];

        while (start<end) {
            int current = array[start] + array[end];

            if(start == index){
                start++;
            }
            else if(end == index){
                end--;
            }
            else if(current == target){
                return true;
            }
            else if(current<target){
                start +=1;
            }
            else{
                end -=1;
            }



        }

        return false;
    }
}

