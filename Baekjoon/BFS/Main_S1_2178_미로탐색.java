package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {
	static int count;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 3,5 까지
		int map[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				int temp = line.charAt(j)-'0';
				map[i][j] = temp;
			}
		}
		count = 1;
		bfs(map, 0, 0, N, M); // 인수로, 시작 좌표, 도착 좌표 넣어줌.
		System.out.println(map[N-1][M-1]);
	}
	// 맵, 시작 좌표, 최종 도착 좌표 -인수로 받음
	private static void bfs(int[][] map, int sr, int sc, int er, int ec) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { sr, sc }); // 처음 시작 좌표 큐에 넣어줌.
		map[sr][sc] = count;
		// 큐가 비어있지 않다면.
		top:while (!q.isEmpty()) {
			int temp [] = q.poll(); // 시작 좌표 꺼내줌.
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 경계값을 벗어나는 경우 무시.
				if (nx<0 || ny <0 || nx >=er || ny >=ec ) continue;
				if (map[nx][ny]==0) continue; // 갈 수 없는 길이라면
				// 경계값을 벗어나지않고, 갈 수 있는 길이라면.
				if(map[nx][ny] ==1) {
					q.offer(new int[] {nx,ny});
					map[nx][ny] = map[x][y]+1;
					// 만약 이동한 길이 최종 도착지일 경우 while문에서 나감.
					if(nx==er-1 && ny == ec-1)break top; // 최종 도착지라면 break;
				}
			}
		}
	}
}