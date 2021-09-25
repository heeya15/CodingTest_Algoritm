package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_11399_ATM {
	static int[] people_time;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 사람 수

		people_time = new int[N + 1]; // 사람이 돈을 인출하는데 걸리는 시간.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			people_time[i] = Integer.parseInt(st.nextToken()); // 인출하는데 걸리는 시간.
		}
		// 초기 최소값 설정.(들어온 순서대로 그냥했음)
		int min = 0;
		// 제일 시간이 적게 걸리는 것을 앞에 오도록 정렬 -- 오름 차순으로.
		Arrays.sort(people_time);
		int sum = 0;
		for (int i = 1; i < N+1; i++) {
			min += people_time[i];
			sum += min;
		}
		// 다른 방법 코드
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= i; j++) {
//				sum +=people_time[j];
//			}
//		}
		System.out.println(sum);
	}	
}
