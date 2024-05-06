import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] k = sc.nextLine().split(" ");

        int length = Integer.parseInt(k[0]);
        int target = Integer.parseInt(k[1]);

        Integer[] array = new Integer[length];
        for(int a=0; a<length; a++){
            array[a] = Integer.parseInt(sc.nextLine());
        }

        Integer[] arr = new Integer[target];

        if(length!= target){
            //max
            int max = -2111233214;
            for(int a : array){
                if(a> max){
                    max =a;
                }
            }

            for(int a=0; a<length; a++){
                arr[a] = array[a];
            }
            for(int a= length; a<target; a++){
                arr[a] = max;
            }

        }
        else{
            for(int a=0; a<length; a++){
                arr[a] = array[a];
            }
        }

        //정렬
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer a1, Integer a2){
                String a = Integer.toString(a1) + Integer.toString(a2);
                String b = Integer.toString(a2) + Integer.toString(a1);
                return b.compareTo(a);
            }
        });

        String answer = "";
        for(int a: arr){
            answer += Integer.toString(a);
        }

        System.out.println(answer);
    }

}