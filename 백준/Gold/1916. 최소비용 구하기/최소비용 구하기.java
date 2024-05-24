import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Node>[] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodes = Integer.parseInt(br.readLine())+1;
        int event = Integer.parseInt(br.readLine());
        int[] dists = new int[nodes];
        board = new ArrayList[nodes];
        for(int a=0; a<nodes;a++){
            board[a] = new ArrayList<Node>();
            dists[a] = Integer.MAX_VALUE;
        }

        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pr_que = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node a1, Node a2){
                return a1.dist - a2.dist;
            }
        });

        pr_que.add(new Node(start,0));

        dists[start] =  0;
        boolean[] used = new boolean[nodes];
        while(!pr_que.isEmpty()){
            Node node = pr_que.remove();

            if(node.point == end){
                System.out.println(node.dist);
                System.exit(0);
            }

            if(used[node.point]){
                continue;
            }

            used[node.point] = true;

            for(int a=0; a<board[node.point].size(); a++){
                if(dists[board[node.point].get(a).point]>dists[node.point] + board[node.point].get(a).dist){
                    dists[board[node.point].get(a).point] = dists[node.point] + board[node.point].get(a).dist;
                    pr_que.add(new Node(board[node.point].get(a).point,dists[board[node.point].get(a).point] ));
                }
            }
        }
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