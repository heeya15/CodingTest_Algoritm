package BOJ;
import java.io.*;
import java.util.*;
public class Main_G4_1987_알파벳 {
	static int R,C;
	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean [] ischecked = new boolean[26]; // 알파벳 방문 처리용;
	static char [][] map;                // 보드에 대문자 알파벳을 저장 받을 2차원 배열 초기 선언.
	static int max = Integer.MIN_VALUE;  // 최대한 이동할 수 있는 칸의 수를 저장하는 변수.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		// 보드에 좌표 값 대문자 알파벳 입력
		for (int i = 0; i < R; i++) {
			char [] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) map[i][j] = temp[j];	
		}
		// 좌측 상단칸 말이 놓여 있다고 하여 저장해 놓음.
		int index = map[0][0];
		ischecked[index - 'A'] = true; // 해당 칸 방문 처리.
		dfs(0,0,1);                   // 시작 좌표, 이동 거리 카운 트 수 매개변수로 넘겨줌.
		System.out.println(max);      // 결과 출력.
	}
	private static void dfs(int r, int c, int cnt) {	
		for(int i = 0; i< 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];	
			// 경계내에 있는지 체크
			if(nr < 0 || nc < 0 || nr >=R || nc >= C)continue;
			int index = map[nr][nc];
			if(!ischecked[index - 'A']) {      // 이동 가능하며, 해당 알파벳을 방문하지 않은 경우
				ischecked[index - 'A'] = true; // 해당 알파벳 방문 처리
				dfs(nr,nc, cnt+1);
			}
		}
	/**		
	   위 방향으로 이동하고 나서 다시 4방으로 갈 수 없을 경우 현재 좌표 알파벳 방문 처리 false 처리
	  "이유는" 위 방향 이동한 좌표 값의 알파벳이, 이동하기전 좌표에서 하,좌,우 중에 동일한 알파벳이 있을 경우 
	    그 방향으로도 더 이동하여 말이 최대한 이동할 수 있는 거리를 구하기 위해서 해줘야 함.
	**/
		int index = map[r][c];
		ischecked[index - 65] = false; // 방문 했던거를 다시 풀어주고 다른 곳으로 이동.
		max = Math.max(max, cnt);
	}
}