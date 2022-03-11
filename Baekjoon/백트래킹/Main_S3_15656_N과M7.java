package BOJ;
import java.io.*;
import java.util.*;
// 중복 순열 문제
public class Main_S3_15656_N과M7 {
	static int N, M;
	static int [] numbers, inputs;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 전체 원소
		M = Integer.parseInt(st.nextToken()); // 꺼낼 원소 수.
		
		inputs = new int[N];
		numbers = new int[M];
	
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) inputs[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(inputs); // 수열은 사전 순으로 증가하는 순서로 출력해야해서 미리 오름차순으로 수열을 정렬
		per(0);
		System.out.println(sb);// 최종 출력.
	}
	static void per(int depth) {
		if(depth == M) {
			for(int num : numbers) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			numbers[depth] = inputs[i];
			per(depth+1);
		}
	}
}
