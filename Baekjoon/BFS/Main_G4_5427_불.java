package BFS;
import java.io.*;
import java.util.*;
/**
 * 매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. 
 * '벽'에는 [ 불이 붙지 않는다. ] 다음 h개 줄에는 w개의 문자,빌딩의 지도가 주어진다. 
 * '.': 빈 공간 
 * '#': 벽 
 * '@': 상근이의 시작 위치 
 * '*': 불 
 * 각 지도에 @의 개수는 하나이다.
 */
public class Main_G4_5427_불 {
	static class Pos{
		int r,c,time;
		public Pos(int r, int c, int time) { // 상근이의 이동 좌표와 시간 저장받을 생성자.
			this.r = r;
			this.c = c;
			this.time = time;
		}
		public Pos(int r, int c) { // 불이 퍼지는 좌표를 받을 생성자
			this.r = r;
			this.c = c;
		}
	}
	static int w, h; // 빌딩 지도 너비와 높이를 담을 변수
	static char[][] building; 
	static boolean[][] visited;
	static Queue<Pos> q ; // 사람의 위치를 넣을 큐
	static Queue<Pos> fire;// 불의 위치를 넣을 큐
	// 동, 서 , 남 , 북
	static int[] dr = {0,0,1,-1}; 
	static int[] dc = {1,-1,0,0};
	static int res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케 수 입력
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			building = new char[h][w];		
			visited = new boolean[h][w];
			q = new LinkedList<Pos>();
			fire = new LinkedList<Pos>();
			// 빌딩의 지도 입력.
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					building[i][j] = line.charAt(j);
					if (building[i][j] == '@') { // 상근이의 시작 위치라면.
						visited[i][j] = true;
						q.add(new Pos(i,j,0));
					} else if (building[i][j] == '*') { // 불 위치라면
						fire.add(new Pos ( i, j ));
					}
				}
			}
			res = 0;
			bfs();
			if (res == 0)sb.append("IMPOSSIBLE").append("\n"); // 탈출할 수 없는 경우
			else sb.append(res).append("\n"); // 탈출하는데 가장 빠른 시간.
		}
		System.out.println(sb);
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			burn(); // 불이 1초마다 옮겨짐.
			/** 
			 - 큐안에 이동할 수 있는 경우의 좌표를 넣었기 때문에, 큐 사이즈가 끝날때까지 반복  
			 - 즉, 1초 동안 동,서,남,북 '빈 공간으로' 인접한 칸으로 이동할 수 있는 모든 경우의 수를 구해야 정답이 나옴. 
			 - 큐 사이즈 만큼 돌리지 않으면 모든 경우가 아니라 상근이가 이동할 수 있는 
			   [ 경우의 수 중  하나만 1초동안 이동한 것을 시간 체크 ]하고 불을 또 퍼트리는 식이 되어 문제가 되었음.
			 **/
			for (int d = 0, size = q.size(); d < size; d++) {
				Pos p = q.poll();
				int r = p.r;
				int c = p.c;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					// 경계값을 벗어나는 경우 방 탈출
					if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
						res = p.time +1;
						return;
					}
					// 경계값을 벗어나지않고, 갈 수 있는 길이고, 방문하지 않았다면
					if (building[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Pos(nr, nc, p.time + 1));
					}
				}
			}
		}
	}

	public static void burn() {
		int size = fire.size();
		for (int s = 0; s < size; s++) {
			Pos p = fire.poll();
			// 동, 서, 남 , 북 4방 인접한 빈 공간으로 1초마다 불 퍼져나감.
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
				// 1초마다 불이 퍼짐. 벽을 제외한 빈 공간 또는 상근이의 시작 위치에 불이 퍼짐.
				if (building[nr][nc] == '.' || building[nr][nc] == '@') {
					building[nr][nc] = '*';
					fire.add(new Pos(nr,nc));
				}
			}
		}
	}
}
