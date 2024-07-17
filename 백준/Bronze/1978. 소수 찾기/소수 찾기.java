import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        int[] array = new int[length];

        String[] s = br.readLine().split(" ");
        int answer = 0;

        for(int a=0; a<length; a++){
            if(isright(Integer.parseInt(s[a]))){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isright(int k){
        if(k<=1){
            return false;
        }
        else {
            for (int a = 2; a <= Math.sqrt(k); a++) {
                if (k % a == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}

