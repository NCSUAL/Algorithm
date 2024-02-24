package 수정렬하기2;


//Arrays.sort(): 퀵 정렬 사용 Collections.sort(): 일반적으로 병합 정렬 사용
//시간 복잡도는 Collections가 빠름
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[length];

        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(br.readLine());
        }

        Collections.sort(Arrays.asList(array));

        for(int a=0; a<length; a++){
            sb.append(array[a]).append("\n");
        }
        System.out.println(sb);
    }
}
