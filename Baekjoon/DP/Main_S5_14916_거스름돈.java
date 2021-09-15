package DP;

import java.util.Scanner;

public class Main_S5_14916_거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long D[] = new long[N+1];
		D[0] = 0;
		D[1] = Integer.MAX_VALUE;
		for (int i = 2; i <= N; i++) {
			long min = Integer.MAX_VALUE;
			if(i>=2 && D[i-2]+1 < min) min = D[i-2]+1;
			if(i>=5 && D[i-5]+1 < min) min = D[i-5]+1;	
			D[i]=min; 
		}
		if(N==1 || N==3) {
			System.out.println(-1);
			return;
		}
		System.out.println(D[N]);		
	}
}
