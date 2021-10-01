package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 당신의 병사 : W
// 적국의 병사 : B
public class Main_S1_1303_전쟁전투 {
	static int N,M;
	// 하, 좌,우,상
	static int dx[] = {1,0,0,-1};
	static int dy[] = {0,-1,1,0};
	static boolean [][] isSelected ;
	static char [][] map;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		isSelected = new boolean[N][M];
		StringBuilder sb = new StringBuilder();
		int your = 0;
		int juck = 0;
		// N명이 뭉쳐있을 때는 N^2의 위력을 낼 수 있다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(isSelected[i][j]==false) { // 해당 좌표 방문하지 않을 경우.
					cnt = 1;
					isSelected[i][j] = true;
					dfs(i,j, map[i][j]);
					if(map[i][j]=='W') your += Math.pow(cnt,2);  // 당신의 병사의 위력의 합
					else if(map[i][j]=='B') juck += Math.pow(cnt,2); // 적국의 병사 위력의 합.
				}
			}
		}
		sb.append(your).append(" ").append(juck);
		System.out.println(sb);
	}
	private static void dfs(int x, int y,char color) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx <0 || ny<0 || nx >=N || ny >= M)continue;
			
			if(color != map[nx][ny] || isSelected[nx][ny] == true)continue;
			else {
				isSelected[nx][ny] = true;
				cnt++;
				dfs(nx,ny,map[nx][ny]);		
			}
		}
	}
}