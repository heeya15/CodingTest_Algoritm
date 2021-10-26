package 구현;
import java.util.*;
// 자료구조 , 큐 분류 -> 양방향성 Deque를 사용함.
public class Main_S4_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> dq = new LinkedList<Integer>();
//		1부터 N까지의 번호를 붙어서 Deque에 넣어줌
		for(int i =1; i <= N; i++) {
			dq.addLast(i); // ex) N= 4 -> 1 2 3 4 형태로 들어가 있음
		}	
		while(dq.size()>1) { // Deque에 1개 이상의 원소가 들어가 있다면 반복.
			dq.pollFirst(); // 처음에 들어온 것을 빼주고 
			int temp = dq.pollFirst(); // 빼준 뒤 처음을 빼서 저장하고
			dq.addLast(temp); // 맨 뒤로 추가 시켜준다.
		}
		System.out.println(dq.poll());
	}
}
