package Programmers;

import java.util.*;

public class Lv1_예산 {
    /**
  	- 모든 부서의 물품을 구매해 줄 수는 없습니다. 
           그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
    - 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 
      1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
    - d : 부서별로 신청한 금액이 들어있는 배열 
    - budget : 예산
    - [ 최대 몇 개의 부서에 물품을 지원할 수 있는지 ] return 하도록 solution 함수를 완성
  **/
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 4 };
		System.out.println(solution(arr, 9)); // 답 : 3
		int[] arr2 = { 2,2,3,3 };
		System.out.println(solution(arr2, 10));// 답 : 4
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		for (int i = 0; i < d.length; i++) {
			if (budget >= d[i]) {
				budget -= d[i];
				answer++;
			}
		}
		return answer;
	}
}