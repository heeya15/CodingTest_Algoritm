package BOJ;
import java.io.*;
import java.util.*;
// 중복 조합 문제
public class Main_S3_15652_N과M4 {
	static int N, M;
	static int [] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		comb(0,0);
		System.out.println(sb);
	}
	static void comb(int depth, int start) {
		if(depth == M) { // 기저 조건
			for(int num : numbers) sb.append(num).append(" ");	
			sb.append("\n");
			return;
		}
		for(int i = start ; i < N; i++) {
			numbers[depth] = i+1;
			comb(depth+1, i);
		}
	}
}
