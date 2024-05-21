import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length1 = Integer.parseInt(st.nextToken());
        int length2= Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine());
        for(int a=0; a<length1; a++){
            int value = Integer.parseInt(st.nextToken());
            if(map1.containsKey(value)){
                map1.put(value,map1.get(value)+1);
            }
            else{
                map1.put(value,1);
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int a=0; a<length2; a++){
            int value = Integer.parseInt(st.nextToken());
            if(map2.containsKey(value)){
                map2.put(value,map2.get(value)+1);
            }
            else{
                map2.put(value,1);
            }
        }

        int answer1 = 0;

        Integer[] keys1 = map1.keySet().toArray(Integer[]::new );
        Integer[] keys2 = map2.keySet().toArray(Integer[]::new );

        for(int a=0; a<keys1.length; a++){
            if(!map2.containsKey(keys1[a])){
                answer1++;
            }
        }

        for(int a=0; a<keys2.length; a++){
            if(!map1.containsKey(keys2[a])){
                answer1++;
            }
        }

        System.out.println(answer1);
    }
}