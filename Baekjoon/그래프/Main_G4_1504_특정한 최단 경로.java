package 그래프;

import java.util.*;
import java.io.*;

/**
 * ( 문제 설명 )
 * - 방향성이 없는( 무방향 == 양방향) 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
 * - 세준이는 "두 가지 조건을 만족"하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 
 *   그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
 * - 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
 * - 반드시 최단 경로로 이동해야 한다는 사실에 주의
 * - 1번 정점에서 N번 정점으로 이동할 때, 주어진 [ 두 정점을 반드시 거치면서 ] 최단 경로로 이동하는 프로그램을 작성하시오.
 *
 * ( 문제풀이 )
 * 1. graph에  양방향 그래프 정보를 입력 받아 셋팅해 준다.
 * 2. 반드시 거쳐야하는 2개의 정점을 입력 받은 후, [ 2가지 방법 ]으로 크게 나눠 최단 경로를 구해준다.
 *    (1). 1 -> v1 -> v2 -> N-1
 *    (2). 1 -> v2 -> v1 -> N-1
 * 3. 2가지 방법으로 구한 answer1, answer2가 INF(간선의 총 개수 * 거리)보다 크거나 같다면 2가지 정점을 거쳐 N-1에 도달할 수 없다는 것으로 "-1" 출력
 *    2가지 방법으로 구한 answer1, answer2가 INF 보다 작다면 < 2가지 정점을 거쳐 N-1에 도달할 수 있다 >는 것, 
 *    따라서 2가지 방법으로 구한 answer1, answer2 중에서 < 더 작은 최단 경로 거리를 출력 >해 준다.
 *    
 * ( 주의할 점 )
 * INF를 Integer.MAX.VALUE로 int의 최댓값을 설정하면 오버플로우가 발생한다.
 * 따라서 INF를 간선의 최대 개수(200000) * 최대 거리 (1000) = 200,000,000으로 해준다.
 */
public class Main_G4_1504_특정한최단경로 {
	static class Node implements Comparable<Node>{
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		// 거리는 오름차순으로 정렬
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	static int N, E;
	static ArrayList<Node> [] graph;
	static int [] distance;
	static int INF = 200000000; // 200,000(E) * 1,000(c)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()) + 1; // 정점의 개수
		E = Integer.parseInt(st.nextToken());     // 간선의 개수 ( 0 ≤ E ≤ 200,000 )
		graph = new ArrayList[N];
		distance = new int[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<Node>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 거리 (1 ≤ c ≤ 1,000)
			graph[a].add(new Node(b,c));
			// 무방향(양방향) 그래프이므로 반대 방향도 추가 해줌.
			graph[b].add(new Node(a,c));
		}
		
		// 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1, v2가 주어짐.
		st = new StringTokenizer(br.readLine()," ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 2개의 경우로 나눔 v1 -> v2로 거쳐 갈지 or v2 -> v1으로 거쳐 갈지
		int answer1 = 0; // 1 > v1 > v2 > N
		answer1 += dijkstra(1, v1);
		answer1 += dijkstra(v1, v2);
		answer1 += dijkstra(v2, N-1);
		
		int answer2 = 0; // 1 > v2 > v1 > N
		answer2 += dijkstra(1, v2);
		answer2 += dijkstra(v2, v1);
		answer2 += dijkstra(v1, N-1);
	    /** 1번과 2번 경우에서 얻어낸 값이 INF보다 크거나 같다면 
		   < v1과 v2를 거쳐서 N에 도달할 수 없다는 의미 >이므로 "-1을" 그렇지 않다면 1번과 2번 경우에서 < 더 작은 최단 거리를 출력 >
		**/
		int result = (answer1 >= INF && answer2 >= INF) ? -1 : Math.min(answer1, answer2);
		System.out.println(result);	
	}
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(distance, INF); // 최단 거리 테이블 배열 INF로 초기화
		pq.add(new Node(start, 0));
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
					pq.add(new Node(next.index, distance[next.index] ));
				}
			}
		}
		return distance[end]; // 목적지 end 까지의 최단 거리
	}
}