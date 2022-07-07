package Programmers;

/**
      완전 탐색 문제.
 **/
public class Lv2_숫자의표현 {
	public static void main(String[] args) {
		System.out.println(solution(15)); // 답 : 4
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += j;
				if (sum == n) { // i부터 n까지 순차적으로 더하다 n과 같아지면 answer 증가.
					answer++;
					break;
				};
				// n보다 커지면 연속한 자연수들로 n을 표현 할 수 없으니 for문에서 break를 해 줌.
				// 가지치기를 해줘야 시간 초과가 안 남.
				if (sum > n) break;
			}
		}
		return answer;
	}
}