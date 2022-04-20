package BOJ;
import java.io.*;
import java.util.*;
/**
	1 ≤ N ≤ 100,000
	1 ≤ M ≤ 100,000
	1 ≤ i ≤ j ≤ N
	이므로 시간복잡도 O(N)이 되어야한다!!!!!
 */
public class Main_S3_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		int [] numbers = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		// N개의 수가 입력
		for(int i = 1; i <= N; i++) {
			// 배열들의 합을 누적해서 numbers 배열에 담아줌.
			numbers[i] = numbers[i-1]+Integer.parseInt(st.nextToken());
		}
		
		// 0 5 9 12 14 15 -> numbers 배열에 들어가 있음
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(numbers[end] - numbers[start-1]).append("\n");
		}
		System.out.println(sb.toString());
//		< 시간 초과 난 풀이 방법 > ....
//		// M개의 줄에는 합을 구해야하는 구간 i와 j가 주어짐.
//		for(int i =0; i< M ;i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int sum = 0;
//			for(int j = a-1 ; j < b; j++) sum += numbers[j];
//			sb.append(sum).append("\n");
//		}
//		System.out.println(sb.toString());
	}
}
