package 백트래킹;
import java.io.*;
import java.util.*;
public class Main_S3_15650_N과M2 {
	static int N;
	static int M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		StringTokenizer st = new StringTokenizer(num, " ");
		N = Integer.parseInt(st.nextToken()); // N 개 중
		M = Integer.parseInt(st.nextToken()); // M 개를 골라야 함
		numbers = new int[M]; // M개 고른 수열을 담을 배열 초기화.
		com(0, 1); // 조합.
		System.out.println(sb); // 출력
	}

	public static void com(int cnt, int start) {
		if (cnt == M) { // 기저 조건. M개를 골랐다면 StringBuilder에 저장.
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			com(cnt + 1, i + 1);
		}
	}
}
