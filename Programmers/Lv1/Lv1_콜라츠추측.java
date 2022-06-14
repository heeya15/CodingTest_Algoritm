package Programmers;
import java.util.*;
/**
 * 작업 순서
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다. 
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
 * 
 * [ 문제 해결 과정 ] 
 * 작업을 500번 반복할 때까지 1이 되지 않는다면 -1을 반환해 달라고 하였는대, 
 * 처음에 매개변 num를 long 형태로 [ 형 변환 하지 않고 했더니 ] 488을 계속 뱉어내어서 "400 이상 작업인 경우 -1을 출력"하게
 * 하였더니 통과 되었다.. 그런대 너무 찝찝하게 맞는거 같고 [ 문제에선 500작업 반복할 때까지 ]라고 하여서 
 * 질문하기 글을 보았더니 "오버 플로우"가 작업 중에 발생할 수 있어서 long 형태로 매개변수를 형 변환 하고 작업을 하라고 하여서 
 * long 타입 형 변환을 하고 나서 주어진 문제 조건대로 해결하였다.
 */
public class Lv1_콜라츠추측 {
	public static void main(String[] args) {
		System.out.println(solution(6)); // 답 : 8
		System.out.println(solution(16));// 답 : 4
		System.out.println(solution(626331));// 답 : -1
	}

	public static int solution(int num) {
		// 오버 플로우 발생이 생겨서 매개변수 int를 long 형태로 형 변환 해주고 주어진 작업대로 처리.
		long num1 = (long) num;
		int answer = 0;
		while (num1 != 1) {
			if (num1 % 2 == 0) {
				num1 /= 2;
				answer++;
			} else {
				num1 = num1 * 3 + 1;
				answer++;
			}
			if (answer == 500) {
				answer = -1;
				break;
			}
		}
		return answer;
	}
}