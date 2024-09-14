import org.w3c.dom.Node;

import  java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist,-1);
        int[] count = new int[100001];

        count[start] =1;
        dist[start] = 0;
        Queue<Integer> que =new LinkedList<>();
        que.add(start);


        while(!que.isEmpty()){
            int cur = que.remove();

            int[] move = {cur+1, cur-1, cur*2};

            for(int a=0; a<3; a++){
                if(move[a]>=0 && move[a]<=100000){
                    if(dist[move[a]] == -1){
                        dist[move[a]] = dist[cur] +1;
                        count[move[a]] = count[cur];
                        que.add(move[a]);
                    }
                    else if(dist[move[a]] == dist[cur] +1){
                        count[move[a]] += count[cur];
                    }
                }
            }
        }

        System.out.println(dist[end]);
        System.out.println(count[end]);
    }
}