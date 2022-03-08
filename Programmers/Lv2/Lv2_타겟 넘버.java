package Programmers;
public class Lv2_타겟넘버 {
	static int size, answer;
	public static void main(String[] args) {
		int [] numbers = {1, 1, 1, 1, 1};
		System.out.println(solution(numbers, 3));  // 5 출력
		int [] numbers1 = {4, 1, 2, 1};
		System.out.println(solution(numbers1, 4)); // 2 출력
	}
	public static int solution(int[] numbers, int target) {
		size = numbers.length;
		answer = 0;
		dfs(0, 0, numbers, target);
		return answer;
	}
	public static void dfs(int sum, int depth, int[] arr, int target) {
		if (depth == size) { // 해당 배열 원소 만큼 다 선택 했을 경우
			// "target 넘버와 같다면" 해당 target으로 만들 수 있는 개수 증가
			if (sum == target) answer++; 	
			return;
		}
		dfs(sum - arr[depth], depth + 1, arr, target);
		dfs(sum + arr[depth], depth + 1, arr, target);
	}
}