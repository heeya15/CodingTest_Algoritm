package Programmers;

import java.util.Arrays;
/**
 * 함수 solution은 정수 "x와 자연수 n을 입력 받아", x부터 시작해 "x씩 증가하는 숫자"를
 * [ n개 지니는 리스트를 리턴 ]해야 합니다. 
 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 * 
 * [ 제한 조건 ]
 * x는 -10000000 이상, 10000000 이하인 정수입니다.
 * n은 1000 이하인 자연수입니다.
 */
public class Lv1_x만큼간격이있는n개의숫자 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2,5)));  // 답 : [2,4,6,8,10]
		System.out.println(Arrays.toString(solution(4,3)));  // 답 : [4,8,12]
		System.out.println(Arrays.toString(solution(-4,2))); // 답 : [-4, -8]
	}

	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
         // x씩 증가하는 숫자.
        for(int i =1; i < n; i++) answer[i] = answer[i-1] + x;
        return answer;
    }
}