package 불;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int event = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String[] answer = new String[event];
        for(int a=0; a<event; a++){

            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            Queue<Node> que = new LinkedList<Node>();
            Queue<Node> fire_que = new LinkedList<Node>();

            char[][] board =new char[column][row];
            for(int b=0; b<column; b++){
                String s = br.readLine();
                for(int c=0; c<row; c++){
                    board[b][c] = s.charAt(c);
                    if(board[b][c]=='@'){
                        que.add(new Node(c,b,0));
                    }
                    if(board[b][c] == '*'){
                        fire_que.add(new Node(c,b,0));
                    }
                }
            }

            while(!que.isEmpty()){
                Queue<Node> current = new LinkedList<Node>();
                while(!fire_que.isEmpty()){
                    Node node = fire_que.remove();

                    for(int k=0; k<4;k ++){
                        int dx= node.x + move[k][1];
                        int dy = node.y+ move[k][0];

                        if(dx>=0 && dy>=0 && dx<row && dy<column){
                            if(board[dy][dx] =='.' || board[dy][dx] == '@'){
                                board[dy][dx] = '*';
                                current.add(new Node(dx, dy,0));
                            }
                        }
                    }
                }

                fire_que.addAll(current);
                current.clear();

                while(!que.isEmpty()){
                    Node node = que.remove();

                    for(int k=0; k<4; k++){
                        int dx = node.x + move[k][1];
                        int dy = node.y + move[k][0];

                        if(dx<0 || dy<0 || dx>=row || dy>=column){
                            answer[a] = Integer.toString(node.time+1);
                            current.clear();
                            que.clear();
                            break;
                        }

                        if(dx>=0 && dy>=0 && dx<row && dy<column && board[dy][dx] == '.'){
                            board[dy][dx] = '@';
                            current.add(new Node(dx, dy, node.time +1));
                        }
                    }
                }
                que.addAll(current);
                current.clear();

            }
        }

        for(String s : answer){
            if(s==null){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(s);
            }
        }

    }
}

class Node{
    int x;
    int y;

    int time;
    public Node(int x,int y,int time){
        this.x =x;
        this.y =y;
        this.time = time;
    }
}