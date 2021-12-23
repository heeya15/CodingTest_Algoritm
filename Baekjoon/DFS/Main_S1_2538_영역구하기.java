package DFS;
import java.io.*;
import java.util.*;
public class Main_S1_2538_영역구하기 {
	static int M,N,K;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int area_count;
	static int res; // 영역의 넓이로 사용될 변수.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		K = Integer.parseInt(st.nextToken()); // K개의 직사각형의 좌표가 주어짐.
		map = new int[N][M]; // 그림에서 왼쪽 아래 꼭짓점을 [ 왼쪽위 꼭짓점으로 옮긴 상태로 ] 배열을 받을려고 이와 같이 설정.
		for(int i= 0;  i< K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int lr = Integer.parseInt(st.nextToken());
			int lc = Integer.parseInt(st.nextToken()); // 왼쪽 아래 꼭짓점 -> 나는 왼쪽 위 꼭짓점.
			int rr = Integer.parseInt(st.nextToken());
			int rc = Integer.parseInt(st.nextToken()); // 오른쪽 아래 꼭짓점
			for(int r=lr; r<rr; r++) {  // 왼쪽 위 꼭짓점 행 ~ 오른쪽 아래 꼭짓점 행까지
				for(int c=lc; c< rc; c++) { // 왼쪽 위 꼭짓점 열 ~ 오른쪽 아래 꼭짓점 열까지
					map[r][c] = 1;
				}
			}
		}
		visited = new boolean[N][M]; // 방문 처리 용도 배열
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 직사각형 내부가 아닌 분리된 영역 이고, 방문하지 않았을 경우.
				if(map[i][j] == 0 && visited[i][j] == false) {
					// 처음 위치는 세어주고, 방문 처리 해준 상태에서 넓이 구함.
					res = 1; 
					visited[i][j] = true;
					int count = dfs(i,j);
					result.add(count); // 리스트에 영역의 넓이 추가.
					area_count++; // 분리되어 나누어지는 영역의 개수 +1 처리.
				}
			}
		}
		Collections.sort(result);// 각 영역의 넓이 오름차순으로 정렬
		for (int i = 0; i < result.size(); i++) sb.append(result.get(i)).append(" ");
		System.out.println(area_count); // 분리되어 나누어지는 영역의 개수 출력.
		System.out.println(sb); // 출력.
	}
	private static int dfs(int r, int c) {
		for (int i = 0; i < 4; i++) { // 4방향 탐색 부분
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 경계값을 넘을경우 무시
			if(nr<0 || nc <0 || nr >=N || nc >= M)continue;
			if(map[nr][nc] ==1 || visited[nr][nc])continue; // 해당 직사각형 내부 또는 방문한 적이 있다면 무시.
			else { // 직사각형 내부가 아니면서, 방문하지 않고, 경계값을 벗어나지 않을경우
				res++; // 넓이 1 추가.
				visited[nr][nc] = true; // 해당 영역 방문처리
				dfs(nr,nc);
			}
		}
		return res; // 영역의 넓이 리턴.
	}
}
