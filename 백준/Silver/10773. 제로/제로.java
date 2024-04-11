import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int a=0; a<length; a++){
            int value = Integer.parseInt(br.readLine());
            if(value ==0){
                stack.pop();
            }
            else{
                stack.push(value);
            }
        }

        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);


    }
}