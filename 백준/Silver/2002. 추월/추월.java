import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> array = new ArrayList<String>();

        int length = Integer.parseInt(b.readLine());
        for(int a=0; a<length; a++){
            String s = b.readLine();
            array.add(s);
        }

        int answer = 0;
        int index = 0;
        for(int a=0; a<length; a++){
            String s = b.readLine();

            if(array.indexOf(s) == index){
                index +=1;
            }
            else{
                answer ++;
                array.remove(s);
            }
        }

        System.out.println(answer);


    }
}