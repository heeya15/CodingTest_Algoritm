package Programmers;

public class Lv1_소수만들기 {
	/**
	 * Summer/Winter Coding(~2018) Lv1_소수 만들기 - 조합을 활용하여 소수 찾음.
	 * ( 문제 풀이 ) 
	 * 1. 조합을 이용하여 3가지 숫자를 선정.
	 * 2. 3가지 숫자를 더한 값을 소수인지 아닌지 판별 -> 소수일 경우만 결과 리턴할 변수 answer에 +1을 해줌
	 **/
	static int[] numbers;
	static int answer;
	public static void main(String[] args) {
		int [] nums = {1,2,3,4};
		System.out.println(solution(nums)); // 답 : 1
		answer = 0;
		int [] nums1 = {1,2,7,6,4};
		System.out.println(solution(nums1)); // 답 : 4
	}

	public static int solution(int[] nums) {
		numbers = new int[3];
		comb(0, 0, nums);
		return answer;
	}

	public static void comb(int depth, int start, int[] nums) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) sum += numbers[i];

			// 소수 찾기(소수이면 +1)
			if (isPrime(sum)) answer++;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			numbers[depth] = nums[i];
			comb(depth + 1, i + 1, nums);
		}
	}

	private static boolean isPrime(int num) {
		/** i=1부터가 아닌 이유는 1은 나눌 필요 없는 수여서
		       나누어 떨어지면 소수가 아니므로 false **/
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		// 나누어 떨어지지 않으면 ( 소수인 경우 ) true
		return true;
	}
}