package DFS;
import java.util.*;
import java.io.*;
/**
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
	- 2를 곱한다.
	- 1을 수의 가장 오른쪽에 추가한다. 
   A를 B로 바꾸는데 필요한 [ 연산의 최솟값 ]을 구해보자.
 *
 */
public class Main_S1_16953_A에서B로바꾸는최소횟수 {
	static long A, B;
	static long result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		A= Long.parseLong(st.nextToken());
		B= Long.parseLong(st.nextToken());
		dfs(A,0);
		if(result ==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(result);
	}
	private static void dfs(long a, int cnt) {
		if( a > B) return; // a가 b로 만들려는 수 보다 크면 return.
		if(a == B) { // A가 B로 바꿀 수 있다면 
			result = Math.min(result, cnt+1);	// 연산의 최솟값에 1을 더한 값을 result에 저장.	
			return;
		}
		dfs(a*2, cnt+1); 	  // 2를 곱한다
		dfs((a*10)+1, cnt+1); // 1을 수의 가장뒤에 붙여준다.
	}
}
