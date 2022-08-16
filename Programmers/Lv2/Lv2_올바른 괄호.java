package Programmers;

import java.util.*;

/**
 * ( 문제 풀이 )
 * 1. 처음 시작하는 문자가 여는 괄호'(' 인 경우 스텍에 넣어주고, 
 *    스텍이 비워져 있는대 닫는 괄호 ')' 인 경우 바로 false return 시켜줌으로 써 "가지치기"
 * 2. 스텍이 비워져 있지 않고 스택의 제일 위에 있는 문자가 여는 괄호이고,
 *    [ 문자열 s의 인덱스 문자가 ] 닫는 괄호인 경우 스텍의 제일 위에 있는 문자를 꺼내준다.
 * 3. 스텍이 비워져 있지 않고 닫는 괄호가 아닌경우에는 스텍에 추가해 준다.
 * 4. 최종 스텍이 비워져 있으면 true, 그렇지 않으면 false를 answer 변수에 담아 return 시켜줌.
 **/
public class Lv2_올바른괄호 {
	public static void main(String[] args) {
		System.out.println(solution("()()"));   // 답 : true
		System.out.println(solution("(())()")); // 답 : true
		System.out.println(solution(")()("));   // 답 : false
		System.out.println(solution("(()("));   // 답 : false
	}

	// 시간 초과 난 코드 -> 효율성 테스트 1에서 시간 초과 남....
	public static boolean solution1(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else {
				if (stack.peek() == '(' && s.charAt(i) == ')')
					stack.pop();
				else
					stack.push(s.charAt(i));
			}
		}
		answer = stack.isEmpty() ? true : false;
		return answer;
	}

	public static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				// 스택이 비어있는대 ')' 가 들어가면 뒤는 볼 필요도 없어서 가지치기로 바로 false 리턴 시켜줌. 
				if (stack.isEmpty()) return false;  
				if (stack.peek() == '(' && s.charAt(i) == ')') stack.pop();
				else stack.push(s.charAt(i));
			}
		}
		answer = stack.isEmpty() ? true : false;
		return answer;
	}
}