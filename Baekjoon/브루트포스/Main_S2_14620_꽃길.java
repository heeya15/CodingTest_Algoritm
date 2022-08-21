package 브루트포스;
import java.io.*;
import java.util.*;
/**
 * 꽃을 심을 때는 주의할 점이있다. 
 * 씨앗이 꽃이 핀 뒤 < 다른 꽃잎(혹은 꽃술)과 닿게 될 경우 > 두 꽃 모두 죽어버린다. 
 * 또 화단 밖으로 꽃잎이 나가게 된다면 그 꽃은 죽어버리고 만다.
 * 진아는 서로 다른 < 세(3개) 씨앗 >을 < "모두 꽃이 피게"하면서 가장 싼 가격에 화단을 대여 >하고 싶다.
 * 돈이 많지 않은 진아를 위하여 진아가 꽃을 심기 위해 필요한 최소비용 구하기.
 * 
 * ( 문제 풀이 )
 * 1. ( 상, 하, 좌, 우 )에 꽃잎이 있어야 하기 때문에 가장 바깥쪽 테두리 탐색은 할 필요가 없음 - 가지치기
 * 2. 현 위치를 방문하지 않고, 4 방향 모두 방문하지 않았을 경우( 꽃잎이 곂치면 안된다는 조건 때문 )
 *    4방 탐색을 하며 상, 하, 좌, 우 꽆잎 위치에 대한 비용을 더해줌.
 * 3. 3개의 씨앗이 모두 꽃을 피었다면, 꽃을 심기 위해 필요한 최소비용으로 갱신
 * 4. 씨앗이 꽃잎을 핀 것을 다시 초기화 해주고 위 2~3번 과정을 반복해 줌.
 */
public class Main_S2_14620_꽃길 {
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int N;
	
	static int [][] map;
	static boolean[][] visited;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(result);
	}
	public static void dfs(int depth, int sum) {
		if(depth == 3) { // 3개의 씨앗을 모두 꽃이 피게 한 경우
			result = Math.min(result, sum);// 꽃을 심기 위해 필요한 최소비용 갱신
			return;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				// 현 위치를 방문하지 않고, 4 방향 모두 방문하지 않았을 경우( 꽃잎이 곂치면 안된다는 조건 때문 )
				if(!visited[i][j] && check(i,j)) {
					visited[i][j] = true; // 현재 위치 방문 체크
					int cost = map[i][j];
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						visited[nr][nc] = true;
						cost+= map[nr][nc];
					}
					dfs(depth+1, sum + cost);
					// 5평의 땅을 모두 초기화.
					visited[i][j] =false;
					reset(i,j);
				}
			}
		}
	}
	public static boolean check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 경계가 벗어나거나, 이미 어떤 씨앗을 통해 꽃잎이 퍼져 있어서 꽃잎이 닿은 경우는 false 반환
			if(nr < 0 || nc < 0 || nr >=N || nc >= N || visited[nr][nc])return false;
		}
		return true;
	}
	// 해당 씨앗이 퍼트린 꽃의 꽃잎을 다시 초기화 시켜주는 함수
	public static void reset(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			visited[nr][nc] = false;
		}
	}
}
