package BOJ;
import java.io.*;
import java.util.*;
public class Main_S2_15666_N과M12 {
	static int N,M;
	static int [] inputs, numbers;
	// 중복된 수열을 저장 받지 않으려고 LinkedHashSet 사용.
	static LinkedHashSet<String> set = new LinkedHashSet<String>(); // 입력된 순서대로 데이터를 관리 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// N과 M이 주어짐
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		numbers = new int[M];  // M개를 고른 수열을 담는 용도의 배열 초기화.
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i= 0 ; i< N; i++) inputs[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(inputs); // 수열은 사전 순으로 증가하는 순서로 출력해야 하여서 오름차순으로 정렬
		
		comb(0, 0);
		StringBuilder sb = new StringBuilder();
		for(String number : set) sb.append(number);
		
		System.out.println(sb.toString());
	}
	// 중복 조합 문제.
	public static void comb(int depth, int start) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			set.add(sb.toString());// 중복값이 있을경우 안 넣음.
			return;
		}
		for(int i = start; i < N; i++) {
			numbers[depth] = inputs[i];
			comb(depth+1, i);
		}
	}
}
