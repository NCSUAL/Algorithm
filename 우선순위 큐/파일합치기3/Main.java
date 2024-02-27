package 파일합치기3;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int event = Integer.parseInt(br.readLine());
        long[] answer = new long[event];
        for(int a=0; a<event; a++){
            PriorityQueue<Long> que =new PriorityQueue<>();
            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<length; b++){
                que.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while(que.size()>1){
                long value = que.remove() + que.remove();
                sum += value;
                que.add(value);
            }

            answer[a] = sum;

        }

        for(long arg : answer){
            System.out.println(arg);
        }
    }
}
