package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 구현 , 문자열 알고리즘 분류
public class Main_B2_1152_단어의개수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line []  = br.readLine().split(" ");
		int cnt = 0;
		for (int i = 0; i < line.length; i++) {
			if(!line[i].equals(""))cnt++; // 처음 단어가 공백이 아니라면 개수 세어줌.
		}
		System.out.println(cnt);
	}	
}
