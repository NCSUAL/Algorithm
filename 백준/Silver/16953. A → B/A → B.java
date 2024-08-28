
import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        Queue<Node> que=  new LinkedList<Node>();
        que.add(new Node(0,start));

        while(!que.isEmpty()){
            Node node = que.remove();

            if(node.point == end){
                System.out.println(node.count+1);
                System.exit(0);
            }
            else if(node.point > end){
                continue;
            }
            que.add(new Node( node.count+1,node.point*2));
            que.add(new Node( node.count+1,Long.parseLong(Long.toString((node.point))+'1')));
        }
        System.out.println(-1);

    }
}

class Node{
    long count;
    long point;

    public Node(long count, long point){
        this.count = count;
        this.point = point;
    }

    @Override
    public String toString(){
        return "count: " + this.count +" point: " + this.point;
    }
}