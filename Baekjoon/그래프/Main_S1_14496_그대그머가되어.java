package 그래프;
import java.util.*;
import java.io.*;
/**
 *  야민정음이란, 비슷한 모양의 글자를 원래 문자 대신에 사용하는 것을 일컫는다.
 *  예를 들어, ‘그대’는 ‘그머’로, ‘팔도비빔면’은 ‘괄도네넴댼’으로, 
 *  ‘식용유’는 ‘식용윾’으로, ‘대호’는 ‘머호’로 바꿀 수 있다. 
 *  아무 문자나 치환할 수 있는 건 아니며 치환이 가능한 몇 개의 문자들이 정해져있다.
 *  예를 들어보자. (a, b), (a, c), (b, d), (c, d)가 주어지는 경우, 
 *  a를 d로 바꾸는 방법은 a-b-d, a-c-d로 2개가 있다. 
 *  (a, b), (b, c), (a, c)가 주어지는 경우, 
 *  a를 c로 바꾸는 방법은 a-b-c, a-c의 2개가 있다. 하지만 이 경우에는 [ 치환횟수에 차이가 생기 ]게 된다.
 *  
 *  [ 문제 ]
 *  머호는 문자 a를 문자 b로 바꾸려하고, 
 *  [ N개의 문자와 ] [ 치환 가능한 문자쌍 M개 ]가 있다. 머호에게 a를 b로 바꾸기 위한 치환의 [ 최소 횟수를 구해서 ] 머호에게 알려주자!
 *  
 *  [ 문제 풀이 ]
 *  - 예제 입력 2를 보면 양방향 그래프 임을 알 수 있었음.
 *  - 2에서 3으로 가야하는데 3 에서 2로 가는 방향인대 [ 단방향이면 갈 수 가 없는대 ] 결과에선 1이 나와서 알 수 있었음.
 */
public class Main_S1_14496_그대그머가되어 {
	static class Node implements Comparable<Node> {
		int node_index, distance;
		public Node(int node_index, int distance) {
			this.node_index = node_index;
			this.distance = distance;
		}
		public int compareTo(Node o){
			return this.distance - o.distance;
		}
		@Override
		public String toString() {
			return "Node [node_index=" + node_index + ", distance=" + distance + "]";
		}
	}
	static int INF = (int)1e9;// 무한을 의미하는 값으로 10억을 설정
	static ArrayList<ArrayList<Node>> list;
	static int dist[];
	static int a, b; 
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 1. 첫째 줄에 머호가 바꾸려 하는 문자 a와 b가 주어짐.
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		// 2. 둘째 줄에 [ 전체 문자의 수 N과 ] [ 치환 가능한 문자쌍의 수 M ]이 주어진다	
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		list = new ArrayList<>();
		for(int i=0; i<= N ; i++) {
			list.add(new ArrayList<Node>());
		}
		// "최단 거리 테이블"을 모두 무한으로 초기화
		dist = new int [1001];
		Arrays.fill(dist, INF);
		
		// 3. 이후"M개의 줄에 걸쳐" 치환 가능한 문자쌍이 주어진다. 모든 문자는 [ N이하의 자연수 ]로 표현된다.
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a1 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			// 양방향 으로 그래프에 간선 처리를 해줌.
			list.get(a1).add(new Node(b1,1));
			list.get(b1).add(new Node(a1,1));
		}
		// 다익스트라 알고리즘을 수행 
		dijkstra(list, dist, a);
		int result = dist[b]; // b로 가는 치환 횟수를 저장 
		if(result == INF) System.out.print("-1"); // 치환이 불가능 한 경우는 -1 출력.
		else System.out.print(result);
	}
	static void dijkstra(ArrayList<ArrayList<Node>> list,int distance[], int start ) {
		boolean [] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0)); // 자기 자신으로 가는 거리 0으로 초기화
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int node_index = n.node_index;
			if(visited[node_index])continue;
			visited[node_index] = true;
			// 현재 노드와 "연결된" 다른 노드 탐색  반복
			for(Node node: list.get(node_index)) {
				if(distance[node.node_index] > distance[node_index]+ node.distance) {
					// 최단거리 테이블에 [ 다른 노드로 이동하는 거리 "최소 비용" ]을 넣어줌.
					distance[node.node_index] = distance[node_index]+ node.distance;
					// 우선 순위 큐에 다른 노드로 이동하는 최소 거리 비용으로 갱신시킴. 
					pq.offer(new Node(node.node_index, distance[node.node_index]));
				}	
			}
		}
	}
}
