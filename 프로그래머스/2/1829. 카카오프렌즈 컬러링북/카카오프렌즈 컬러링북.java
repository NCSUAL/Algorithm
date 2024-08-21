import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
    Queue<Node> que = new LinkedList<Node>();
    int maxY;
    int maxX;
    List<Integer> answer = new ArrayList<Integer>();
        maxY = m;
        maxX = n;
        boolean[][] used = new boolean[m][n];
        
        int count = 0;
        for(int a=0; a<m; a++){
            for(int b=0; b<n; b++){
                if(!used[a][b] && picture[a][b] !=0){
                    count++;
                    que.add(new Node(b,a,picture[a][b]));
                    bfs(picture,used,maxX,maxY,answer,que);
                }
            }
        }
        
        System.out.println(answer);
        int[] answers = new int[2];
        answers[0] = count;
        answers[1] = Collections.max(answer);
        return answers;
    }
    
    public void bfs(int[][] pictures, boolean[][] used,int maxX,int maxY,List<Integer> answer,Queue<Node> que){
        int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 0;
        while(!que.isEmpty()){
            Node node = que.remove();
            
            for(int a=0; a<4; a++){
                int dy = node.y + move[a][1];
                int dx = node.x + move[a][0];
                
                if(dx>=0 && dy>=0 && dy<maxY && dx<maxX){
                    if(!used[dy][dx] && pictures[dy][dx] == node.value){
                        que.add(new Node(dx,dy,node.value));
                        count++;
                        used[dy][dx] = true;
                    }
                }
            }
        }
        answer.add(count);
    }
    
    
}
class Node{
        int y;
        int x;
        int value;
        public Node(int x, int y,int value){
            this. y= y;
            this. x= x;
            this.value = value;
        }
}