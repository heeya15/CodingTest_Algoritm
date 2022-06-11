package Programmers;
import java.util.*;

public class Lv1_같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		System.out.println(solution(arr)); // 답 : [ 1,3,0,1 ]
		int[] arr2 = { 4, 4, 4, 3, 3 };
		System.out.println(solution(arr2));// 답 : [4,3]
	}

	public static ArrayList<Integer> solution(int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (q.peek() == arr[i])continue;
			else { // q의 제일 먼저 들어온 숫자와 현재 배열 i 원소의 값과 다른 경우.
				q.add(arr[i]);
				answer.add(q.poll());
			}
		}
		while (!q.isEmpty()) {
			int num = q.poll();
			answer.add(num);
		}
		return answer;
	}
}