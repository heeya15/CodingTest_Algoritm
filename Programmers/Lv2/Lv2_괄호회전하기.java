package Programmers;

import java.util.*;
/**
Stack과 문자열 자르기를 활용하면 쉽게 풀 수 있는 문제

[ 문제 풀이 방법 ]

	1. for문을 이용해  s 문자열에 맨 앞 문자를 s 문자열 맨 뒤로 옮긴다.
	
	2. 회전한 문자열을 Stack을 이용해 괄호를 완성시키면 지운다.
	
	3. Stack이 첨에 비어 있으면 Stack에 넣어준다.
	
	4. Stack의 peek()와 내가 지금 넣으려는 괄호가 서로 쌍이 맞으면 그때 stack에서 pop만 해주면 된다.
	
	5. 서로 쌍이 맞지 않는 경우는 Stack에 넣어준다.
	
	6. Stack이 비워져 있다면 쌍이 맞다는 의미로 true, 비워져 있지 않다면 false를 반환 시켜준다.
**/
public class Lv2_괄호회전하기 {
	public static void main(String[] args) {
		System.out.println(solution("[](){}")); // 답 : 3
		System.out.println(solution("}]()[{")); // 답 : 2
		System.out.println(solution("[)(]")); // 답 : 0
		System.out.println(solution("}}}")); // 답 : 0
	}

	public static int solution(String s) {
		int answer = 0;
		String line = s;
		for (int i = 0; i < s.length(); i++) {
			char temp = line.charAt(0); // 첫 문자열 저장
			line = line.substring(1) + temp; // 왼쪽으로 1칸씩 회전 시킨 s 문자열
			if (check(line)) answer++;
		}
		return answer;
	}

	public static boolean check(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char data = str.charAt(i);
			if (stack.isEmpty()) {
				stack.push(data);
				continue;
			}
			if (stack.peek() == '[' && data == ']') {
				stack.pop();
				continue;
			}
			if (stack.peek() == '{' && data == '}') {
				stack.pop();
				continue;
			}
			if (stack.peek() == '(' && data == ')') {
				stack.pop();
				continue;
			}
			if (!stack.isEmpty()) {
				stack.push(data);
				continue;
			}
		}
		if (stack.isEmpty()) return true;
		return false;
	}
}