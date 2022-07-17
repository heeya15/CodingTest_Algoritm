package BFS;
import java.io.*;
import java.util.*;

public class Main_G5_17836_공주님을구해라 {
	/**
	 * 용사는 현재의 가지고 있는 무기로는 마법 벽을 통과할 수 없으며, 마법 벽을 피해 (N, M) 위치에 있는 공주님을 구출해야만 한다.
	 * 공주님을 구출하고 프러포즈 하고 싶은 용사는 < 반드시 T시간 내에 > 공주님이 있는 곳에 도달
	 * 용사는 한 칸을 이동하는 데 한 시간이 걸린다. 
	 * 공주님이 있는 곳에 정확히 T시간만에 도달한 경우에도 구출할 수 있다. 용사는 상하좌우로 이동할 수 있다.
	 * 
	 * 성에는 이전 용사가 사용하던 전설의 명검 "그람"이 숨겨져 있다. 
	 * 용사가 "그람을 구하면" < 마법의 벽이 있는 칸 >일지라도, 단숨에 벽을 부수고 그 공간으로 갈 수 있다.
	 * "그람"은 성의 어딘가에 반드시 한 개 존재하고, 
	 * 용사는 그람이 있는 곳에 도착하면 바로 사용할 수 있다. < 그람이 부술 수 있는 벽의 개수는 제한이 없다. >
	 * 
	 * 첫 번째 줄에 성의 크기 N,M 그리고 공주에게 걸린 저주의 제한 시간인 정수 T가 주어진다.
	 */
	static class Point {
		int x; // x좌표
		int y; // y좌표
		int time; // 걸린 시간
		int isGram; // 그람 유무

		public Point(int x, int y, int time, int isGram) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.isGram = isGram;
		}
	}
	static int N, M, T;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		T = Integer.parseInt(st.nextToken()); // 저주의 제한 시간
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 검을 주운 이후에 벽을 앞지르는 경우를 체크하기 위해 3차원 방문 처리 배열 선언.
		// 맵 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0,0);
		// 조건 맞춰서 결과 출력
		if (result == Integer.MAX_VALUE) System.out.println("Fail");
		else System.out.println(result);
	}

	private static void bfs(int sr, int sc) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc,0,0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int time = p.time;
			int isGram = p.isGram;
			if(time > T) continue; // 용사가 저주의 제한 시간 내에 N, M 위치에 도달하지 못했을 경우 무시.
			if(x == N-1 && y == M-1) { // 저주 제한 시간 내에 공주님이 있는 곳에 도달했을 경우 
				result = Math.min(result, time); // 최단 시간이라면 갱신 시켜준다.
			}
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >=N || ny >=M)continue;
				if(isGram == 0) { // 그람이라는 검을 줍지 않았을 경우
					if(map[nx][ny] != 1 && !visited[nx][ny][isGram]) { // 벽이 아니고, 방문하지 않았다면
						visited[nx][ny][isGram] = true; 
						if(map[nx][ny] == 0) q.add(new Point(nx,ny,time+1, isGram)); 
						if(map[nx][ny] == 2) q.add(new Point(nx,ny,time+1, 1)); // 그람 습득
					}
				}else { // 그람을 주웠을 경우
					if(!visited[nx][ny][isGram]) { // 모든 좌표로 갈 수 있고, 방문하지 않았을 경우 방문 처리.
						visited[nx][ny][isGram] = true;
						q.add(new Point(nx,ny,time+1, isGram));
					}
				}
			}
		}
	}
}