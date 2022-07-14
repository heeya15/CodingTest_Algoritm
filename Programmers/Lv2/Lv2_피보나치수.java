package Programmers;

/**
 * Lv2_피보나치 수( DP 문제 )
 * ( 문제 설명 )
 * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 * 예를들어
 * F(2) = F(0) + F(1) = 0 + 1 = 1
 * F(3) = F(1) + F(2) = 1 + 1 = 2
 * F(4) = F(2) + F(3) = 1 + 2 = 3
 * F(5) = F(3) + F(4) = 2 + 3 = 5 와 같이 이어집니다.
 * 
 * ( 문제 풀이 ) 
 * 피보나치 수는 첫 번째 항과, 두 번째 항은 0 과 1 로 고정이다.
 * 또한 피노바치 수의 규칙은 이전 항과, 이전 항의 이전 항의 합으로 이루어진 수열을 그대로 점화식을 세워 풀면 된다.
**/
public class Lv2_피보나치수 {
	public static void main(String[] args) {
		System.out.println(solution(3)); // 답 :2
		System.out.println(solution(5)); // 답 :5
	}

	public static int solution(int n) {
        int [] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}