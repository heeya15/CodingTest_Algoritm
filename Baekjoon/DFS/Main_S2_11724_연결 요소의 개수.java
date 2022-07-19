package DFS;

import java.util.*;
import java.io.*;
public class Main_S2_11724_연결요소의개수 {
	static int[][] map;
	static boolean [] visited;
	static int N, M, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		map = new int[N+1][N+1]; //인접 행렬 그래프 초기화
		visited = new boolean[N+1]; 
		result = 0;
		for (int i = 1; i <= M; i++) {// 인접 행렬 그래프 구성
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		for(int i = 1; i <=N; i++) {
			if(!visited[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	public static void dfs(int start) {
		visited[start] = true;
		for(int i =1; i<=N; i++) {
			if((map[start][i] == 1 && map[i][start] == 1 ) && !visited[i]) {
				dfs(i);
			}
		}
	}
}