package Programmers;
import java.util.*;

/**
 * priorities : 대기 목록에 있는 문서의 중요도가 순서대로 담긴 배열, 
 * location : 내가 인쇄를 요청한 문서가 `현재 대기 목록의 어떤 위치`에 있는지 알려주는 변수
 *    
 * 입출력 예
	priorities				 location	 return
	[2, 1, 3, 2]				2			1
	[1, 1, 9, 1, 1, 1]			0			5
 *
 */
public class Lv2_프린터 {
	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities1 = {1,1,9,1,1,1};
		int location = 2;
		int location1 = 0;
		System.out.println(solution(priorities, location)); 
		System.out.print(solution(priorities1, location1)); 
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		int size = priorities.length;
		// 문제에서 [ 중요도는 숫자가 클 수록 더 중요 ]하다고 하여 내림차순 정렬 우선순위 큐를 만듬.
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < size; i++)
			pq.offer(priorities[i]);
		while (!pq.isEmpty()) {
			for (int i = 0; i < size; i++) {
				// 대기목록 배열 중 하나의 원소 와 == 우선 순위큐중 가장 중요한 요소 하나와 [ 값이 같다면 ]
				// 즉, 값만 일치한다면
				if (priorities[i] == pq.peek()) {

					// i(index) 와 , 대기 목록 배열 원소의 [위치]를 가르키는 값과 같다면 (값, 위치 모두 일치한다면)
					if (i == location) {
						answer++;
						return answer;
					}
					pq.poll();
					answer++;
				}
			}
		}
		return answer; // 내가 인쇄를 요청한 문서가 몇번째로 인쇄되는지 return
	}
}