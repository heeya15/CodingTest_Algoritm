package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, size = line.length(); i < size; i++) {
			if (line.charAt(i) == '<') { // 여는 괄호 만났을때
				while (!s.isEmpty())sb.append(s.pop()); // 스텍에 넣어진 단어들 StringBuilder에 추가.
				while (true) {
					if (line.charAt(i) == '>') { // 닫는 괄호를 만날시 while문 탈출.
						sb.append(line.charAt(i)); 
						break;
					}
					sb.append(line.charAt(i)); // 괄호 안의 단어들 StringBuilder에 추가.
					i++;
				}
			} else if (line.charAt(i) == ' ') { // 공백을 만났을 경우.
				while (!s.isEmpty()) sb.append(s.pop()); // 이전 스텍에 추가된 단어들 StringBuilder에 추가.
				sb.append(line.charAt(i));
			}else { // 일반 단어들만 스텍에 넣어줌.
				s.push(line.charAt(i));
			}
		}
		while (!s.isEmpty()) sb.append(s.pop());
		System.out.println(sb);
	}
}
