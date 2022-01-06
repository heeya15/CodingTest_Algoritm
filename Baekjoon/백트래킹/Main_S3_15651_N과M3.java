package 백트래킹;
import java.io.*;
import java.util.*;
public class Main_S3_15651_N과M3 {
	static int N,M;
	static int [] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int [M];	
		per(0);
		System.out.println(sb);
	}
	private static void per(int cnt) { // 중복 순열 함수
		if(cnt == M) {
			for( int num : numbers) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}	
		for (int i = 0; i < N; i++) {
			numbers[cnt] = i+1;
			per(cnt+1);	
		}
	}
}
