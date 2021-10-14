package JungOl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_문제은행_1169_주사위던지기1 {
	static int N, M;
	static int numbers[] ;
	static boolean [] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 주사위를 던진 횟수
		M = Integer.parseInt(st.nextToken()); // 출력 모양
		numbers = new int[N];
		isSelected = new boolean[6+1];
		if(M == 1) per1(0); // 중복순열
		else if(M==2) comb(0,1); // 중복 조합
		else if(M==3) per2(0);	 // 순열	
		System.out.println(sb);	
	}
	private static void per1(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			per1(cnt+1);
		}
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= 6; i++) {
				numbers[cnt] = i;
				comb(cnt+1, i);
		}	
	}
	
	private static void per2(int cnt) {
		if(cnt == N)  // 우리가 던진 주사위 횟수와 같아지면
		{
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= 6; i++) { // 주사위는 1~ 6까지 가능한거 반복.
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			per2(cnt+1);
			isSelected[i] = false;
		}		
	}
}
