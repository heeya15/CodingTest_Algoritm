package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 0 은 이동, 1은 이동 x --> 1,1~ N,M 으로 이동하려는데 (최단경로) 구하기 시작 칸, 
 * 도착칸 포함. 경로 횟수 세어줌. 
 * 한 칸에서 이동할 수 있는 칸은 상하 좌우로 인접한 칸 방문체크를 [ 2차원으로 수행시 ] 
 * 같은 좌표에 도달했더라도 부수고 온 벽의 갯수가 다르기 때문에 x
 */
public class Main_G3_14442_벽부수고이동하기2 {
	public static class Node {
		int r, c; // 좌표
		int distance; // 거리
		int break_count; // 벽 부순 횟 수

		public Node(int r, int c, int distance, int break_count) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.break_count = break_count;
		}
	}

	static int N, M, K;
	static int[][] map;
	// 델타 배열 : 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][][] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 벽을 부슬 수 있는 횟수
		map = new int[N][M];
		visited = new boolean[N][M][K + 1]; // [행][열][벽을 부수고 온 횟수]
		// 맵 정보 입력.
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j] - '0';
			}
		}
		result = Integer.MAX_VALUE;
		BFS(0, 0);
		// 도착지 이동 불가능 할때 -1
		if (result == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(result); // 도착지에 도착하였을때 최단 거리 출력
	}

	private static void BFS(int startR, int startC) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(startR, startC, 1, 0));// 좌표, 거리, 부순 횟수 인자로 넘겨줌.
		visited[startR][startC][0] = true;
		top:while (!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r; // 행
			int c = cur.c; // 열
			int dis = cur.distance; // 이동 거리
			int break_cnt = cur.break_count; // 현재 좌표까지 오면서 벽을 부순 횟수
			// [ 도착 지점 ]에 도착했다면, 최단 거리를 출력.
			if (r == N - 1 && c == M - 1) {
				result = Math.min(result, dis);
				break top;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 경계값 벗어나지 않는 경우.
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)continue;

				// 이동 가능한 공간이며 ,[행][열][벽을 부수고 온 횟수] 가 방문하지 않았다면.
				if (map[nr][nc] == 0) {
					if (visited[nr][nc][break_cnt] == false) {
						visited[nr][nc][break_cnt] = true;
						q.offer(new Node(nr, nc, dis + 1, break_cnt));
					}
				}
				// 즉, 다음 이동할 좌표 벽을 부숴도 최대 벽 부술 횟수 보다 작은지.
				if (break_cnt + 1 > K)continue;
				// 벽이 면서
				if (map[nr][nc] == 1) {
					// 현재 이동하면서 "벽 부순 횟수가" < 최대 벽 부술 횟수 보다 작고
					// 현재 좌표 < 벽을 부수면서 이동 가능 하다면 ?
					if (visited[nr][nc][break_cnt + 1] == false) {
						visited[nr][nc][break_cnt + 1] = true;
						q.offer(new Node(nr, nc, dis + 1, break_cnt + 1));
					}
				}
			}
		}
//		return -1; // 불가능할 때 -1 return
	}
}
