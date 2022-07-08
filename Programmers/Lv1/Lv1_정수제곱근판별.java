package Programmers;

public class Lv1_정수제곱근판별 {
	/**
	 * Lv1_정수 제곱근 판별 -( 구현 문제 )
	 * ( 문제 풀이 ) 
	 * 1. for문을 통해 i의 제곱근이 n일 경우 i+1의 제곱을 answer에 저장 후 리턴
	 * 2. 만약 i의 제곱근이 n이 아니라면 answer 변수에 -1을 저장 후 리턴.
	 **/
	public static void main(String[] args) {
		System.out.println(solution(121)); // 답 : 144
		System.out.println(solution(3)); // 답 : -1
		System.out.println(solution(1)); // 답 : 4
	}

	public static long solution(long n) {
		long answer = 0;
		double num = 0;
		for (int i = 1; i <= n; i++) {
			num = Math.pow(i, 2);
			// i의 제곱이 n 이라면
			if (num == n) {
				answer = (long) Math.pow(i + 1, 2);
				break;
			} else
				answer = -1;
		}
		return answer;
	}
}