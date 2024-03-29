import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for(int a=0; a<length; a++){
            Long value =  Long.parseLong(br.readLine());
            if(!map.containsKey(value)){
                map.put(value,1);
            }
            else{
                map.put(value,map.get(value)+1);
            }
        }

        long answer = 0;
        int cout = 0;
        for(Long arg : map.keySet()){
            if(map.get(arg)>cout){
                answer = arg;
                cout = map.get(arg);
            }
            else if(map.get(arg)== cout ){
                answer = Math.min(answer, arg);
                cout = map.get(arg);
            }
        }


        System.out.println(answer);
    }
}