package DP;
import java.util.*;
public class Main_S4_14495_피보나치비스무리한수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// int의 범위를 넘는 값을 dp배열에 담을 수 있기 때문에 long 타입으로 선언
		long [] dp = new long[117];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3 ; i<=n; i++ ) {
			dp[i] = dp[i-1] + dp[i-3];
		}
		System.out.println(dp[n-1]);
	}

}
