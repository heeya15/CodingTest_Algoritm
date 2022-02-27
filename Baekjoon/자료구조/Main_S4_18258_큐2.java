package BOJ;
import java.util.*;
import java.io.*;
public class Main_S4_18258_큐2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Queue<Integer> q = new LinkedList<Integer>();
		int back = -1; // 가장 뒤에 있는 정수 저장 용도 변수.
		
		for(int i=0; i< N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			int num = 0;
			switch(command){
				case "push":
					num = Integer.parseInt(st.nextToken());
					back = num;
					q.offer(num);
					break;
				case "pop": // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.poll()).append("\n");
					break;
				case "size": // 큐에 들어있는 정수의 개수를 출력한다.
					sb.append(q.size()).append("\n");
					break;
				case "empty": //큐가 비어있으면 1, 아니면 0을 출력한다.
					if(q.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					break;
				case "front": // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(q.peek()).append("\n");
					break;
				case "back": // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
					if(q.isEmpty()) sb.append(-1).append("\n");
					else sb.append(back).append("\n");
					break;
			}
		} // for end
		System.out.println(sb); // 출력.
	}
}
