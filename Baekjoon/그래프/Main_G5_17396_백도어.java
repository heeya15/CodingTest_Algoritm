package 그래프;

import java.util.*;
/**
 * ( 문제 정리 )
 * - 0에서 N-1번째 분기점 까지 가는 "최단거리"를 구해야 함
 * - 이때 시야 정보도 주어지는데 "0이면" 해당 분기점일 때 상대 시야에서 "보이지 않는다", "1이면" [ 상대 시야에서 보인다 ]는 의미
 * - 단, N-1번째 분기점은 상대 넥서스이기 때문에 어쩔 수 없이 [ 상대의 시야에 보이게 되며 ] 유일하게 상대 시야에 보이면서 갈 수 있는 곳
 * - 즉, 시야에서 보이지 않으면서 < N-1번째 분기점 까지 갈 수 있는 최단 거리 >를 구하면 됨
 * - 연결은 양방향, 한 분기점에서 다른 분기점으로 가는 간선은 최대 1개 존재.
 * 
 * ( 문제 풀이 )
 * 1. 각 분기점 과 사이의 정보(간선)을 입력 받는다. 단 문제에서 연결은 양방향이라 하였음으로 양방향으로 연결하게 셋팅
 * 2. 다익스트라 알고리즘을 활용하여 N-1 번째 까지 이동하는 최단 거리를, 최단 거리 비용 테이블 distanse에 갱신.
 * 3. 최종 넥서스 까지 갈 수 있으면 distance[N-1] 번째 비용 출력, 갈 수 없으면 "-1" 출력
 */
import java.io.*;
public class Main_G5_17396_백도어 {
	static class Node implements Comparable<Node>{
		int node;
		long cost;
		
		public Node(int node, long cost) {
			this.node = node;
			this.cost = cost;
		}
		public int compareTo(Node n) {
			// 다른 원소로 가는 비용이 더 작게 든다면  -> 비용이 작은 순으로 오름차순 정렬
			return this.cost - n.cost > 0 ? 1 : -1;
//			return Long.compare(this.cost, n.cost); //--> 다른 오름차순 정렬 방법 
		}
	
		@Override
		public String toString() {
			return "Node [node=" + node + ", cost=" + cost + "]";
		}
	}
	static ArrayList<Node> [] graph;
	static long [] distance;
	static boolean [] sight;
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 분기점의 수 ( 노드 )
		M = Integer.parseInt(st.nextToken()); // 분기점들을 잇는 길의 수 ( 간선 )
		graph = new ArrayList[N];
		distance = new long[N];
		sight = new boolean[N];
		Arrays.fill(distance, Long.MAX_VALUE); // 최단 거리 저장 테이블 초기화
		
		st = new StringTokenizer(br.readLine()," ");
	
		for (int i = 0; i < N; i++) {
			int isSight = Integer.parseInt(st.nextToken());
			if(isSight == 1) sight[i] = true;
			graph[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			// 연결은 양방향 이기 때문에 양쪽으로 간선 연결 셋팅
			graph[a].add(new Node(b,t));
			graph[b].add(new Node(a,t));
		}
		System.out.println(dijkstra());
	}

	public static long dijkstra() {
		distance[0] = 0; // 자기 자신에게 가는 거리는 0으로 초기화
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int now = cur.node;   // 현재 거쳐갈 노드
            long dist = cur.cost; // 현재 노드까지의 최소 비용
            // 최단거리 테이블에 해당 거쳐갈 노드의 거리 값이 [ 이미 처리된 적이 있는 노드 ]라면 무시.     
			if(distance[now] < dist) continue;
			for (int i = 0; i < graph[now].size(); i++) {
				Node next = graph[now].get(i); // 다음 노드
				// 가려는 곳이 N-1번째 분기점이 아닌대 시야가 밝혀져 있다면 무시 
				// N-1번째는 상대 넥서스여서 어쩔 수 없이 < 상대 시야에서 보이면서 갈 수 있는 곳이여서 "제외".>
				if(next.node != N-1 && sight[next.node]) continue;
				// 다음 노드까지 가는 최단 비용 거리가 > 현재 노드를 거쳐 다른 노드로 가는 비용이 더 작다면
			    if(distance[next.node] > distance[now]+ next.cost) {
					distance[next.node] = distance[now]+ next.cost;
					pq.offer(new Node(next.node, distance[next.node]));
				}
			}
		}
		// 넥서스 까지 안 들키고 갈 수 있다면 ( 넥서스 까지 안 들키고 가는데 걸리는 최소 시간 return) 
		if(distance[N-1] != Long.MAX_VALUE) return distance[N-1];
		// 넥서스 까지 갈 수 없으면 "-1" 리턴
		return -1;
	}
}