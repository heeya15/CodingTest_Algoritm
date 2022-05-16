package BOJ;
import java.io.*;
import java.util.*;
/**
 * 그림을 그려가면서 규칙을 찾아봤는데 N*M 초콜릿 자르는 횟수는
   (N-1)+N(M-1) = N*M-1 로 정리할 수 있었음
 *
 */
public class Main_B3_2163_초콜릿자르기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.print(N*M-1);
	}
}
