package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_S1_2667_단지번호붙이기 {
	static int cnt=1; // 단지내 집의 수를 세어주기 위한 카운터 변수.
	static int N; // 지도의 크기 저장받을 변수.
	static int [][] map;
	static boolean [][] visited;
	// 상, 우 , 하, 좌
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());// 지도의 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		// 정사각형 모양 지도 입력.
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				int temp = line.charAt(j)-'0';
				map[i][j] = temp;
			}
		}
		int count = 0; // 총 단지 수를 저장하기 위한 변수
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이 있는 곳이며, 아직 방문 하지 않은 곳일 경우.
				if(map[i][j]==1 && visited[i][j]==false) {
					cnt=1;
					count++;
					visited[i][j] = true;// 해당 좌표 방문 처리.
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		sb.append(count).append("\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");	// 각 단지내 집의 수 오름차순 저장.
		}
		System.out.println(sb);	
	}
	private static void dfs(int x,int y) {
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || ny <0 ||  nx>=N || ny >= N) continue;
			// 집이 아니거나, 이미 방문 했다면 무시.
			if(map[nx][ny] ==0 || visited[nx][ny]== true) continue;
			
			else { // 집이면서, 방문하지 않고, 경계값을 벗어나지 않을경우.
				cnt++;
				visited[nx][ny] = true;// 해당 좌표 방문 처리
				dfs(nx,ny);
			}	
		}

	}
}
