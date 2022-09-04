package 수학;

import java.util.*;
import java.io.*;

public class Main_B3_10103_주사위게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
		int N = Integer.parseInt(st.nextToken());  // 라운드 수
		int [] jumsu = new int[2];
		jumsu[0] = 100; // 창영
		jumsu[1] = 100; // 상덕
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int changyung = Integer.parseInt(st.nextToken()); // 창영
			int sangduck = Integer.parseInt(st.nextToken());  // 상덕
			if (changyung < sangduck) jumsu[0] -= sangduck;
			else if(changyung > sangduck) jumsu[1] -= changyung;
			else continue;
		}
		System.out.println(jumsu[0]); // 창영이 점수
		System.out.println(jumsu[1]); // 상덕이 점수
	}
}