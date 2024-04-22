import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine()) -1;

        int target = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());

        int answer = 0;

        if(length != 0){
            for(int a=0; a<length; a++){
                que.add(Integer.parseInt(br.readLine()));
            }


            while(target<=que.peek()){
                answer ++;
                target += 1;
                que.add(que.remove()-1);
            }
        }

        System.out.println(answer);



    }
}