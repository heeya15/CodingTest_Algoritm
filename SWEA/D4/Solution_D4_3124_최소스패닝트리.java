package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

	private int distance; // 가중치 비용 저장.
	private int nodeA;
	private int nodeB;

	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return this.distance;
	}

	public int getNodeA() {
		return this.nodeA;
	}

	public int getNodeB() {
		return this.nodeB;
	}

	// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge other) {
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class Solution_D4_3124_김광희 {
	// 노드의 개수(V)와 간선(Union 연산)의 개수(E)
	public static int[] parents; // 부모 테이블 초기화하기
	public static long result ;
	static int V,E;
	// 부모 테이블상에서, 부모를 자기 자신으로 초기화
	public static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	// 특정 원소가 속한 집합을 찾기
	public static int findparents(int x) {
		if (x == parents[x]) // 자신이 루트이면 그냥 자기 자신의 번호 리턴. 
			return x;
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		return parents[x] = findparents(parents[x]);
	}

	// 두 원소가 속한 집합을 합치기
	public static void unionparents(int a, int b) {
		// 자신의 부모를 찾고.
		a = findparents(a);
		b = findparents(b);
		// b의 숫자가 더 큰 경우 b의 부모를 a로
		if (a < b)parents[b] = a;
		// a의 숫자가 더 큰 경우 a의 부모를 b로 설정.
		else parents[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			result =0;
			// 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
			ArrayList<Edge> edges = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V+1]; // 1번노드를 1번 인덱스로 지정하기 위해 +1 해줌.
			// 부모 테이블상에서, 부모를 자기 자신으로 초기화
			make();
			
			// 모든 간선에 대한 정보를 입력 받기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges.add(new Edge(cost, a, b));
			}
			// 1. [ 간선을 비용순 ]으로 정렬
			Collections.sort(edges);
			// 2. 간선을 하나씩 확인하며
			for (int i = 0; i < edges.size(); i++) {
				int cost = edges.get(i).getDistance();
				int a = edges.get(i).getNodeA();
				int b = edges.get(i).getNodeB();
				// 사이클이 [ 발생하지 않는 경우에만 ] 집합에 포함
				if (findparents(a) != findparents(b)) {
					unionparents(a, b);
					result += cost;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
