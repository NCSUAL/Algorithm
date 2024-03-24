import java.util.*;

class Solution {
    static ArrayList<Contain> current = new ArrayList<Contain>(); 
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] board = new int[103][103];
        
        for(int[] arg: rectangle){
            draw(arg,board);
        }
        
        int[] start = {characterX*2,characterY*2};
        int[] end = {itemX*2,itemY*2};
        
        int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(start[0],start[1]));
        
        while(!que.isEmpty()){
           Node arg = que.remove();
            
            if(arg.getX()==end[0] && arg.getY()==end[1]){
                break;
            }
            
            for(int a=0; a<move.length; a++){
                int dy = arg.getY() + move[a][0];
                int dx = arg.getX() + move[a][1];
                
                if(dx>0 && dy >0 && dx<103 && dy<103 && board[dy][dx] == 1){
                    board[dy][dx] = board[arg.getY()][arg.getX()] +1 ;
                    que.add(new Node(dx, dy));
                }
            }

        }
        
        /**
        //출력
        for(int a=0; a<30; a++){
            for(int b=0; b<30; b++){
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
        */
        return board[end[1]][end[0]]/2;
    }
    
    public static void draw(int[] rec,int[][] board){
        int[] start = new int[] {rec[0]*2,rec[1]*2};
        int[] end = new int[] {rec[2]*2,rec[3]*2};
        
        
        for(int a= start[1]; a<=end[1]; a++){
            for(int b= start[0]; b<=end[0]; b++){
                if(a==start[1] && !check(b,a)){
                    board[a][b] = 1;
                }
                else if(a==end[1] && !check(b,a)){
                    board[a][b] = 1;
                }
                else if(b== start[0] && !check(b,a) ){
                    board[a][b] = 1;
                }
                else if(b== end[0] && !check(b,a) ){
                    board[a][b] = 1;
                }
                else{
                    board[a][b] = 0;
                }
            } 
        }
        
        current.add(new Contain(new int[]{start[0],end[0]},new int[]{start[1],end[1]}));
    }
    
    public static boolean check(int x, int y){
        if(current.size() == 0){
            return false;
        }
        else{
            for(int a=0; a<current.size(); a++){
                if(current.get(a).contains(x,y)){
                    return true;
                }
            }
            return false;
        }
    }
    
}

class Node{
    private int x;
    private int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}

class Contain{
    private int[] x;
    private int[] y;
    
    public Contain(int[] x, int[] y){
        this.x = x;
        this.y = y;
    }
    
    public boolean contains(int x, int y){
        if(x>this.x[0] && x<this.x[1] && y>this.y[0] && y<this.y[1]){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "x: " + Arrays.toString(x) + " y: "+ Arrays.toString(y); 
    }
}