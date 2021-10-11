package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 알고리즘 분류 [ 구현, 큐 ]
// 1번부터 N번까지 < N명의 사람이 원을 이루면서 앉아있고 >, 양의 정수 K(≤ N)가 주어진다. 
// 이제 순서대로 "K번째 사람을 제거"
public class Main_S4_11866_요세푸스문제0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) q.offer(i);
		
		sb.append("<");
		// 처음에는 미리 K번째 사람을 제거하고 출력에 추가한다.
		for (int i = 0; i < K - 1; i++) {
			int temp = q.poll();
			q.offer(temp);
		}
		sb.append(q.poll());
		while (!q.isEmpty()) {
			sb.append(", ");
			for (int i = 0; i < K - 1; i++) {
				int temp = q.poll();
				q.add(temp);
			}
			sb.append(q.poll());
		}
		sb.append(">"); // 마지막에 '>'를 추가하고 출력한다.
		System.out.println(sb);
// 		다른 방법 풀이.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(st.nextToken()); // N명의 사람
//		int K = Integer.parseInt(st.nextToken()); // 양의 정수 K가 주어진다. K번째 사람을 제거한다.
//		Queue<Integer> q = new LinkedList<Integer>();
//		for (int i = 1; i <= N; i++) q.offer(i);
//
//		sb.append("<");
//
//		// 마지막 부분의 출력은 > 괄호 전에 공백이 없어서, 큐에 하나만 남을때까지 해당 반복
//		// 일괄적으로 출력하기 위해 마지막 원소만 남겨질 때까지만, 반복하고 마지막 원소는 그대로 출력한다.
//		while (q.size() > 1) { // 큐 사이즈가 1보다 클때 까지만.
//			for (int i = 0; i < K - 1; i++) {
//				int temp = q.poll();
//				q.add(temp);
//			}
//			sb.append(q.poll()).append(", ");
//		}
//		sb.append(q.poll() + ">");
//		System.out.println(sb);
	}
}
