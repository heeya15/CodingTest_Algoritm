package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 구현, 문자열 알고리즘 분류
public class Main_B1_1157_단어공부 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().toUpperCase(); // 알파벳 대문자로 다 변형
		int max = Integer.MIN_VALUE;
		int [] temp = new int[26];
		char tmp = ' ';
		for (int i = 0; i < line.length(); i++) {
			int word = line.charAt(i) - (int)'A';
			temp[word]++;
			if(max <temp[word]) { // max 값 보다 더 많이 사용된 알파벳 수라면
				max = temp[word]; // max 값에 해당 알파벳 수를 넣고
				tmp = line.charAt(i); // 가장 많이 사용된 알파벳을 저장.
			}
		}
		
		int count =0;
		for (int i = 0; i < temp.length; i++) {
			if(max== temp[i])count++; // 가장 많이 사용된 알파벳 수를 세어줌
		}
		// 출력
		if(count ==1) System.out.println(tmp);
		else System.out.println("?");	// 가장 많이 사용된 알파벳이 여러개인 경우 "?" 출력.
	}
}
