package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 백트래킹 = 순열
public class Main_S3_18429_근손실 {
	static int N, K;
	static int[] kit, inputs;
	static boolean[] isSelected;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N일 동안 N 개의 운동 키트
		K = Integer.parseInt(st.nextToken()); // 하루에 감소 중량
		inputs = new int[N]; // 중량 증가량 입력 받을 배열.
		kit = new int[N];    // 키드 번호 저장할 배열
		isSelected = new boolean[N]; // 해당 키트 순서.
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		per(0);
		System.out.println(count);
	}
	static void per(int index) {	
		if (index == N) { // kit의 갯수와 같을 경우
			int weight = 500;
			for (int j = 0; j < N; j++) {
				weight += inputs[kit[j]];
				weight -= K;
				// N일차까지 하루마다 중량이 500보다작아질 경우 재귀 호출한 곳으로 return;
				if (weight < 500) return;	
			}
			count++; // 항상 중량이 500이상 되도록 하는 경우의 수 세어줌
			return;
		}

		for (int i = 0; i < N; i++) { // 키트의 갯수 만큼
			if(!isSelected[i]) {
				isSelected[i] = true;
				kit[index] = i;
				per(index + 1);
				isSelected[i] = false;
			}

		}
	}
}
