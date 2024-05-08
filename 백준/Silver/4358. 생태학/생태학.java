import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String s = br.readLine();
        while(s!= null){
            length ++;
            if(map.containsKey(s)){
                map.put(s,map.get(s) +1);
            }
            else{
                map.put(s,1);
            }

            s = br.readLine();
        }

        String[] keys = map.keySet().toArray(String[] :: new );
        Arrays.sort(keys);

        for(String arg: keys){
            double value = Math.round(( ((double)map.get(arg)/length) * 100 ) * 10000 )/10000.0;
            System.out.println(arg+" "+ String.format("%.4f",value));
        }
    }
}