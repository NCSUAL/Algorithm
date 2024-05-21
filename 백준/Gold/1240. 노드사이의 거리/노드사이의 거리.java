import java.util.*;
import java.io.*;

public class Main{
    static int start;
    static int end;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken()) +1;
        int event = Integer.parseInt(st.nextToken());

        board = new int[length][length];

        for(int a=0;a<length -2 ; a++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            board[p1][p2] = dist;
            board[p2][p1] = dist;
        }

        StringBuffer sb = new StringBuffer();
        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            boolean[] used = new boolean[length];


            int dist = bfs(used);
            sb.append(dist).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(boolean[] used ){
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(start,0));
        used[start] = true;

        while(!que.isEmpty()){
            Node node = que.remove();
            if(node.point == end){
                return node.dist;
            }

            for(int a=1; a<used.length; a++){
                if(board[node.point][a]!=0 && !used[a]){
                    used[a] = true;
                    que.add(new Node(a, node.dist+board[node.point][a]));
                }
            }
        }

        return -1;
    }


}

class Node{
    int point;
    int dist;

    public Node(int point, int dist){
        this.point = point;
        this.dist = dist;
    }

    @Override
    public String toString(){
        return "point: "+point+" dist: "+ dist;
    }
}