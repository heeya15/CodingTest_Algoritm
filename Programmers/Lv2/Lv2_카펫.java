package Programmers;

import java.util.Arrays;

/**
	( 문제 설명 )
	노란색과 갈색으로 색칠된 격자의 개수는 기엇
	전체 카펫의 크기는 기억 x.
	갈색 격자의수, 노란색 격자의 수가 매개변수로 주어짐.
	카펫의 가로, 세로 크기를 순서대로 배열에 담아 return;
	
	( 풀이 )
	
	1. 총 격자의 수의 약수로 카펫의 가로, 세로 길이를 구할 수 있다.
	   ex) 총 격자의 수가 12라면 12에 대한 약수의 경우의 수는
	       (1, 12) (2, 6) (3, 4) (4, 3) (6, 2) (12, 1) -> 6개의 경우의 수가 나옴
	2. 갈색 격자 모양 카펫 안에 노란색 카펫이 감싸 있는 경우를 볼 수 있다.
	     즉, "노란색 카펫은" < 위, 아래, 왼쪽, 오른쪽 > 이렇게 테두리로 감싸고 있는 
	   [ 갈색 격자] 에서 [ 노란색 격자 ]를 구하려면 [ 위, 아래 2칸 ], [ 왼쪽, 오른쪽 2칸 ] 
	     즉 -> (가로 - 2) * ( 세로 -2 ) = 노란색 격자의 수가 되면 [ 계산에 쓰인 가로, 세로는 ]
	   < 카펫의 가로, 세로 크기 값 >이 된다.
**/
public class Lv2_카펫 {
	public static void main(String[] args) {
		int[] numbers = { 3, 0, 6, 1, 5 };
		System.out.println(Arrays.toString(solution(10, 2)));  // 답 : [4, 3]
		System.out.println(Arrays.toString(solution(8, 1)));   // 답 : [3, 3]
		System.out.println(Arrays.toString(solution(24, 24))); // 답 : [8, 6]
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int area = brown + yellow; // 맵 전체의 크기 = 총 격자의 수

		for (int i = 1; i <= area; i++) {
			int col = i; // 세로 (열)
			int row = area / i; // 가로(행)
			
			if (row < col)continue; // 가로 길이가 세로 길이 보다 작을 경우 (제한 사항) 어긋남으로 무시.

			if ((row - 2) * (col - 2) == yellow) {
				answer[0] = row;
				answer[1] = col;
				break;
			}
		}
		return answer;
	}
}