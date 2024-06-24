import java.util.*;
import java.io.*;

/**
 * 해설
 * 조건: k 번째로 가장 짧은 경로를 선택해야 함
 * 2번째로 가장 짧은 경로를 선택해야 함
 *
 * 우선순위 큐 선언 : [] (오름차순 정렬)
 * 1에서 2로 갈 때(가정) 경로가 1
 * 크기가 K보다 작을 땐 넣기
 * 큐: [1]
 *
 * 경로가 2
 * 큐: [2,1]
 *
 * 크기가 같거나 클 때는 맨 앞 요소랑 비교
 *
 * 경로가 1.5
 * 2> 1.5
 * 큐: [1.5,1]
 */
public class Main{
    static ArrayList<Node>[] board;
    static PriorityQueue<Integer>[] pr_que;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken())+1;
        int event = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new ArrayList[nodes];
        pr_que = new PriorityQueue[nodes];

        for(int a=0; a<nodes; a++){
            board[a] = new ArrayList<Node>();
            pr_que[a] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int a=0; a<event; a++){
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2){
                return o1.dist - o2.dist;
            }
        });

        pr_que[1].add(0);
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node node = pq.remove();

            for(int a=0; a<board[node.point].size(); a++){
                if(pr_que[board[node.point].get(a).point].size() < k){
                    pr_que[board[node.point].get(a).point].add(node.dist + board[node.point].get(a).dist);
                    pq.add(new Node(board[node.point].get(a).point,node.dist + board[node.point].get(a).dist ));
                }
                else if(pr_que[board[node.point].get(a).point].peek() > node.dist + board[node.point].get(a).dist){
                    pr_que[board[node.point].get(a).point].remove();
                    pr_que[board[node.point].get(a).point].add(node.dist + board[node.point].get(a).dist);
                    pq.add(new Node(board[node.point].get(a).point,node.dist + board[node.point].get(a).dist ));
                }
            }
        }

        for(int a=1; a<nodes; a++){
            if(pr_que[a].size()!=k){
                System.out.println(-1);
            }
            else{
                System.out.println(pr_que[a].remove());
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
