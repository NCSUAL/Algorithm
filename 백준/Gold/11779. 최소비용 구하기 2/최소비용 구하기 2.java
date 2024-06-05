import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Node>[] arrayLists;
    static int[] target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());
        int event = Integer.parseInt(br.readLine());

        arrayLists = new ArrayList[nodes+1];
        target = new int[nodes+1];
        int[] dists = new int[nodes+1];

        for(int a=0; a<=nodes; a++){
            dists[a] = Integer.MAX_VALUE;
            arrayLists[a] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());

            arrayLists[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        st= new StringTokenizer(br.readLine());
        int start =Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] used=  new boolean[nodes+1];
        PriorityQueue<Node> pr_queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                return o1.dist - o2.dist;
            }
        });

        pr_queue.add(new Node(start,0));
        dists[start] =0;
        while(!pr_queue.isEmpty()){
            Node node = pr_queue.remove();
            if(node.point == end){
                System.out.println(node.dist);
                break;
            }

            if(used[node.point]){
                continue;
            }

            used[node.point] = true;
            for(int a=0; a<arrayLists[node.point].size(); a++){
                if(dists[arrayLists[node.point].get(a).point] >= dists[node.point] + arrayLists[node.point].get(a).dist){
                    dists[arrayLists[node.point].get(a).point] = dists[node.point] + arrayLists[node.point].get(a).dist;
                    target[arrayLists[node.point].get(a).point] = node.point;
                    pr_queue.add(new Node(arrayLists[node.point].get(a).point, dists[arrayLists[node.point].get(a).point]));
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        target[start] = 0;
        int target_start = end;
        int target_end = start;

        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        while(target_start!=0){
            count ++;
            stack.push(target_start);
            target_start = target[target_start];
        }


        System.out.println(count);

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
}

class Node{
    int point;
    int dist;

    public Node(int point, int dist){
        this.point = point;
        this.dist =dist;
    }

    @Override
    public String toString(){
        return "point: "+point +", dist: "+dist;
    }
}