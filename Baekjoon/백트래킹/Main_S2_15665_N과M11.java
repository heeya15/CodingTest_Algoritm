package BOJ;
import java.io.*;
import java.util.*;

// 중복 순열 문제
public class Main_S2_15665_N과M11 {
	static int N,M ;
	static int [] inputs,numbers;
	static LinkedHashSet<String> set ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set =  new LinkedHashSet<String>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 전체 원소
		M = Integer.parseInt(st.nextToken()); // 꺼낼 원소 수.
		inputs = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) inputs[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(inputs);// 수열은 사전 순으로 증가하는 순서로 출력해야해서 미리 오름차순으로 수열을 정렬
		
		per(0);
		StringBuilder sb = new StringBuilder();
		for (String line : set) sb.append(line).append("\n");
		System.out.println(sb);// 최종 출력.
	}
	private static void per(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int num : numbers) sb.append(num).append(" "); 		
			set.add(sb.toString()); // 중복값이 있을경우 안 넣음.
			return;
		}
		for (int i = 0; i < N; i++) {
			numbers[depth] = inputs[i];
			per(depth+1);
		}
	}
}
