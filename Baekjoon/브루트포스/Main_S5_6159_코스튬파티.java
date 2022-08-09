package 브루트포스;

import java.util.*;
import java.io.*;

public class Main_S5_6159_코스튬파티 {
	static int N,S;
	static int result;
	static int [] cow_size;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());  // 소의 수
		S = Integer.parseInt(st.nextToken());  // 코스튬의 크기
		cow_size = new int[N];
		visited = new boolean[N];
		// 소 크기 입력
		for (int i = 0; i < N; i++) {
			cow_size[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cow_size);
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(cow_size[i]+cow_size[j] <= S) result++; // 소 두마리의 합이 코스튬 크기 보다 작은 경우
			}
		}
//		comb(0,0);
		System.out.println(result);
	}
	
	// 시간 초과난 조합 함수
	public static void comb(int depth, int start) {
		if(depth == 2) {
			int sum = 0;
			for (int i = 0; i < cow_size.length; i++) {
				if(visited[i]) sum += cow_size[i];	
			}
			if(sum <= S) result++;	 // 소 두마리의 합이 코스튬 크기 보다 작은 경우
			return;
		}
		for (int i = start; i < cow_size.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
}