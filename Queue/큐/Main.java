package 큐;


import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int event = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<Integer>();
        int last = -1;

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int a=0; a<event; a++){
            String s = br.readLine();

            if(s.length()>5){
                int value = Integer.parseInt(s.split(" ")[1]);
                que.add(value);
                last = value;
            }
            else if(s.equals("front")){
                if(que.isEmpty()){
                    answer.add(-1);
                }
                else{
                    answer.add(que.peek());
                }
            }
            else if(s.equals("back")){
                if(que.isEmpty()){
                    answer.add(-1);
                }
                else{
                    answer.add(last);
                }
            }
            else if(s.equals("size")){
                answer.add(que.size());
            }
            else if(s.equals("pop")){
                if(que.isEmpty()){
                    answer.add(-1);
                }
                else{
                    answer.add(que.remove());
                }
            }
            else if(s.equals("empty")){
                if(que.isEmpty()){
                    answer.add(1);
                }
                else{
                    answer.add(0);
                }
            }
        }

        for(int a=0; a<answer.size(); a++){
            System.out.println(answer.get(a));
        }
    }
}
