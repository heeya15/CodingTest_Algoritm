package BOJ;
import java.io.*;
import java.util.*;
/**
 * 문제 대로 B는 그대로 두고, A 배열을 순열을 이용하여 최소값을 구하려 했지만 시간초과가 남...
 * 예를 들어 이 문제의 출제 의도에는 "A만 재배열할 때의 답을 구하는 것이 
 * A와 B를 둘 다 재배열할 때의 답을 구하는 것과 동치임을 알아낼 수 있는가"를 시험하는 것이 포함
 * 그걸 알아내야 이 문제를 쉽게 풀 수 있고, 실제로 문제를 풀 때 A와 B를 어떻게 처리하든지 그 과정은 완전히 프로그래머의 자유입니다.
 * 출력한 답이 "A만 재배열할 때의 답"과 같기만 하면 됨
 *
 */
public class Main_S4_1026_보물 {
	static int N;
	static int [] A, B, numbers;
	static boolean [] isSelected;
	static int S = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		A = new int[N];
		B = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		// A의 수만 재배열 가능 , B의 수 재배열 X.
		for(int i = 0; i< N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< N; i++) B[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		Arrays.sort(B);
		// A는 오름차순, B는 내림차순으로 정렬 후 계산
		for(int i = 0; i< N ; i++) {
			S += A[i] * B[N-i-1];
		}
//		per(0,numbers);
		System.out.println(S);
	}
	
//	 순열방법
//	public static void per(int depth, int [] numbers) {
//		if(depth==N) {
//			int sum = 0;
//			for(int i=0; i< N; i++) sum += numbers[i] * B[i];	
//			S = Math.min(S, sum);
//			return;
//		}
//		for (int i = 0; i <N; i++) {
//			if(!isSelected[i]) {
//				isSelected[i] = true;
//				numbers[depth] = A[i];
//				per(depth+1, numbers);
//				isSelected[i] = false;
//			}
//		}
//	}
}
