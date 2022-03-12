package BOJ;
import java.io.*;
import java.util.*;
// 중복 조합 문제
public class Main_S3_15657_N과M8 {
	static int N,M;
	static int [] inputs, numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 전체 원소
		M = Integer.parseInt(st.nextToken()); // 꺼낼 원소 수.
		inputs = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) inputs[i] = Integer.parseInt(st.nextToken());
			
		Arrays.sort(inputs); // 수열은 사전 순으로 증가하는 순서로 출력해야해서 미리 오름차순으로 수열을 정렬
		comb(0,0);
		System.out.println(sb); // 최종 출력.
	}
	
	public static void comb(int depth, int start) {
		if(depth == M) {
			for(int num : numbers) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = start; i < N; i++ ) {
			numbers[depth] = inputs[i];
			comb(depth+1, i);
		}
	}

}
