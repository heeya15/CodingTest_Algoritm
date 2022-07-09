package Programmers;
/**
 * Lv2_2xn 타일링 - DP 문제.
 **/
public class Lv2_2xn타일링 {
	public static void main(String[] args) {
		System.out.println(solution(0)); // 답 : 0
		System.out.println(solution(4)); // 답 : 5
		System.out.println(solution(5)); // 답 : 8
	}

	public static int solution(int n) {
		int answer = 0;
		int[] dp = new int[n + 3];
		// n 을 1~ 4까지 직접 해보면 1 2 3 5 의 직사각형 채우는 방법의 수가 나온다.
		// 따라서 규칙이 1번째 인덱스, 2번째 인덱스 를 더하면 -> 3번째 인덱스의 값이라는 규칙성을 발견. 
		// -> 따라서 피보나치 수열을 활용함.
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007; // 마지막에 나눠주면 overflow가 나기 때문에 계산 과정에서 나눔
		}
		answer = dp[n];
		return answer;
	}
}