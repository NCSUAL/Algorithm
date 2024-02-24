package 수강신청;


//LinkedHashSet -> contains remove add 사용가능 arraylist보다 빠름
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int event = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> stack = new LinkedHashSet<String>();

        for(int a=0; a<event; a++){
            String s = br.readLine();

            if(stack.contains(s)){
               stack.remove(s);
            }
            stack.add(s);
        }

        String[] array = stack.toArray(new String[stack.size()]);
        for(int a=0; a<array.length; a++){
            System.out.println(array[a]);
            if(a==length-1){
                break;
            }
        }
    }
}
