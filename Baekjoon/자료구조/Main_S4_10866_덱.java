package 자료구조;
import java.util.*;
import java.io.*;
public class Main_S4_10866_덱 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 명령의 수
		Deque<Integer> dq = new LinkedList<Integer>();
		// 명령의 수 만큼 반복.
		while(N > 0) {
			N--;
			String line = ""; // 출력해야할 명령 저장받을 변수
			int num = 0;	  // 주어진 정수를 저장받을 변수.
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			if(st.countTokens() == 2) { // 명령과, 정수가 주어질 경우.
				line = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				// 정수 x를 "덱의 앞"에 넣음.
				if(line.equals("push_front")) dq.addFirst(num);
				else dq.offerLast(num);// 정수 x를 "덱의 뒤"에 넣음.
				
			}
			if (st.countTokens() ==1) { // 명령만 주어질 경우
				line = st.nextToken();
				if(line.equals("empty")) { //덱이 비어있으면 1, 아니면 0을 출력.
					if(dq.isEmpty()) print(1);
					else print(0);
				}
				if(line.equals("pop_back")) { 
					if(dq.isEmpty()) print(-1); // 덱에 들어가 있는 정수가 없는경우 -1 출력
					else print(dq.pollLast());	// 덱의 가장 뒤에 있는 수를 뺌. 
				}
				else if(line.equals("pop_front")) {
					if(dq.isEmpty()) print(-1); // 덱에 들어가 있는 정수가 없는경우 -1 출력
					else print(dq.pollFirst()); // 덱의 가장 앞에 있는 수를 뺌
				}
				// 덱의 "가장 앞"에 있는 정수 출력.
				if(line.equals("front")) {
					if(dq.isEmpty()) print(-1); // 덱에 들어가 있는 정수가 없는경우 -1 출력
					else print(dq.peekFirst());
				}
				// 덱의 "가장 뒤"에 있는 정수 출력
				if(line.equals("back")) {
					if(dq.isEmpty()) print(-1); // 덱에 들어가 있는 정수가 없는경우 -1 출력
					else print(dq.peekLast());
				}
				// 덱에 들어있는 정수의 개수를 출력.
				if(line.equals("size")) print(dq.size());	
			}
		} // while end
		System.out.println(sb);
	}
	private static void print(int num) {
		sb.append(num).append("\n");
	}
}
