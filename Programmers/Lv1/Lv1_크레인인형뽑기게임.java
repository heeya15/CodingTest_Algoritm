package Programmers;

import java.util.*;

public class Lv1_크레인인형뽑기게임 {
	/**
	 * 2019 카카오 개발자 겨울 인턴십 - 주어진 문제 조건대로 풀면 됨. ( 구현 문제 )
	 **/
	public static void main(String[] args) {
		int[][] sizes = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(sizes, moves)); // 답 : 4000
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0; // 사라진 인형 수 세기
		Stack<Integer> stack = new Stack<>();
		for (int k = 0; k < moves.length; k++) {
			for (int i = 0; i < board.length; i++) {	
				if (board[i][moves[k] - 1] != 0) {
					if (!stack.isEmpty() && stack.peek() == board[i][moves[k] - 1]) { // 연속해서 쌓인 경우 바구니에서 제거
						stack.pop();
						answer = answer + 2;
						board[i][moves[k] - 1] = 0;
						break;
					} 
					stack.push(board[i][moves[k] - 1]);
					board[i][moves[k] - 1] = 0;
					break;	
				}
			}
		}
		return answer;
	}
}