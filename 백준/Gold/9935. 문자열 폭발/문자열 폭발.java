import org.w3c.dom.Node;

import  java.util.*;
import java.io.*;

public class Main{
    static String s;
    static String boom;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        boom = br.readLine();

        Stack<Character> stack = new Stack<Character>();

        for(int a=0; a<s.length(); a++){
            stack.push(s.charAt(a));
            if(stack.size() >= boom.length()){
                boolean iscontain = true;

                for(int b=0; b<boom.length(); b++){
                    if(stack.get(stack.size()-boom.length()+b) != boom.charAt(b)){
                        iscontain = false;
                        break;
                    }
                }

                if(iscontain){
                    for(int b=0; b<boom.length(); b++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty()){
            sb.append("FRULA");
            System.out.println(sb);
        }
        else{
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse().toString());
        }

    }

}