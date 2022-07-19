package DFS;
import java.util.*;
import java.io.*;
public class Main_S2_1012_유기농배추 {
	/**
	 * ( 문제 설명 )
	 * 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심
	 * 이 지렁이는 < 배추근처에 서식 >하며 "해충을 잡아 먹음으로써 배추를 보호"한다.
	 * 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다. 
	 * 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.
	 * 배추들이 모여있는 곳에는 "배추흰지렁이가" 한 마리만 있으면 되므로 
	 * 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. 
	 * 
	 * ( 문제 풀이 ) 
	 * - 핵심은 DFS에서 배추가 있는 곳에서 상, 하, 좌, 우  탐색하여 "배추들이 모여있는 집합을 다 찾았을 때" 배추 흰지렁이 수 + 1 씩 해주면 됨. 
	 */
	static int[][] map ;
	static boolean [][] visited;
	static int M,N;
	// 상, 하, 좌, 우 4방향 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 배추 밭의 가로 길이
			N = Integer.parseInt(st.nextToken()); // 배추 밭의 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수
			map = new int[M][N];
			visited = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			int result = 0;
			for(int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i,j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString()); // 정답 출력
	}
	
	public static void dfs(int r, int c) {
		for(int i = 0; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >=M || nc >=N)continue;
			if(map[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc);
			}
		}
	}
}