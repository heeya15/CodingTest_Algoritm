package BOJ;
import java.io.*;
import java.util.*;
// 순열 문제
public class Main_S3_15654_N과M5 {
	static int N, M;
	static int [] numbers, inputs;
	static boolean [] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 전체 원소
		M = Integer.parseInt(st.nextToken()); // 꺼낼 원소 수.
		
		inputs = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) inputs[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(inputs);
		per(0);
		System.out.println(sb);// 최종 출력.
	}
	static void per(int depth) {
		if(depth == M) { // 기저 조건
			for(int num : numbers) sb.append(num).append(" ");	
			sb.append("\n");
			return;
		}
		for(int i = 0 ; i < N; i++) {
			if(!isSelected[i]) { // i 요소가 선택되지 않았을 경우
				isSelected[i] = true;  
				numbers[depth] = inputs[i]; // i가 사용중 표시
				per(depth+1);
				isSelected[i] = false;// 다른 순열을 뽑기 위해서 i는 사용중이지 아님을 표시.
			}
		}
	}
}
