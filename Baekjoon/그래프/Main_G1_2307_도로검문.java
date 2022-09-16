package 그래프;

import java.util.*;
import java.io.*;
/**
 * ( 문제 설명 )
 * 어떤 범죄용의자가 입력 데이터에 표시된 도시로 진입하여 [ 이 도시를 가장 빠른 시간 내에 빠져나가고자 ] 한다.
 * 경찰이 어떤 하나의 도로(에지)를 선택하여 이 도로에서 검문을 하려고 한다. 
 * 용의자는 이 도로(경찰이 도로 검문을 하는 곳)를 피해서 가장 빠르게 도시를 탈출하고자 한다.
 * < 경찰이 검문을 위하여 선택하는 도로에 따라 >서 용의자의 가장 빠른 탈출시간은 검문이 없을 때에 비하여 더 늘어날 수 있다.
 * 
 * - 용의자가 도시에 진입하는 지점                         : "항상 1번"
 * - 도시를 빠져나가기 위하여 최종 도달해야하는 지점 : "N번 지점"
 * - 경찰이 어떤 도로를 막으면 "용의자는 도시를 탈출 못할 수도 있다."
 * < 경찰이 [ 한 도로를 막고 ] 검문함으로써 지연시킬 수 있는 "최대시간을 정수로 출력" >
 * 만일 지연효과가 없으면 "0"을 출력해야하고, 도시를 빠져나가지 못하게 만들 수 있으면 "-1"을 출력
 * 
 * ( 문제 풀이 )
 * 1. graph에  양방향 그래프 정보를 입력 받아 셋팅해 준다.
 * 2. 오리지널 다익스트라 알고리즘을 수행하여 1번노드에서 N번까지 도달하는대 최단 거리시간을 min_dist 변수에 저장
 *    이 과정에서  최단 거리가 거쳐가는 간선정보를 parents 배열에 저장 -> 해당 "인덱스의" [값이 연결된 정점 ]을 의미
 *    1 2 3 4 5 6  -> 노드  (end)
 *    0 1 2 1 4 3  -> 노드와 이어져 있는 [부모 노드 값 ] start
 * 3. 최단 거리가 거쳐가는 간선 정보 배열을 이용하여 "간선을 하나씩 제외" 하면서 다익스트라를 경로의 수 만큼 돌린다.
 *    여기서 가장 긴거리를 max_dist에 저장한다.
 * 4. 만약 경찰이 검문함으로써 범죄용의자가 도시에서 못 빠져나오게 된다면 "-1"
 *    빠져나올 수 있다면 max_dist(가장 긴거리) - min_idst(최단 거리) 를 출력해 준다. 
 */
public class Main_G1_2307_도로검문 {
	static class Node implements Comparable<Node>{
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	static int N, M;
	static ArrayList<Node> [] graph;
	static int [] distance, parents;
	static int INF = 5000 * 10000; // 도로의 수(6 ≤ M ≤ 5000) * 통과 시간(1 ≤ t ≤ 10000)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()) + 1; // 지점의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		graph = new ArrayList[N];
		distance = new int[N];
		parents = new int[N]; // 최단 거리가 거쳐가는 간선정보를 저장 -> 해당 "인덱스의" [값이 연결된 정점 ]을 의미
		Arrays.fill(distance, INF);
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<Node>();
			
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			// 도로는 모두 양방향이라고 가정.
			graph[a].add(new Node(b,t));
			graph[b].add(new Node(a,t));
		}
		int min_dist = dijkstra(1); // 1에서 N까지 최단 경로 구함. (가장 짧은 거리를 담을 변수 )
		int max_dist = 0;           // 가장 긴 거리를 담을 변수
		//  간선 정보 배열을 이용하여 "간선을 하나씩 제외" 하면서 다익스트라를 경로의 수 만큼 돌린
		for (int i = N-1; i > 0; i--) {
			max_dist = Math.max(max_dist, delete_dijkstra(parents[i],i));
		}
		
		if(max_dist == INF) System.out.println(-1);  // 도시를 빠져 나가지 못하는 경우
		else System.out.println(max_dist - min_dist);// 도시를 빠져 나가는 경우
	}
	public static int dijkstra (int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.index;     // 현재 거쳐갈 노드
			int dist = node.distance; // 현재 노드까지의 최소 거리
			// 최단거리 테이블에 해당 거쳐갈 노드의 거리 값이 [ 이미 처리된 적이 있는 노드 ]라면 무시.   
			if(distance[now] < dist) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				Node next = graph[now].get(i);
				// 다음 노드까지 가는 최단 비용 거리가 > 현재 노드를 거쳐 다른 노드로 가는 비용이 더 작다면
				if(distance[next.index] > distance[now] + next.distance) {
					distance[next.index] = distance[now] + next.distance;
					parents[next.index] = now; // 최단 거리가 거쳐가는 간선정보를 저장
					pq.offer(new Node(next.index, distance[next.index] ));
				}
			}
		}
		return distance[N-1]; // 목적지 N까지의 최단 거리
	}
	
	public static int delete_dijkstra (int start, int end) {
		Arrays.fill(distance, INF); // 최단 거리 테이블 배열 INF로 초기화
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));   // 시작 노드 우선 순위 큐에 추가
		distance[1] = 0;            // 시작 지점은 "거리 0"으로 셋팅.
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.index;     // 현재 거쳐갈 노드
			int dist = node.distance; // 현재 노드까지의 최소 거리
			// 최단거리 테이블에 해당 거쳐갈 노드의 거리 값이 [ 이미 처리된 적이 있는 노드 ]라면 무시.   
			if(distance[now] < dist) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				Node next = graph[now].get(i);
				// 시작점이 현재 노드가 아니면서, 끝 점이 다음 노드가 아닌 경우 ( 즉, 하나의 간선은 제외 하고 )
				if(start != now || end != next.index) {
					// 다음 노드까지 가는 최단 비용 거리가 > 현재 노드를 거쳐 다른 노드로 가는 비용이 더 작다면
					if(distance[next.index] > distance[now] + next.distance) {
						distance[next.index] = distance[now] + next.distance;
						pq.offer(new Node(next.index, distance[next.index] ));
					}
				}
			}
		}
		return distance[N-1];
	}
}