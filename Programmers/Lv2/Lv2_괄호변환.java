package Programmers;

import java.util.*;
import java.lang.*;

public class Lv2_괄호변환 {
	static int idx = 0;

	public static void main(String[] args) {
		String p1 = "(()())()";
		String p2 = ")(";
		String p3 = "()))((()";
//	    System.out.println(solution(p1));
		System.out.println(solution(p2));
//		System.out.println(solution(p3));
	}

	public static String solution(String p) {
	        StringBuilder sb = new StringBuilder();
			if (p.equals("")) return p; // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
			
			boolean correct = check(p);
//	        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
//	                  단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
			String u = p.substring(0, idx);
			String v = p.substring(idx);

//	        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
			if (correct) sb.append(u).append(solution(v));  
			else
			{
//	    		4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
//	    		4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
	            sb.append("(");

//	    		4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
	            sb.append(solution(v));
	            sb.append(")");

//	    		4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
	            for (int i = 1; i < u.length()-1; i++) {
	                if(u.charAt(i)== '(')sb.append(")");
	                else sb.append("(");
	            }
	        }
			return sb.toString();
	}

	private static boolean check(String p) {
		boolean isState = true; // 올바른 괄호 문자열인가
		int left = 0, right = 0; // 왼쪽, 오른쪽 괄호 개수 세어주기.
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			if (ch == '(') {
				left++;
				stack.add('(');
			} else { // 오른쪽 괄호인 경우
				right++;
				if (!stack.isEmpty() && stack.peek() == '(') // 비어 있지 않고, 스텍의 제일 위에 여는 괄호가 있다면.
					stack.pop();
				else if (stack.isEmpty()) { // 스텍이 비어있다면 -> 즉 올바른 괄호 문자열이 아닐 경우 상태 false
					stack.add(')');
					isState = false;
				}
			}
			if (left == right) { // 짝이 맞을 경우
				idx = i + 1;
				break;
			}
		}
		return isState;
	}
}
