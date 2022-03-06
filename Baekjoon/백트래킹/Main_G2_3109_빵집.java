package BOJ;
import java.io.*;
import java.util.*;
/**
 * [첫째 열]은 근처 빵집의 가스관이고, 
 * [마지막 열]은 원웅이의 빵집
 * 가스관과 빵집을 연결하는 파이프를 설치
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능
 * 빵집과 가스관 사이 건물이 있을 수도 있다. "건물이 있는 경우"에는 "파이프를 놓을 수 없다."
 * 건물 : x, 빈칸 : .
 * 원웅이가 설치할 수 있는 < 가스관과 빵집을 연결 >하는 파이프라인의 [ 최대 개수 ]를 구하는 프로그램
 * 처음과 마지막 열은 항상 비어있다.
 */
public class Main_G2_3109_빵집 {
	static int R,C;
	static char [][] map;
	// 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선 
	// --> 첫 번째 테케에서 최대 개수가 2인것을 보고 오른쪽 먼저가 아닌 [ 오른쪽 위 대각선 탐색 ]을 우선시 하게 델타 배열 선언
	// 오른족을 먼저 탐색할 경우 < 파이프를 1개 밖에 못 놓음 >
	static int [] dr = {-1, 0, 1};
	static int [] dc = {1, 1, 1};
	static boolean [][] isVisited;
	static int result;
	static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];
		// 빵집 근처의 모습 입력
		for(int i = 0; i < R ; i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j = 0; j< C ; j++) {
				map[i][j] = temp[j];
			}
		}
		// dfs 탐색
		for (int i = 0; i < R; i++) {
			isVisited[i][0] = true;
			flag = false;
			dfs(i,0);
		}
		System.out.println(result); // 결과 출력.
	}
	private static void dfs(int r, int c) {
		if(c == C-1) {  // 파이프가 마지막 열에 도착한 경우 (가지 치기) -> 파이프 라인 하나 완성.
			flag = true;
			result++;
			return;    // dfs 재귀 호출 지점으로 return;
		}
		// 3방 탐색 진행
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 경계 범위 밖이면 무시.
			if(nr < 0 || nc < 0 || nr >= R || nc >=C)continue;
			// 이미 방문했거나, 건물을 만날때도 무시.
			if(isVisited[nr][nc] == true || map[nr][nc] == 'x')continue;
			
			// 방문 하지 않았고, 건물을 만나지 않았다면 이동.			
			isVisited[nr][nc] = true;
			dfs(nr,nc);
			// [ 마지막 열까지 도착할 수 있던 이전 경로의 재귀 함수 ]를  파이프 라인이 만들어져서
			// 다른 방향으로 탐색할 필요가 없어 재귀 함수 호출 종료(탈출).
			// 탐색이 성공한 길은 이미 파이프가 설치되므로 [ 체크 해제를 하지 않고 ],
		    // 탐색 실패한 길은 다른 파이프가 탐색해도 실패이므로 체크 해제를 하지 않는 것.
			if(flag) return; 
		}		
	}
}
