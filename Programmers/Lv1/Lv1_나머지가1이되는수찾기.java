package Programmers;

/**
 * 자연수 n이 매개변수로 주어집니다. 
 * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 
 * 답이 항상 존재함은 증명될 수 있습니다.
 */
public class Lv1_나머지가1이되는수찾기 {
	public static void main(String[] args) {
		System.out.println(solution(10)); // 답 : 3
		System.out.println(solution(12)); // 답 : 11
	}

	public static int solution(int n) {
		int answer = Integer.MAX_VALUE;
		for (int x = 1; x <= 1000000; x++) {
			//n을 x로 나눈 나머지가 1이 된다면
			if (n % x == 1) answer = Math.min(answer, x); // 가장 작은 자연수 x를 answer에 저장
		}
		return answer;
	}
}