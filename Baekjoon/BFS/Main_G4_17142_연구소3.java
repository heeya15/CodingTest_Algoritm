package BOJ;
import java.io.*;
import java.util.*;
public class Main_G4_17142_연구소3 {
	static class Node{
		int r,c;
		public Node(int r , int c ) {
			this.r = r ;
			this.c = c;
		}
	}
	static int N,M;
	static int [] dr = {0,0,-1,1};
	static int [] dc = {-1,1,0,0};
	static int [][] map;
	static ArrayList<Node> virus;
	static int zeroCount;
	static boolean [] ischeck;
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기
		M = Integer.parseInt(st.nextToken()); // 바이러스의 개수
		
		map = new int[N][N];
		virus = new ArrayList<>();
		// 연구소의 상태 입력
		// 0은 빈 칸, 1은 벽, 2는 바이러스의 위치
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j< N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)zeroCount++;
				if(map[i][j] == 2)virus.add(new Node(i,j));
			}
		}
		ischeck = new boolean[virus.size()];
		if(zeroCount == 0) {
			System.out.println(0);
			return;
		}
		else {
			comb(0,0);
			System.out.println(Min == Integer.MAX_VALUE ? -1 :Min);
		}
	}
	
	static void comb(int depth, int start) {
		if(depth == M) { 
			Queue<Node> q = new LinkedList<>();
			boolean [][] visited = new boolean[N][N]; 
			for(int i = 0 ; i < virus.size(); i++) {
				if(ischeck[i]) {
					Node n = virus.get(i);
					visited[n.r][n.c] = true; 
					q.add(new Node(n.r,n.c));
				}
			}
			bfs(q, visited);
			return;
		}
		for(int i = start ; i < virus.size(); i++) {
			ischeck[i] = true;
			comb(depth+1, i+1);
			ischeck[i] = false;
		}
	}
	static void bfs(Queue<Node> q, boolean [][] visited) {
		int zero = zeroCount; // 다퍼진 여부 사용
		int time = 0;
		// 활성화 바이러스가 비활성화 바이러스 칸으로 가면 비활성 바이러스가 활성으로 변한다.
		while(!q.isEmpty()) {
			int size = q.size();
			for(int k = 0; k < size ; k ++) {
				Node n = q.poll();
				for(int i = 0 ; i < 4; i ++) {
					int nr = dr[i] + n.r;
					int nc = dc[i] + n.c;
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || 
							visited[nr][nc] || map[nr][nc] == 1 )continue;
					if(map[nr][nc] == 0) {
						zero--;
					}
					visited[nr][nc] = true;
					q.add(new Node(nr,nc));
				}
			}
		
			time++;
			if(time >= Min) return;
			if(zero == 0 ) Min = Math.min(Min, time);	
		}
	}
}
