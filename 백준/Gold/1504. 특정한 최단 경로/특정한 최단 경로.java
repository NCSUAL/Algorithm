import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Node>[] board;
    static int nodes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        nodes = Integer.parseInt(st.nextToken());
        int event = Integer.parseInt(st.nextToken());

        board = new ArrayList[nodes+1];

        for(int a=0; a<=nodes;a++){
            board[a] = new ArrayList<Node>();
        }
        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());
            int node1 =  Integer.parseInt(st.nextToken());
            int node2 =  Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            board[node1].add(new Node( node2,dist));
            board[node2].add(new Node( node1,dist));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        boolean a = false;
        boolean b = false;

        int ans1 = 0;
        int[] k = {dijkstra(1,v1),dijkstra(v1,v2),dijkstra(v2,nodes)};

        for(int arg: k){
            ans1 += arg;
            if(arg == -1){
                a = true;
                break;
            }
        }

        int ans2 = 0;
        int[] k2 = {dijkstra(1,v2),dijkstra(v2,v1),dijkstra(v1,nodes)};


        for(int arg: k2){
            ans2 += arg;
            if(arg==-1){
                b= true;
            }
        }

        if(a && b){
            System.out.println(-1);
        }
        else if(a){
            System.out.println(ans2);
        }
        else if(b){
            System.out.println(ans1);
        }
        else{
            int c = ans1<ans2? ans1 : ans2;
            System.out.println(c);
        }

    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                return o1.dist - o2.dist;
            }
        });

        int[] costs = new int[nodes+1];
        Arrays.fill(costs,Integer.MAX_VALUE);

        costs[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node node = pq.remove();

            if(node.point == end){
                return costs[end];
            }

            for(int a=0; a<board[node.point].size(); a++){
                if(costs[board[node.point].get(a).point] > costs[node.point] + board[node.point].get(a).dist){
                    costs[board[node.point].get(a).point] = costs[node.point] + board[node.point].get(a).dist;
                    pq.add(new Node(board[node.point].get(a).point,costs[node.point] + board[node.point].get(a).dist));
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
}