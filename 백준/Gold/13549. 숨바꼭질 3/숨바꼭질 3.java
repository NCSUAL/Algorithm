import java.util.*;
import java.io.*;

public class Main{
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        boolean[] used = new boolean[100001];
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(start,0));
        used[start] = true;

        while(!que.isEmpty()){
            Node node = que.remove();

            if(node.point == end){
                min = Math.min(min,node.dist);
            }

            if((node.point *2) <= 100000 && !used[node.point*2]){
                que.add(new Node(node.point*2,node.dist));
                used[node.point*2] = true;
            }

            if(node.point-1 >= 0 && !used[node.point-1]){
                que.add(new Node(node.point-1, node.dist+1));
                used[node.point-1] = true;
            }

            if(node.point+1 <= 100000 && !used[node.point+1]){
                que.add(new Node(node.point+1, node.dist+1));
                used[node.point+1] = true;
            }
        }
        System.out.println(min);
    }
}

class Node{
    int point;
    int dist;

    public Node(int point, int dist){
        this.point = point;
        this.dist = dist;
    }

}

