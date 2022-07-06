package Programmers;

import java.util.*;

/**
 * Lv2_삼각 달팽이 - 월간 코드 챌린지 시즌1
 * [ 문제 풀이 방법 ]
 * 
 * 삼각형을 채우는 규칙과 각 칸의 좌표들을 함께 살펴보면 다음과 같다
 * 아래로 이동할 때는 x좌표가 증가
 * 오른쪽으로 이동할 때는 y좌표가 증가
 * 대각선 왼쪽 위로 이동할 때는 x,y좌표가 감소
 * 
 * 위 규칙을 이용하여 삼각형의 좌표에 해당하는 값을 저장할 [n][n]크기의 배열을 선언하고 [0, 0] 좌표부터 달팽이 채우기를 진행하는 값을 넣어주면 됨.
 **/
public class Lv2_삼각달팽이 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4))); // 답 : [1, 2, 9, 3, 10, 8, 4, 5, 6, 7]
		System.out.println(Arrays.toString(solution(5))); // 답 : [1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9]
		System.out.println(Arrays.toString(solution(6))); // 답 : [1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11]
	}

	public static int[] solution(int n) {
		int[] answer = new int[(n * (n + 1)) / 2];
		int[][] arr = new int[n][n];
		int r = -1;
		int y = 0;
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// 현재 행에서 +1 아래쪽으로 채우는 경우
				if (i % 3 == 0) r++;
				// 오른쪽으로 채우는 경우
				if (i % 3 == 1) y++;
				// 대각선 왼쪽 위로 채우는 경우
				if (i % 3 == 2) {
					r--;
					y--;
				}
				arr[r][y] = num++;
			}
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0) answer[index++] = arr[i][j];
			}
		}
		return answer;
	}
}