import java.io.*;
import java.util.*;

/**
 * 빈 칸은 '.'로, 폭탄은 'O'로 주어진다.
 * 1. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
   2. 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
   3. 다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
   4. 1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
   - 3과 4를 반복한다.
 */
public class Main_S1_16918_봄버맨 {
	static int R,C,N;
	static char [][] map;
	static Queue<int []> q;
	static boolean [][] visited;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // N초
		map = new char[R][C];
		q = new LinkedList<>(); 
		// 가장 처음 봄버맨 일부 칸에 폭탄 설치 해 놓음.
		for(int i = 0; i < R ; i++) {
			char [] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if(map[i][j] == 'O') q.offer(new int[] {i,j}); 	 // 폭탄 부분 q에 담아 둠
			}
		}
		int time = 1;
		while(time <N) {
			time++;
			if(time % 2 == 0) allPoktan(); // 짝 수면 모든 폭탄 다 채워줌
			// 홀 수면  기존 폭탄의 위치가 폭발하여 상,하,좌,우 터트려서 빈칸으로 만들어줌.
			else if (time % 2 == 1) bfs(); 	 	
		}
		for(int i = 0; i < R ; i++) {
			for (int j = 0; j < C; j++) sb.append(map[i][j]);	
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
	private static void bfs() {
		visited = new boolean[R][C];
		while(!q.isEmpty()) {
			int [] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			if(visited[r][c] == false) { // 방문 하지 않았으면 방문처리 및 빈칸 처리
				visited[r][c] = true;
				map[r][c] = '.';
			}
			for(int i =0; i < 4; i++) {
				int nr = dr[i] + r;
				int nc = dc[i] + c;
				if(nr <0 || nc < 0 || nr >= R || nc >=C )continue;
				if(!visited[nr][nc]) {
					visited[nr][nc] = true;
					map[nr][nc] = '.';
				}
			}
		}
		q = new LinkedList<>();
		for(int i = 0; i < R ; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'O') {
					q.offer(new int[] {i,j}); 
				}
			}
		}
	}
	public static void allPoktan() {
		for(int i = 0; i < R ; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}
	}
}
