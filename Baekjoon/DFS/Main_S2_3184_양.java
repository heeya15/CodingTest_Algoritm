package BOJ;
import java.io.*;
import java.util.*;
/**
 * '.' (점): 빈 필드를 의미하며, 
 * '#': 울타리를, 
 * 'o': 양, 
 * 'v': 늑대를 의미한다.
 * 한 칸에서 수평, 수직만으로 이동하며 "울타리를 지나지 않고" 다른 칸으로 이동할 수 있다면,
 * [ 두 칸은 같은 영역 ] 안에 속해 있다고 한다. 
 * [ 우리의 양은 늑대에게 싸움을 걸 수 있고 ] 영역 안의 양의 수가 [ 늑대의 수보다 많다면 ] 이기고,
 * 늑대를 우리에서 쫓아낸다. 그렇지 않다면 [ 늑대가 그 지역 안의 모든 양을 먹는다. ]
 *
 * [ 출력 ]
 * 아침이 도달했을 때 "살아남은 양"과 "늑대의 수"를 출력하는 프로그램을 작성
 */
public class Main_S2_3184_양 {
	static int R, C;
	static char [][] map;
	static boolean [][] visited;
	static int sheep_result, wolf_result, sheep, wolf ;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		// 마당의 구조에 글자 정보 입력.
		for (int i = 0; i < R; i++) {
			char [] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j]; 
			}
		}
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				 방문 하지 않고, 해당 좌표에서 양 또는 늑대 인 경우 dfs 탐색 시작.
				if((map[i][j] =='o' || map[i][j] == 'v')&& !visited[i][j]) {
					sheep=wolf=0;
					visited[i][j] = true;
//					System.out.println("좌표: "+i +" "+ j);
					dfs(i,j);
//					 양이 늑대의 수보다 범위에서 많다면 양이 이김
					if(sheep > wolf) sheep_result += sheep;
//					 그렇지 않다면 늑대가 이김.
					else wolf_result += wolf;
				}
			}
		}
//		출력
		System.out.println(sheep_result +" " + wolf_result);
	}
	private static void dfs(int r, int c) {
		if(map[r][c] == 'o') sheep++;
		else if(map[r][c] == 'v') wolf++;
		for(int i = 0; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 경계값 넘거나, 울타리인 경우 탐색 x.
			if(nr < 0 || nc < 0 || nr >=R || nc >=C || 
					visited[nr][nc] ||  map [nr][nc] =='#') continue;
			visited[nr][nc] = true;
			dfs(nr,nc);	
		}	
	}
}
