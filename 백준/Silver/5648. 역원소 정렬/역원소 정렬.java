

import java.util.*;
import java.io.*;

public class Main {
	
	private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		long[] array = new long[N];
		
		int idx = 0;
		while(true) {
			if(st.hasMoreTokens()) {
				array[idx] = Long.parseLong( new StringBuffer(st.nextToken()).reverse().toString());
				idx++;
				if(idx == N) {
					break;
				}
			}
			else {
				st = new StringTokenizer(br.readLine());
			}
		}
		
		Arrays.sort(array);
		
		for(long arg : array) {
			System.out.println(arg);
		}
	}
}
