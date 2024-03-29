import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> que = new PriorityQueue<Long>();

        st = new StringTokenizer(br.readLine());

        for(int a=0; a<length; a++){
            que.add(Long.parseLong(st.nextToken()));
        }

        while(target>0){
            long a = que.remove();
            long b = que.remove();

            que.add(a+b);
            que.add(a+b);
            target--;
        }

        long answer = 0;
        while(!que.isEmpty()){
            answer += que.remove();
        }

        System.out.println(answer);
    }
}