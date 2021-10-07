package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//적록색약이 아닌 사람이 봤을 때의 구역의 개수와 
//적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
// 빨강-초록 한 묶음이 적록색약일때 같은 색깔로 생각함.
public class Main_G5_10026_적록색약 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, jungsang, juckrock;
	static char [][] grid1, grid2;
	static boolean [][] visited1, visited2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid1 = new char[N][N]; // 정상 맵
		grid2 = new char[N][N]; // 적록색약인 맵
		visited1 = new boolean[N][N]; // 정상인 사람 같은 색깔 구역의 수 세어줌
		visited2 = new boolean[N][N]; // 적록색약 인 사람 같은 색깔 구역의 수 세어줌
		for (int i = 0; i < N; i++) {
			char [] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				grid1[i][j] = line[j];
				// 적록색약인 경우 (빨강, 초록 ) 한 묶음으로 보아서
				// 따로 적록색약인 사람이 보이는 형태의 그리디 맵으로 변경 해줌.
				if(line[j] == 'R') grid2[i][j] = 'G';
				else grid2[i][j] = line[j];
			}
		}
		jungsang = 0;
		juckrock = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited1[i][j] == false) { // 해당 좌표 방문 하지 않았을 경우
	//   현재좌표, 정상 그리드 맵, 적록색약 아닌 사람의 방문여부 배열, 현재 탐색기준으로 할 색깔 넘겨줌
					dfs(i,j,grid1,visited1, grid1[i][j]);
					jungsang++; // 적록색약이 아닌 사람 증가
				}
				if(visited2[i][j] == false) {
	//   현재좌표, 적록색약 그리드 맵, 적록색약인 사람의 방문여부 배열, 현재 탐색기준으로 할 색깔 넘겨줌
					dfs(i,j,grid2,visited2, grid2[i][j]);
					juckrock++; // 적록색약인 사람 증가.
				}
			}
		}
		System.out.println(jungsang+" "+juckrock);
	}
	private static void dfs(int r, int c, char[][] map, boolean[][] visited, char color) {
		visited[r][c] = true; // 처음 탐색할 좌표 방문처리
		// 4방 탐색 시작. 같은 색상이 상,하,좌,우로 인접해 있는지.
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 경계값 벗어나지 않으며, 해당 그리드 칸 방문하지 않았고.
			if (nr >= 0 &&  nc >= 0 &&  nr < N && nc < N && !visited[nr][nc] ) {
				// 탐색 기준 컬러와, 이동한 좌표 컬러가 같다면 < 깊이 탐색 더 해줌. >
				if(map[nr][nc] == color) {
					dfs(nr, nc, map, visited, color);
				}
			}
		}
	}
}
