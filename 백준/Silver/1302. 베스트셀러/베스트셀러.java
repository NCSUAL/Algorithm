import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int a=0; a<length; a++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,1) +1);
        }

        String[] array = map.keySet().toArray(String[] :: new);
        Arrays.sort(array, new Comparator<String>(){
           @Override
           public int compare(String a1, String a2){
               int a = map.get(a2);
               int b = map.get(a1);

               if(a==b){
                   return a1.compareTo(a2);
               }
               else{
                   return a-b;
               }
           }
        });

        System.out.println(array[0]);
    }
}