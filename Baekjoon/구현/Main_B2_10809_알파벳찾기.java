package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_10809_알파벳찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int temp[] = new int[26];
		Arrays.fill(temp, -1); //  알파벳 26개 인덱스에 해당되는 값을 -1로 초기화.
		char [] line = br.readLine().toCharArray(); // 단어 입력받음.
		for (int i = 0; i < line.length; i++) {
			int tmp = line[i] - (int)'a';
			// 처음 등장하는 위치인경우 해당 단어가 처음 등장한 위치를 < 알파벳 배열에 저장. >
			if(temp[tmp] == -1)temp[tmp]= i;
		}
		// 해당 소문자 알파벳이 처음 등장한 위치가 들어있는 배열의 값을 Stringbuilder에 저장.
		for (int i = 0; i < temp.length; i++) sb.append(temp[i]+" ");
		// 출력.
		System.out.println(sb);
	}
}
