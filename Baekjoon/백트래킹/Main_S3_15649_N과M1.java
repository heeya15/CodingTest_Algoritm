package 백트래킹;
import java.io.*;
import java.util.*;
public class Main_S3_15649_N과M1 {
	static int N,M;
	static int numbers[];
	static boolean isSelect[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		numbers = new int[M];
		isSelect = new boolean[N];
		permutation(0);
		System.out.println(sb);

	}
	private static void permutation(int cnt) {
		if (cnt == M) {
			for(int i : numbers) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isSelect[i]) {
				numbers[cnt] = i + 1;
				isSelect[i] = true; // i가 사용중 표시
				permutation(cnt + 1);
				isSelect[i] = false; // [ 다음 순열을 뽑기 위해 ]서 i는 사용 중이 아님을 표시. -- 다른 순열을 뽑기 위해서.
			}
		}
	}
}
