package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_1003_피보나치함수 {
	/**
	 * - n을 0부터 시작해서 - 1씩 값을 올려 결과를 얻으면 아래처럼 일정한 규칙이 보이게 됩니다. 
	 *      < 0 호출 횟수 >     < 1 호출 횟수>
	 * n(0) -> zero[0] = 1 , one[0] = 0  
	 * n(1) -> zero[1] = 0 , one[1] = 1
	 * n(2) -> zero[2] = 1 , one[2] = 1
	 * n(3) -> zero[3] = 1 , one[2] = 2
	 * n(4) -> zero[4] = 2 , one[3] = 3
	 * n(5) -> zero[5] = 3 , one[3] = 5
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수.
		Integer[] zeroNum = new Integer[41]; // 0 호출 횟수 저장.
		Integer[] oneNum = new Integer[41];  // 1 호출 횟수 저장.
		//n이 --> 0과 ,1인 경우 호출되는 횟수 미리 초기화.
		zeroNum[0] = 1; zeroNum[1] = 0;
		oneNum[0] = 0; oneNum[1] = 1;
		// 테스트 케이스 수 만큼 반복.
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			// DP 반복문(Bottom-Up)을 사용.
			for (int j = 2; j <= num; j++) { // 2 부터 시작. 0과 1은 미리 초기화 해 둠.
				zeroNum[j] = zeroNum[j - 2] + zeroNum[j - 1]; // dp 점화식.
				oneNum[j] = oneNum[j - 2] + oneNum[j - 1];
			}
			sb.append(zeroNum[num]).append(" ").append(oneNum[num]).append("\n");
		}
		System.out.println(sb);
	}
}
