
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String[] array = new String[length];
        for(int a=0; a<length; a++){
            array[a] = br.readLine();
        }

        Arrays.sort(array,Collections.reverseOrder());

        HashSet<String> set = new HashSet<String>();
        for(String arg: array){
            if(set.isEmpty()){
                set.add(arg);
            }
            else{
                boolean found = false;
                for(String arg2: set){
                    if(arg2.indexOf(arg)==0){
                        found = true;
                        break;
                    }
                }

                if(!found){
                    set.add(arg);
                }
            }
        }


        System.out.println(set.size());
    }
}