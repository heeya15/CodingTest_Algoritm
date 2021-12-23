package BFS;
import java.io.*;
import java.util.*;
public class Main_S1_2178_미로탐색 {
	static int N,M;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 렬
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				int num = line.charAt(j)-'0';
				map[i][j] = num;
			}
		}
		BFS(0, 0, N-1, M-1); // 인수로, 시작 좌표, 도착 좌표 넣어줌.
		System.out.println(map[N-1][M-1]); // 출력
	}
	private static void BFS(int sr, int sc, int er, int ec) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {sr,sc}); // 처음 시작 좌표 큐에 넣어줌.
		visited[sr][sc] = true;
		top:while(!q.isEmpty()) {
			int [] pos = q.poll(); // 시작 좌표 큐에서 꺼내줌.
			int r = pos[0];
			int c = pos[1];
			// 4방 탐색
			for(int i=0; i< 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 경계값을 벗어나는 경우 무시
				if(nr < sr || nc < sc || nr > er || nc > ec)continue;
				// 경계값을 벗어나지않고, 갈 수 있는 길이고, 방문하지 않았다면
				if(map[nr][nc] ==1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					map[nr][nc] = map[r][c] +1;
					if(nr == er && nc ==ec)break top;// 만약 이동한 길이 최종 도착지일 경우 while문에서 나감.
					q.add(new int[] {nr,nc});
				}
			}
		}
	}
}
