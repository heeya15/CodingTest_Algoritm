package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 기출문제. -- 구현/시뮬레이션.
public class Main_G5_14503_로봇청소기_구현방법 {
	static int N, M;
	// 상,우, 하, 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행(세로)
		M = Integer.parseInt(st.nextToken()); // 열(가로)
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		// 로봇 청소기의 < 행,렬 좌표 > d: 바라보는 방향
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		// 빈칸= 0, 벽은 = 1
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0; // 현재 위치를 청소하니 1로 세어줌.
		clean(r, c, d); // 청소기 위치, 바라보는 방향 인수로 넘겨줌

		// 로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램.
		System.out.println(count);
	}

	private static void clean(int r, int c, int dir) {
	top: while (true) {
		// 1. 현재 위치를 청소한다.
			map[r][c] = 2; // 청소 표시 2로 함.
			count++;
		re_one: while (true) {
		// 2. 현재 위치에서 왼쪽 방향(델타 배열을 왼쪽으로) 부터 차례대로 탐색을 진행한다.
				for (int i = 1; i <= 4; i++) {
					dir--; // 현재 방향에서 방향을 왼쪽방향으로 돌림.
					if (dir == -1) dir = 3; // 북쪽 이였을때 왼쪽으로 가려면 다시 배열의 끝으로 가야해서 "서쪽"으로 이동.
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if (nr < 0 || nc < 0 || nr > N || nc > M ) continue;
					
					// a. 왼쪽 방향 청소하는 공간 존재할 경우.
					if(map[nr][nc] == 0) {
						// 현재 청소한 좌표 셋팅
						r = nr; 
						c = nc;
						break re_one; // 청소할 곳을 찾았다면 break; -->  다시 1번으로 이동.
					}
					// b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
					// 즉, 왼쪽으로 회전한 방향의 앞이 청소할 공간이 없다면, 다시 왼쪽으로 회전한다.
					if(map[nr][nc]==2 || map[nr][nc] ==1)continue;
				}
				/**
				 * 남(2) -> 북(0) 
				 * 북(0) -> 남(2) 
				 * 동(1) -> 서(3)   --> 뒤로갈때 패턴이 2씩 차이남 (현재방향+2) %4 를 하면 뒤로가는 방향 구해짐
				 * 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는 뒤쪽 칸이 벽이 아니라는 전제 하에, 
				 * 바라보는 방향을 유지한 채로 [ 한 칸 후진.]
				 **/
				int back = (dir + 2) % 4;
				int back_nr = r + dr[back];
				int back_nc = c + dc[back];
				// c. 모두 청소가 되어 있거나, 벽이였을경우 못찾아서,
				// 현재 방향에서 뒤로 한칸 이동하고 경계값 안넘고, 벽이 아닌 경우 < 다시 2번 처음으로 돌아감. > --> 
				if (back_nr >= 0 && back_nc >= 0 && back_nr < N && back_nc < M 
						&& map[back_nr][back_nc] != 1) {
					r = back_nr;
					c = back_nc;
				}
				// d. 경계값을 넘거나 "벽"이면서, 후진도 할 수 없는 경우에 작동 멈춤.
				else if (back_nr < 0 || back_nc < 0 || back_nr > N || back_nc > M 
						|| map[back_nr][back_nc] == 1 )break top;
			}
		}
	}
}
