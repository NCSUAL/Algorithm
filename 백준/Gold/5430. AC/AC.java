import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int event = Integer.parseInt(br.readLine());


        for(int a=0; a<event; a++){
            //명령어
            String s = br.readLine();

            //배열 갯수
            int length = Integer.parseInt(br.readLine());

            //배열
            String s_arr = br.readLine();

            Integer[] array = new Integer[length];
            Deque<Integer> que = new LinkedList<Integer>();
            Deque<Integer> que_reverse = new LinkedList<Integer>();
            if(s_arr.length()>2){
                String[] convert = s_arr.substring(1,s_arr.length()-1).split(",");
                for(int k =0; k<length; k++){
                    array[k] = Integer.parseInt(convert[k]);
                }

                for(int arg: array){
                    que.add(arg);
                }

                Collections.reverse(Arrays.asList(array));

                for(int arg: array){
                    que_reverse.add(arg);
                }
            }

            boolean reverse = false;
            boolean error = false;

            for(int b=0; b<s.length(); b++){
                char value = s.charAt(b);

                if(value == 'R'){
                    if(!reverse){
                        reverse = true;
                    }
                    else{
                        reverse = false;
                    }
                }
                else{
                    if(length ==0){
                        error = true;
                        break;
                    }
                    else{
                        if(!reverse){
                            que.removeFirst();
                            que_reverse.removeLast();
                        }
                        else{
                            que_reverse.removeFirst();
                            que.removeLast();
                        }
                        length -=1;
                    }
                }
            }

            if(error){
                sb.append("error").append("\n");
            }
            else{
                sb.append("[");

                for(int b=0; b<length; b++){
                    sb.append(!reverse? que.removeFirst() : que_reverse.removeFirst()).append(b==length-1? "": ",");
                }

                sb.append("]");
                sb.append("\n");
            }


        }

        System.out.println(sb);
    }
}