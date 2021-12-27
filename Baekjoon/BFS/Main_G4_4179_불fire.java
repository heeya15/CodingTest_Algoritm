package BFS;
import java.io.*;
import java.util.*;
/**
 * 불은 각 지점에서 네 방향으로 확산된다. 
     지훈이는 [ 미로의 가장자리에 접한 공간 ]에서 탈출할 수 있다. 
  '지훈이'와 '불'은 벽이 있는 공간은 [ 통과하지 못한다. ]
  #: 벽
  .: 지나갈 수 있는 공간
  J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
  F: 불이 난 공간
  J는 입력에서 하나만 주어진다.
 */
public class Main_G4_4179_불fire {
	static class Pos{
		int r,c,time;
		public Pos(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int R, C;
	static char [][] map;
	// 동, 서, 남, 북 4방 델타배열 선언
	static int [] dr = {0,0,1,-1};
	static int [] dc = {1,-1,0,0};
	static Queue<Pos> q, fire;
	static boolean [][] visited;
	static int time = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 두 정수 R과 C 입력
		R = Integer.parseInt(st.nextToken()); // 미로 행의 개수
		C = Integer.parseInt(st.nextToken()); // 미로 열의 개수
		map = new char[R][C];
		visited = new boolean[R][C];
		q = new LinkedList<Pos>();
		fire = new LinkedList<Pos>();
		
		// 미로 맵 정보 입력.
		for (int i = 0; i < R; i++) {
			char temp [] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if(map[i][j] == 'J') {// 지훈이의 초기 위치
					visited[i][j] = true;
					q.add(new Pos(i,j,0)); 
				}
				else if(map[i][j] == 'F')fire.add(new Pos(i,j)); // 불이 난 공간
			}
		}
		BFS();
		if(time == Integer.MAX_VALUE)System.out.print("IMPOSSIBLE");
		else System.out.println(time);
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			burn();
			for (int i = 0, size = q.size(); i < size; i++) {
				Pos p = q.poll();
				int r = p.r;
				int c = p.c;
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if(nr < 0 || nc < 0 || nr>=R || nc >=C) {// 미로를 탈출한 경우.
						 time = p.time + 1;
						 return;
					}
					if(map[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Pos(nr,nc,p.time+1));	
					}
				}
			}
		}
	}
	private static void burn() { // 1초마다 불 확장 함수.
		for (int i = 0, size = fire.size(); i < size; i++) {
			Pos p = fire.poll();
			for (int j = 0; j < 4; j++) {
				int nr = p.r + dr[j];
				int nc = p.c + dc[j];
				// 경계값을 넘을 경우 무시.
				if(nr < 0 || nc < 0 || nr>=R || nc >=C)continue;
				
				if(map[nr][nc] =='J' || map[nr][nc] == '.') { 
					map[nr][nc] = 'F';
					fire.add(new Pos(nr,nc));
				}
			}
		}
	}
}
