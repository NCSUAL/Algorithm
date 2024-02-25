package 비밀번호찾기;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int event1 = Integer.parseInt(st.nextToken());
        int event2 = Integer.parseInt(st.nextToken());
        String[] answer = new String[event2];
        HashMap<String, String> map = new HashMap<String, String>();

        for(int a=0; a<event1; a++){
            String[] s = br.readLine().split(" ");
            map.put(s[0],s[1]);
        }

        for(int a=0; a<event2; a++){
            String s = br.readLine();
            answer[a] = map.get(s);
        }

        for(int a=0; a<event2; a++){
            System.out.println(answer[a]);
        }
    }
}
