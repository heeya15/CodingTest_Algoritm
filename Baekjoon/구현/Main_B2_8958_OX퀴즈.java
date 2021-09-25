package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B2_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String line = br.readLine();// O,X 로 이루어진 문자열 입력 받음.
			//  점수 최종합을 저장할 변수, 점수 세기위한 변수.
			int sum=0, count=0;
			for (int j = 0, size = line.length(); j < size; j++) {	
				if(line.charAt(j) == 'O') {
					count++;   // 연속된 O의 개수 세어줌
					sum+=count;// 점수 최종합 저장. 
				}else count =0; 
			}
			sb.append(sum).append("\n"); // 연속된 O의 개수 추가.
		}
		System.out.println(sb);
	}
}
