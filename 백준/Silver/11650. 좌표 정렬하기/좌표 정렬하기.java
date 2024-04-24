import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[length];

        StringTokenizer st;
        for(int a=0; a<length; a++){
            st= new StringTokenizer(br.readLine());
            nodes[a] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

       Arrays.sort(nodes,new Comparator<Node>(){
            @Override
            public int compare(Node a1, Node a2){
                if(a1.x == a2.x){
                    return a1.y - a2.y;
                }
                else{
                    return a1.x - a2.x;
                }
            }
        });

        for(int a=0; a<nodes.length; a++){
            System.out.println(nodes[a]);
        }
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return x+ " "+ y;
    }
}
