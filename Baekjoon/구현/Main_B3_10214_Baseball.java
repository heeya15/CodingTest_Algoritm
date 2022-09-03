package 구현;
import java.io.*;

import java.util.*;
public class Main_B3_10214_Baseball {
	static int [] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {     // 테스트케이스 횟수
			arr = new int[2];
			for (int j = 0; j < 9; j++) { // 9줄에 걸쳐서 입력
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				// 야구는 모든 회에서 득점의 합이 많은 쪽이 이기는 것! 
				// ex) 해당 회에서 < 더 크다고 +1 하는게 아님! >
				int yeonsei = Integer.parseInt(st.nextToken());
				int korea = Integer.parseInt(st.nextToken());
				arr[0] += yeonsei;
				arr[1] += korea;
			}
			if(arr[0] > arr[1]) sb.append("Yonsei").append("\n");
			else if(arr[0] < arr[1]) sb.append("Korea").append("\n");
			else sb.append("Draw").append("\n");
		}
		System.out.println(sb.toString());
	}
}
