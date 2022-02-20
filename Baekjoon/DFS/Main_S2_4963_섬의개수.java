package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 정사각형으로 이루어져 있는 [ 섬과 바다 지도가 ] 주어진다. '섬의 개수를 세는 프로그램'을 작성하시오.
 * 한 정사각형과 [ 가로, 세로 또는 대각선으로 연결되어 있는 사각형 ]은 걸어갈 수 있는 사각형이다. 
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 [ 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. ] 
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 * dfs 방법으로 해결.
 */
public class Main_S2_4963_섬의개수 {
	static StringBuilder sb = new StringBuilder();
	static int w, h;
	static int [][] map;
	static boolean [][] visited;
	// 상, 하, 좌, 우, 상좌, 상우, 하좌, 하우
	static int [] dr = {-1,1,0,0,-1,-1,1,1};
	static int [] dc = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken()); // 너비(열)
			h = Integer.parseInt(st.nextToken()); // 높이(행)
			map = new int[h][w];
			visited = new boolean[h][w];
			if(w == 0 && h == 0)break; // 입력의 마지막 줄에 0이 두개 주어지면 while문 종료.
			
//			2. h개 줄에는 지도가 주어짐 '1'은 땅, '0'은 바다.
			for(int i = 0; i < h ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j< w ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int x, int y) {
		
		for(int i =0; i< dr.length; i++) {
			int nr = x + dr[i]; 
			int nc = y + dc[i];
			// 범위를 넘거나, 방문한적이 있거나, 땅이 아니라면 무시하기.
			if(nr <0 || nc < 0 || nr >=h || nc >=w  || visited[nr][nc] || map[nr][nc] == 0)continue;
			visited[nr][nc] = true;
			dfs(nr,nc);
		}
	}
}
