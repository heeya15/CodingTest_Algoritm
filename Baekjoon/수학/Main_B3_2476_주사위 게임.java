package 수학;

import java.util.*;
import java.io.*;

public class Main_B3_2476_주사위게임 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 참여하는 사람의 수
		int result = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int sum = 0;
			// 같은 눈이 3개가 나올 때
			if(a == b && a == c && b== c) sum = 10000 + (a * 1000);
			
			// 같은 눈이 2개가 나올 때
			if(a == b && a != c) sum = 1000 + (a * 100);
			if(a != b && a == c) sum = 1000 + (a * 100);
			if(a != b && b == c ) sum = 1000 + (b * 100);
				
			// 모두 다른 눈이 나오는 경우
			if(a != b && a != c && b !=c) sum = Math.max(c, Math.max(a, b)) *100;
			
			result = Math.max(result, sum); 
		}
		System.out.println(result); // 가장 많은 상금을 받은 사람의 상금 출력.
	}
}