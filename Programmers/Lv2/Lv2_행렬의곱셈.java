package Programmers;

import java.util.*;
public class Lv2_행렬의곱셈 {
	public static void main(String[] args) {
		int arr1[][] = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int arr2[][] = { { 3, 3 }, { 3, 3 } };
		System.out.println(Arrays.deepToString(solution(arr1, arr2)));
	}
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}
}
