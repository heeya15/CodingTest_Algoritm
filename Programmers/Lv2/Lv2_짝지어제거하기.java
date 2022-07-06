package Programmers;

import java.util.*;

/**
	2017 팁스타운 - Lv2_짝지어 제거하기
	( 문제 풀이  ) - > 스택을 활용하여 푸는 문제
	1. 스택이 비어있거나, 스택의 젤 위에 들어가 있는 문자와 현재 data와 비교하여 같지 않다면 해당 단일 문자를 stack에 넣음
	2. 스택이 비어있지 않고, 스택의 젤 위에(top) 들어가 있는 문자와 현재 data와 비교하여 같다면 해당 단일 문자를 stack에서 뺌.
 **/
public class Lv2_짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa")); // 답 : 1
		System.out.println(solution("cdcd")); // 답 : 0
	}

	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char data = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == data) {
				stack.pop();
				continue;
			}
			if (stack.isEmpty() || stack.peek() != data) stack.push(data);
		}
		answer = stack.isEmpty() ? 1 : 0;
		return answer;
	}
}