package Programmers;

/**
	칸이 1개 있을때 방법 1가지 ((1))
	칸이 2개 있을때 방법 2가지 ((1,1), (2))
	칸이 3개 있을때 방법 3가지 ((1,1,1), (1,2) , (2,1))
	규칙이 피보나치 순열 규칙이다. 앞 두수를 더해서 다음 수를 만들어냄
**/
public class Lv2_멀리뛰기 {
	public static void main(String[] args) {
		System.out.println(solution(4)); // 답 : 5
		System.out.println(solution(3)); // 답 : 3
	}

	public static long solution(int n) {
		long[] dp = new long[2001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < 2001; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
		}
		return dp[n];
	}
}