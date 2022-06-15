package Programmers;

/**
 * 양의 정수 x가 하샤드 수이려면 "x의 자릿수의 합" 으로 x가 나누어져야 합니다. 
 * 예를 들어 18의 [ 자릿수 합은 1+8=9 ]이고, 18은 9로 나누어 떨어지므로 [ 18은 하샤드 수 ]입니다. 
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 */
public class Lv1_하샤드수 {
	public static void main(String[] args) {
		System.out.println(solution(10)); // 답 : true
		System.out.println(solution(12)); // 답 : true
		System.out.println(solution(11)); // 답 : false
		System.out.println(solution(13)); // 답 : false
	}

	public static boolean solution(int x) {
		boolean answer = true;
		String line = Integer.toString(x);
		int sum = 0; // 자릿 수의 합 저장.
		for (int i = line.length() - 1; i >= 0; i--) sum += line.charAt(i) - '0';
		answer = x % sum != 0 ? false : true;
		return answer;
	}
}