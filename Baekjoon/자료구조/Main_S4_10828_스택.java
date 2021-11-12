package 자료구조;
import java.util.*;
import java.io.*;
public class Main_S4_10828_스택 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수
		Stack<Integer> s = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력.
		StringTokenizer st ;
		for(int i =0; i< N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int size = st.countTokens();
			if(size==2) {
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				s.push(num); // 스택에 push
			}else {
				String command = st.nextToken();
				if(command.equals("pop")) {
					if(s.empty()) sb.append(-1).append("\n"); // 스택에 들어있는 정수가 없는 경우 -1 출력.
					else sb.append(s.pop()).append("\n");     // 스택에 가장 위에 있는 정수를 뺌
				}
				else if(command.equals("size")) {
					sb.append(s.size()).append("\n");
				}
				else if(command.equals("empty")) {
					if(s.empty()) sb.append(1).append("\n"); 		// 스택이 비어있는 경우 1
					else if(!s.empty()) sb.append(0).append("\n");  // 스택이 비어있지 않다면 0
				}
				else if(command.equals("top")) {
					if(s.empty()) sb.append(-1).append("\n");      // 스택에 들어있는 정수가 없는 경우 -1 출력.
					else sb.append(s.peek()).append("\n"); 
				}
			}
		}
		System.out.println(sb); // 출력
	}
}
