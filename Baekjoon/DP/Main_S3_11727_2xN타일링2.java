package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_11727_2xN타일링2 {
	// 2 * n -- > n 을 1~ 4까지 직접 해보면 1 3 5 11 가 나온다
	// 따라서 d[4] = d[4-1] + d[4-2]*2 = 5+6 = 11 형태가 된다. 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// dp 배열 크기는 n의 범위(1 ≤ n ≤ 1,000) 만큼 주어짐. 
		// n+2 로해줘도 가능하다.  --> n+1 할경우 14번째 초기화 배열 크기 넘치는 에러가 남.
		int [] dp = new int [n+2]; 
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2) %10007;
		}
		System.out.println(dp[n]);
	}
}
