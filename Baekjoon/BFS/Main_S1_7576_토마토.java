package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int day;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Main_S1_7576_토마토{
	// 상, 하, 좌, 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Tomato> q;
	static int N, M;// 상자 행, 열 저장받을 변수.
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
		// 정수 1은 익은 토마토, '0은' 익지 않은 토마토, '-1' 토마토가 들어있지 않은칸.
		// 토마토가 모두 익을 때까지 최소 며칠 걸릴지 구하시오.
		int[][] map = new int[N][M]; // 토마토를 저장하는 큰 창고.
		q = new LinkedList<Tomato>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) // 익은 토마토는 Queue에 넣는다.
					q.add(new Tomato(i, j, 0));
			}
		}
		bfs(map);
	}

	public static void bfs(int map[][]) {
		int day = 0;
		while (!q.isEmpty()) {

			// 익은 토마토의 상하좌우는 다음에 익기 때문에 큐에 담아야한다.
			Tomato Tomato = q.poll();
			day = Tomato.day;
			int x = Tomato.getX();
			int y = Tomato.getY();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 범위 안
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					// 현재 일수 +1 을 해줘야한다.
					if (map[nx][ny] == 0) { // 안익은 토마토
						map[nx][ny] = 1; // 익게 해줌.
						q.add(new Tomato(nx, ny, day + 1));
					}
				}
			}
		}
		boolean isCheck = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 토마토가 안 익은게 있으면
				if (map[i][j] == 0) isCheck = true;
			}
		}
		if (isCheck) System.out.println(-1);
		else System.out.println(day);
	}
}
