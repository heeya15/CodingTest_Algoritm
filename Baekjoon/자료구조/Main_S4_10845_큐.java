package 자료구조;
import java.util.*;
import java.io.*;
public class Main_S4_10845_큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		// 스텍은 선입 선출 구조로, 계속 push 할때 나중에 입력 받은 것이 가장 뒤에 있고, 가장 나중에 출력됨.
		int back = -1;  // 제일 뒤에있는 정수를 저장용도로 사용.
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = 0;
			switch(command) {
				case "push": // 정수 x를 큐에 넣는 연산.
					num = Integer.parseInt(st.nextToken());
					back = num; // back 연산에 필요한 [ 큐에 가장 뒤에 있는 정수를 임시 저장. ]
					q.offer(num);
					break;
				case "pop": // 큐에 가장 앞에있는 정수를 빼고 출력., 큐에 들어있는 정수 없을 경우 -1 출력.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.poll()).append("\n");
					break;
				case "size": // 큐에 들어있는 정수의 개수를 출력.
					sb.append(q.size()).append("\n");
					break;
				case "empty": // 큐가 비어있으면 1 , 비어있지 않으면 0 출력
					if(q.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "front": // 큐의 가장 앞에 있는 정수 출력, 큐에 들어있는 정수 없을 경우 -1 출력.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.peek()).append("\n");
					break;
				case "back":  // 큐의 가장 뒤에있는 정수 출력, 큐에 들어있는 정수 없을 경우 -1 출력.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(back).append("\n");
					break;
			} // switch end
		}// for end
		System.out.println(sb);
	}
}
