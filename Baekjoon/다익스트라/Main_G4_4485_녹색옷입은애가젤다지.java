package BaekJoon_self;
import java.util.*;
import java.io.*;
public class Main_G4_4485_녹색옷입은애가젤다지 {
	public static class Node implements Comparable<Node>{
		int r,c,distance;
		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
		
		public int compareTo(Node n) {
			return this.distance -n.distance;
		}
	}
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int N;
	static int [][] map, distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = 1; // 테케 수 세어줌
		while (true) {
//		 1. 정점의 개수만큼 데이터 입력 및 초기화
			N = Integer.parseInt(br.readLine()); // 정점 개수
			if (N == 0)break;
			map = new int[N][N]; // 정점에 대한 정보를 인접 행렬로 선언
			distance = new int[N][N]; // 거리의 "최소 비용을 저장"할 배열.
			for (int i = 0; i < N; i++) {
//				 정점 최소 비용을 갱신하기 위해 [ 초기 값을 MAX로 설정. ]  --> 행렬 값을 무한으로 초기화.
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
//		정점에 대한 인접 정보 입력 받기.
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(test_case++).append(": ").append(dijkstra()).append("\n");
		}
		System.out.println(sb);
	}
	public static int dijkstra() {
		distance[0][0] = map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 시작 [ 시작좌표와 가중치], 큐에 삽입
		pq.offer(new Node(0, 0, map[0][0]));
		while (!pq.isEmpty()) { // 큐가 비어있지 않다면
			// 가장 [ 최단 거리가 짧은 노드에 대한 정보 꺼내기 ]
			Node node = pq.poll();
			int row = node.r;
			int col = node.c;
			for (int i = 0; i < 4; i++) {
				int nx = row + dr[i];
				int ny = col + dc[i];
				// 경계값 범위 검사.
				if (nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
				if (distance[nx][ny] > distance[row][col] + map[nx][ny]) {
					distance[nx][ny] = distance[row][col] + map[nx][ny];
					pq.offer(new Node(nx, ny, distance[nx][ny]));
				}
				// 젤 오른쪽 아래칸인 곳에 이동 시 while문 탈출.
				if (nx == N-1 && ny == N-1) break;
			}
		}
		return distance[N-1][N-1];
	}
}
