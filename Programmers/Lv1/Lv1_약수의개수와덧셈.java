package Programmers;

/**
 * 두 정수 left와 right가 매개변수로 주어집니다. [ left부터 right까지 ]의 모든 수들 중에서, 
 * 약수의 개수가 "짝수"인 수는 "더하고", 약수의 개수가 "홀수"인 수는 "뺀 수"를 
 * return 하도록 solution 함수를 완성해주세요.
 * 
 * [ 입출력 예 #1 ]
 * 다음 표는 13부터 17까지의 수들의 약수를 모두 나타낸 것입니다.
 * 수	     약수	                        약수의 개수
 * 13	  1, 13	                2
 * 14	  1, 2, 7, 14	        4
 * 15	  1, 3, 5, 15	        4
 * 16	  1, 2, 4, 8, 16	    5 --> 이 약수의 개수가 홀 수 여서 '수' 16을 빼줌, 나머지 '수'는 짝수여서 더해줌
 * 17	  1, 17	                2
 */
public class Lv1_약수의개수와덧셈 {
	public static void main(String[] args) {
		System.out.println(solution(13, 17)); // 답 : 43
		System.out.println(solution(24, 27)); // 답 : 52
	}
	public static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int count = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) count++; // 약수의 개수를 구해줌.
			}
			// 약수의 개수 짝수면 더해줌, 홀수면 빼줌.
			if (count % 2 == 0) answer += i;
			else answer -= i;
		}
		return answer;
	}
}