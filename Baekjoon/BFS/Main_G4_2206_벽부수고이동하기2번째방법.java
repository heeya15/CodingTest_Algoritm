package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206_벽부수고이동하기2번째방법 {
	static class Point{
		int r,c;
		int break_Cnt;
		int dis;
		public Point(int r, int c, int break_Cnt, int dis) {
			this.r = r;  // 행
			this.c = c;  // 열
			this.break_Cnt = break_Cnt; // 벽 부순 횟수
			this.dis = dis;  // 이동 거리
		}
	}
	static int N,M;
	static int [][] map;
	static boolean [][][] visited;
	// 델타 배열 : 상, 하, 좌, 우
	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// [][][0] 부수지 않은경우, [][][1] 부순 경우
		visited = new boolean[N][M][2]; // [행][열][벽을 부수고 온 횟수]
		for (int i = 0; i < N; i++) {
			char line[] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j] - '0';
			}
		}
		result = Integer.MAX_VALUE;
		BFS(0,0);
		// 도착지 이동 불가능 할때 -1
		if(result == Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(result);
	}
	private static void BFS(int sr, int sc) {
		Queue<Point> q = new LinkedList<Point>();
		visited[sr][sc][0] = true;
		q.offer(new Point(sr,sc,0,1)); 
		top:while(!q.isEmpty()) {
			Point cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int dis = cur.dis;
			int breaked = cur.break_Cnt; // 현재 좌표까지 오면서 벽을 부순 횟수
			// [ 도착 지점 ]에 도착했다면, 최단 거리를 출력.
			if(r==N-1 && c == M-1) {
				result = Math.min(result, dis);
				break top;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc < 0 || nr >= N || nc >=M)continue;
				// 이동 가능한 공간이며 ,[행][열][벽을 부수고 온 횟수] 가 방문하지 않았다면.
				if(map[nr][nc] == 0) {
					if(visited[nr][nc][breaked] == false) {
						visited[nr][nc][breaked] = true;
						q.offer(new Point(nr,nc,breaked,dis+1));
					}
				}		
				// 최대 한칸 벽을 부술 수 있고, 현재 이동 좌표가 벽인 경우.
				if(breaked+1 < 2 && map[nr][nc] == 1) {
					// 현재 이동한 좌표까지 벽을 한번도 안 부쉈다면
					if(visited[nr][nc][breaked+1] == false) {
						// 벽 부숨 체크 후, 벽 부순 횟수, 이동거리 1씩 증가해서 q에 담아줌.
						visited[nr][nc][breaked+1] = true;
						q.offer(new Point(nr,nc,breaked+1,dis+1));
					}
				}
			}
		}
	}
}
