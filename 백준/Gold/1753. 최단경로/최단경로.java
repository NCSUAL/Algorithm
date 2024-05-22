import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Node>[] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) +1;
        int event = Integer.parseInt(st.nextToken());

        board = new ArrayList[N];
        PriorityQueue<Node> pr_que = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                return o1.dist - o2.dist;
            }
        });
        int start =Integer.parseInt(br.readLine());
        pr_que.add(new Node(start,0));

        StringBuffer answer = new StringBuffer();

        int[] dists = new int[N];

        for(int a=0; a<N; a++){
            dists[a] = Integer.MAX_VALUE;
            board[a] = new ArrayList<Node>();
        }
        for(int a=0; a<event; a++){
           st = new StringTokenizer(br.readLine());
           board[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        dists[start] = 0;

        boolean[] used = new boolean[N];

        while(!pr_que.isEmpty()){
            Node node = pr_que.remove();
            if(used[node.point]){
                continue;
            }

            used[node.point] = true;
            for(int a=0; a<board[node.point].size(); a++){
                if(dists[board[node.point].get(a).point]> dists[node.point] + board[node.point].get(a).dist){
                        dists[board[node.point].get(a).point] = dists[node.point] + board[node.point].get(a).dist;
                        pr_que.add(new Node(board[node.point].get(a).point, dists[board[node.point].get(a).point]));
                }
            }

        }

        for(int a=1; a<N; a++){
            if(dists[a] == Integer.MAX_VALUE){
                answer.append("INF").append("\n");
            }
            else{
                answer.append(dists[a]).append("\n");
            }
        }

        System.out.println(answer);
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
        return "point: "+ point +" , dist: "+  dist;
    }
}
