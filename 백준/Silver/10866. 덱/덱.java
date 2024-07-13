import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int event = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<Integer>();
        StringTokenizer st;
        StringBuffer answer = new StringBuffer();
        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    answer.append(deque.isEmpty()? -1: deque.peekFirst()).append("\n");
                    break;
                case "back":
                    answer.append(deque.isEmpty()? -1: deque.peekLast()).append("\n");
                    break;
                case "size":
                    answer.append(deque.size()).append("\n");
                    break;
                case "empty":
                    answer.append(deque.isEmpty()?1 : 0).append("\n");
                    break;
                case "pop_front":
                    answer.append(deque.isEmpty()?-1 :deque.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    answer.append(deque.isEmpty()? -1 : deque.removeLast()).append("\n");
                    break;
            }
        }

        System.out.println(answer);
    }
}