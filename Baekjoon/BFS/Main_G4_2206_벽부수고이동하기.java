package BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206_벽부수고이동하기{
	static class Node {
		int x, y; // 좌표
		int distance; // 거리
		int wall_count; // 벽

		public Node(int x, int y, int distance, int wall_count) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.wall_count = wall_count;
		}
	}
	static int N, M;
	// 좌, 우 , 상,하
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean [][][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		// [][][0] 부수지 않은경우, [][][1] 부순 경우
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				int temp = line.charAt(j) - '0';
				map[i][j] = temp;
			}
		}
		bfs(map);
	}
	private static void bfs(int[][] map) {
		Queue<Node> q = new LinkedList<Node>();
		
		visited[0][0][0]= true;
		int min = Integer.MAX_VALUE; // 최단거리 결과 저장받을 변수.		
		q.offer(new Node(0, 0, 1, 0)); // 시작좌표, 시작하는 칸도 거리로로 쳐줌, 벽 부숨여부.
		top: while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int dis = node.distance;
			int breaked = node.wall_count;
			
			if (x == N - 1 && y == M - 1) {
				min = Math.min(min, dis);
				break top; // 최종 도착지라면 break;
			}
			// 주변 칸을 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)continue;
			
				// 벽을 부순적이 없고, 해당 좌표 벽을 부수지 않은 경우.
				if (breaked == 0 && visited[nx][ny][0] == false) {
					if (map[nx][ny] == 1) { // 벽을 만난경우.
						q.offer(new Node(nx, ny, dis + 1, breaked + 1));
						visited[nx][ny][1] = true; // 부쉈다 표시
					} else {// 벽을 만나지 않은 경우.
						q.offer(new Node(nx, ny, dis + 1, breaked));
						visited[nx][ny][0] = true; // 부수지 않았다 표시
					}
					// 벽을 부순적이 있고, 해당 좌표 벽을 부순적이 없는경우 
				} else if (breaked == 1 && visited[nx][ny][1] == false) {
					if (map[nx][ny] == 0) {// 벽이 아닌경우만 거리증가 및 해당 좌표 부수지 않은 걸 방문 처리해줌.
						q.offer(new Node(nx, ny, dis + 1, breaked));
						visited[nx][ny][1] = true;
					}
				}
			}
		}// while문 end
		if(min == Integer.MAX_VALUE)System.out.println("-1");
		else System.out.println(min);
	}
}