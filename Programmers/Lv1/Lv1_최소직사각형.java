package Programmers;
import java.util.*;
public class Lv1_최소직사각형 {
	/**
	 * 위클리 챌린지
	 **/
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		System.out.println(solution(sizes)); // 답 : 4000
		int[][] sizes1 = { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } };
		System.out.println(solution(sizes1));// 답 : 120
	}
	// 1번째 방법
	public static int solution(int[][] sizes) {
		int answer = 0;
		int width = 0;
		int height = 0;
		for (int i = 0; i < sizes.length; i++) {
			// 모든 명함의 사이즈 중 긴 것을 가로, 짧은 것을 세로로 두고
			// 그 중 가장 큰 가로, 세로를 구하기.
			width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
			height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
		}
		answer = width * height;
		return answer;
	}
	// [ 2번째 방법 ]으로 순수 구현 풀이 
	public static int solution2(int[][] sizes) {
		int answer = 0;
		int[][] temp = new int[sizes.length][sizes[0].length];
		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j < sizes[0].length; j++) {
				if (sizes[i][0] > sizes[i][1]) {
					temp[i][0] = sizes[i][0];
					temp[i][1] = sizes[i][1];
				} else {
					temp[i][0] = sizes[i][1];
					temp[i][1] = sizes[i][0];
				}
			}
		}
		int width = 0;
		int height = 0;
		for (int i = 0; i < sizes.length; i++) {
			width = Math.max(width, temp[i][0]);
			height = Math.max(height, temp[i][1]);
		}
		answer = width * height;
		return answer;
	}
}