package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_11720_숫자의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //숫자의 개수 저장.
		String num = br.readLine(); 
		int sum = 0; // 숫자 N개의 합을 저장받을 변수
		//숫자 N개가 주어짐
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i)-'0'; 
		}
		System.out.println(sum);
	}
}
