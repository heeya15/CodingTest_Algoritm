package BaekJoon_self;
import java.io.*;
import java.util.*;
/*
 * 날 이 N명의 학생이 [ X 번 마을에 모여서 ] 파티를 벌이기로 했다.
 * 
 * [ 출력 ]
 * N명의 학생들 중 "오고 가는데" 가장 오래 걸리는 학생의 소요시간 출력.
 * 즉,
 * 1. 파티에 참석하러 가는 경우의 최단 거리
 * 2. 파티에서 다시 집으로 오는 경우의 최단 거리
 * [ X마을에서 모든 정점 사이의 최단 거리 ]
 * 마을 : 1   2   3   4
 * -------------------
 * 파티에서 집으로 돌아오는 거리 : 1   0   3   7
 * 파티에서 참석 거리 :         4   0   6   3
 */
public class Main_G3_1238_파티 {
	public static class Node implements Comparable<Node> {
		int index_node, distance;

		public Node(int index_node, int distance) {
			this.index_node = index_node;
			this.distance = distance;
		}

		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}

	// 최단 거리 테이블 만들기
	static int[] Dist, reverseDist;
	// 각 노드에 연결되어 있는 [ 노드에 대한 정보를 담는 배열 ]
	static ArrayList<ArrayList<Node>> list, reverseList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N 명의 학생
		int M = Integer.parseInt(st.nextToken()); // M개의 단방향 도로.
		int X = Integer.parseInt(st.nextToken()); // 모일 마을 번호
		
		list = new ArrayList<>();
		reverseList = new ArrayList<>();
		// 그래프 초기화 
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
			reverseList.add(new ArrayList<Node>());
		}
		// "최단 거리 테이블"을 모두 무한으로 초기화
		Dist = new int[N + 1];
		reverseDist = new int[N + 1];
		Arrays.fill(Dist, Integer.MAX_VALUE);
		Arrays.fill(reverseDist, Integer.MAX_VALUE);
		
		// 두 번째 줄 부터 도로 시작점, 끝점, [ 이 도로를 지나는데 필요한 시간. ] 입력. 
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 시작
			int b = Integer.parseInt(st.nextToken()); // 끝점
			int c = Integer.parseInt(st.nextToken()); // 필요한 시간
			// 파티 장으로 [ 가는 것 ] 그래프 표시.
			//아래 부분이 a번 노드에서 b번 노드로 가는 거리 비용이 c라는 의미
			list.get(a).add(new Node(b, c));
			
			// 파티장에서 [ 돌아오는 것 ] 그래프 표시.
			//아래 부분이 b번 노드에서 a번 노드로 가는 거리 비용이 c라는 의미
			reverseList.get(b).add(new Node(a, c));
		}

		// 다익스트라 알고리즘을 수행 
		// 그래프, 파티장으로 가는 최단거리 테이블, 시작 정점을 인수로 넣어줌.
		dijkstra(list, Dist, X);
		        
		// 그래프, 파티장에서 집으로 돌아가는 최단거리 테이블, 시작 정점을 인수로 넣어줌.
		dijkstra(reverseList, reverseDist, X);
		
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i <Dist.length; i++ ) {
			answer = Math.max(answer,Dist[i]+reverseDist[i] );
		}
		// 파티장에 갔다가 오는 "가장 오래 걸리는" 학생의 소요시간 출력
		System.out.println(answer);
	}

	public static void dijkstra(ArrayList<ArrayList<Node>> list, int[] dist, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//	시작 [ 정점(X)의 비용을 0으로 설정 ], 큐에 삽입
		pq.add(new Node(start, 0));
		dist[start] = 0; // 시작 [ 정점의 거리를 0으로 설정 ] -- 자기 자신에게 가는 것이기 때문.
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int index = n.index_node;
			 // 현재 노드와 "연결된" 다른 노드 탐색  반복
			for(Node node : list.get(index)) {
				/** 
				 for문을 돌면서 [ 최단 거리 테이블에 현재 정점까지 거리 비용 ]이, 
            	 [ pq 에서 꺼낸 현재 노드 정점의 거리 + for문의 현재 정점 노드까지 그래프상 연결된 거리 ] 보다 크다면
            	  즉, 다른 경로로 거쳐서 가는 거리 비용이 더 작다면 
            	**/
				if(dist[node.index_node] > dist[index] + node.distance) {
					// 최단거리 테이블에 [ 다른 노드로 이동하는 거리 "최소 비용" ]을 넣어줌.
					dist[node.index_node] = dist[index] + node.distance;
					// 우선 순위 큐에 다른 노드로 이동하는 최소 거리 비용으로 갱신시킴. 
					pq.add(new Node(node.index_node, node.distance));
				}
			}
		}
	}
}
