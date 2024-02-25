package 절댓값힙;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pr_que = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a1, Integer a2){
                int a = Math.abs(a1);
                int b= Math.abs(a2);
                if(a==b){
                    return a1-a2;
                }
                else{
                    return a-b;
                }
            }
        });

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int a=0; a<length; a++){
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                if(pr_que.isEmpty()){
                    answer.add(0);
                }
                else{
                    answer.add(pr_que.remove());
                }
            }
            else{
                pr_que.add(value);
            }
        }

        for(int a=0; a<answer.size();a++){
            System.out.println(answer.get(a));
        }
    }
}
