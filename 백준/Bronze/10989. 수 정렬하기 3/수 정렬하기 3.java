import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        int[] array = new int[10001];

        for(int a=0; a<length; a++){
            array[Integer.parseInt(br.readLine())] +=1;
        }

        StringBuffer sb = new StringBuffer();

        for(int a=1; a<10001; a++){
            for(int b=0; b<array[a]; b++){
                sb.append(a).append("\n");
            }
        }
        System.out.println(sb);
    }

}

