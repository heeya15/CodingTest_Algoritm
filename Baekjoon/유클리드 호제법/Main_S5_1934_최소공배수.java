package BOJ;
import java.io.*;
import java.util.*;
public class Main_S5_1934_최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = (a*b)/gcd(a,b) ; // a와 b의 곱에 최대 공약수를 나눠주면  = 최소 공배수
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());

	}
	// 유클리드 호제법을 재귀함수로 만들어 최대 공약수를 구해주는 함수
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
}
