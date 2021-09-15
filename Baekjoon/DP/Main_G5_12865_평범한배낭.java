package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_12865_평범한배낭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 담을 수 있는 무게
		int [] weight = new int[N+1]; //물건의 무게를 담을 배열
		int [] profits = new int[N+1]; // 물건의 가치를 담을 배열
 		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			weight[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
 		int dp[][] = new int[N+1][K+1];
 		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				if(weight[i] <=w) { // 해당 무게를 
					dp[i][w] = Math.max(dp[i-1][w],profits[i]+dp[i-1][w-weight[i]]);
				}else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
// 		for (int i = 1; i <= N; i++) {
//			for (int w = 1; w <= K; w++) {
//				System.out.print(dp[i][w]+" ");
//			}
//			System.out.println();
//		}
 		System.out.println(dp[N][K]);	
	}
}
