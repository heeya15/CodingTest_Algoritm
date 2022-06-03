package BaekJoon_self;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B4_10156_과자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken()); // 과자 한개의 가격
		int N = Integer.parseInt(st.nextToken()); // 사려고 하는 과자의 개수
		int M = Integer.parseInt(st.nextToken()); // 현재 동수가 가진 돈
		if(M >= (K*N)) System.out.println(0);
		else System.out.println((K * N) - M);	
	}
}
