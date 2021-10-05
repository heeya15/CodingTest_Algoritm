package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오. 
public class Main_S1_2468_안전영역 {
	static int N;
	static boolean[][] visited;
	static int[][] map, savemap;
	static int max;
	// 델타 배열 : 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 행, 열의 개수 입력
		map = new int[N][N];
		int max_height = 0; // 맵에서 가장큰 높이 값을 저장받기 위한 변수
		// 2차원 배열 입력 및 맵에서 가장큰 값 구함.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, map[i][j]);
			}
		}
		// 2
		// 1 1 
		// 1 1 입력시 0이하 안전한 영역은 1개이기 때문에 max 초기값 1로 설정.
		max = 1; 
		// 높이가 1이하에서 ~ 맵에서 가장 큰 높이 값 이하까지 반복. 
		for (int i = 1; i <= max_height; i++) {
			int count = 0; // 맵에서 안전한 영역의 개수 세어줌.
			savemap = new int[N][N];	 // 안전한 영역 1, 물에 잠긴 지역 0으로 표시할 2차원 배열.
			visited = new boolean[N][N]; // 해당 안전한 영역 방문 처리용.
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) savemap[j][k] = 0;
					else savemap[j][k] = 1; // 높이 이하가 아니여서 안전한 영역 표시.
				}
			}
			// 안전한영역이면서, 방문하지 않았을 경우.
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (savemap[j][k] == 1 && !visited[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true; // 현재 안전한 좌표 방문처리
		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				// 안전하며, 방문하지 않았다면 방문처리 dfs호출
				if (savemap[nr][nc] == 1 && !visited[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
}
