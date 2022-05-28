package BOJ;

import java.io.*;
import java.util.*;
/**
 * 연구소 2
 * 연구소는 빈 칸, 벽으로 이루어져 있으며 -> 벽은 칸 하나를 가득 차지.
 * 일부 빈 칸은 바이러스를 놓을 수 있는 칸이다. 
 * 바이러스는 상하좌우로 인접한 "모든 빈 칸으로 < 동시에 > 복제"되며, 1초가 걸린다.
 * 0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 칸이다.
 * 연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.
 * [ 문제 접근 ] 
 * 1. 0인 빈칸 갯수 세기 -> bfs 돌려서 빈칸에 퍼질때마다 카운트를 -1 할 것이기 때문.
 * 2. 조합으로 바이러스 놓을 곳 M개를 뽑고, BFS로 바이러스 퍼트리면 문제 해결 가능
 */
public class Main_G4_17141_연구소2 {
	static class Pos {
		int r, c, time;

		public Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time; 
		}
	}

	static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static ArrayList<int[]> virus;
	static boolean[] isSelected;
	static int zeroCnt;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기
		M = Integer.parseInt(st.nextToken()); // 바이러스의 개수
		virus = new ArrayList<int[]>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) virus.add(new int[] { i, j }); // 바이러스 좌표 담음.
			    if (map[i][j] == 0) zeroCnt++;
			}
		}
		isSelected = new boolean[virus.size()];
		comb(0, 0);
		if (Min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(Min);	
	}

	static void comb(int depth, int start) {
		if (depth == M) {
			Queue<Pos> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < virus.size(); i++) {
				if (isSelected[i]) {
					visited[virus.get(i)[0]][virus.get(i)[1]] = true;
					q.add(new Pos(virus.get(i)[0], virus.get(i)[1], 0));
				}
			}
			bfs(visited, q);
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			isSelected[i] = true;
			comb(depth + 1, i + 1);
			isSelected[i] = false;
		}
	}

	static void bfs(boolean[][] visited, Queue<Pos> q) {
		int zero = zeroCnt;
		int time = 0;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			time = p.time;
			for (int j = 0; j < 4; j++) {
				int nr = p.r + dr[j];
				int nc = p.c + dc[j];
				// 방문했거나, 경계값 넘치거나,벽인경우 무시.
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || 
						   map[nr][nc] == 1 || visited[nr][nc])
					continue;
				// 방문하지 않았고, 벽이 아닌경우.
				visited[nr][nc] = true;		
				q.add(new Pos(nr, nc, time + 1));
				if (map[nr][nc] == 0) zero--; // 바이러스가 퍼질 수 있는 경로라면. -1씩 해줌.
			}
		}
		// 빈칸 없이 모든 공간 바이러스가 퍼질 경우 최소값 갱신.
		if (zero == 0) Min = Math.min(Min, time); 
	}
}
