package BOJ;
import java.io.*;
import java.util.*;
/**
 n×n 바둑판 모양으로 총 n^2개의 방이 있다. 
 일부분은 검은 방이고 나머지는 모두 흰 방이다. 
 [검은 방은 사면이 벽으로 싸여 있어] 들어갈 수 없다. 
 "서로 붙어 있는 두 개의 흰 방 사이"에는 문이 있어서 지나다닐 수 있다.
 [ 윗줄 맨 왼쪽 방 ]은 '시작방'으로서 항상 흰 방이고, [아랫줄 맨 오른쪽 방]은 '끝방'으로서 역시 '흰 방'이다.
 
  '0은' 검은 방 
  '1은' 흰 방
   흰방 으로만 지나갈 수 있다.
 < '검은 방'에서 ' >흰 방'으로 바꾸어야 할 [ 최소의 수를 구하는 프로그램 ]을 작성하시오.
 
 [ 풀이 방법 ]
 - BFS + 다익스트라 활용
 - < '검은 방'에서 ' >흰 방'으로 바꾸어야 할 [ 최소의 수를 구하는 프로그램 ]을 작성해야 해서
   검은 방을 흰 방으로 바꾸는 최소 횟수를 distance 배열에 누적하여 탐색하기 위해 다익스트라 방법을 사용.
  distance 배열에 현재 위치의 가장 [ 최소 변경 횟수를 저장 ]할 수 있도록 사용 함.
 - 현재 좌표보다 더 작은 횟수로 변경하여 이동할 수 있는 방법이 있을 경우 그 방향으로 이동 시켜줌.
      단, [흰 방]은 횟수+1 를 더 해주지 않고 더 작은 횟수만 distance 현재 좌표 배열에 저장 시키고
       [검은방] 일 경우 [흰 방]으로 바꾸어 줘야 해서 [현재 까지 오면서 변경 횟수에 + 1을 ] 더한 횟수를 "distance 현재 좌표 배열에 누적" 시켜주었다. 
 
 */
public class Main_G4_2665_미로만들기 {
	public static class Pos{
		int r,c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}	
	}
	static int N;
	static char [][] map;
	static int [][] distance; // 해당 도착지점까지 오는대 '흰 방으로 바꾸어야 할 최소의 수를 담아두는' 용도인 배열
	// 상, 하, 좌, 우
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			char temp[] = br.readLine().toCharArray(); 
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
				distance[i][j] = Integer.MAX_VALUE; //Integer의 가장 큰 값으로 초기화를 해 둠.
			}
		}
		// 위 2 이차원 배열을 사용하여 BFS 탐색을 하기.
		System.out.println(bfs(0,0));
	}
	public static int bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(x,y));
		distance[x][y] = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0 ; i< 4 ; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
		// 경계값이 넘을 경우 무시.
				if(nr< 0 || nc <0 || nr>=N || nc >=N)continue;
		// 현재 좌표의 바꾸어야할 횟 수 보다 [ 4방 탐색으로 이동한 좌표에 '흰 방으로'바꾸어야할 횟 수 ]가 더 크다면
		// 현재 좌표의 바꾸어야할 횟 수를(도착지로 가면서 '흰 방으로' 바꾸어야 할 횟수가 더 작은 횟수로 ) --> 4방 탐색으로 이동한 좌표에 넣어준다.
				if(distance[nr][nc] >distance[p.r][p.c]) {
					if(map[nr][nc] == '1') { // 흰 방이라면(이동 가능한 경로라면)
						distance[nr][nc] = distance[p.r][p.c]; // 더 작은 횟수를 4방 탐색 이동 좌표에 넣어준다.
						q.add(new Pos(nr,nc));
					}else { // 검은 방일경우(이동 불가능한 경로라면)
		// (현재까지 이동하면서'흰 방'으로 체인지한 횟수 + 1) -> 현재 4방 탐색으로 이동한 좌표의 distance 배열에 저장 시켜준다.
						distance[nr][nc] = distance[p.r][p.c] + 1;
						q.add(new Pos(nr,nc));
					}
				}
			}
		}
		return distance[N-1][N-1];
	}
}
