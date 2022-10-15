package 수학;

import java.io.*;
import java.util.*;
/**
 * 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것(앞당긴다는 뜻)
 */
public class Main_B3_2884_알람시계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int temp = Integer.parseInt(st.nextToken());
		// 시간과 분을 -> 초로 만들어줌.
		int H = temp > 0  ? temp * 3600 : 24 * 3600; // 0 시간이라는 뜻은 24시라는 뜻으로 24를 시간으로 취급하여 초를 만든다.
		int M = Integer.parseInt(st.nextToken()) * 60;
		int Time = (H+M) - (45 *60);
		// 초를 -> 시간 및 분으로 변환
		// 0 45 입력 받을 경우 24시 0이 된다. 하지만 시간 범위는 23시 까지임으로 24시인경우 0으로 바꿔준다. -> 주의.
		int Hour = Time / 3600 == 24 ? 0 : Time / 3600; 
		Time = Time % 3600;
		int Min = Time / 60;	
		// 정답 출력
		System.out.println(Hour + " " + Min);
	}
}
