package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int nodeA;
	int nodeB;
	int dist;

	public Edge(int nodeA, int nodeB, int dist) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.dist = dist;
	}

	public int getNodeA() {
		return this.nodeA;
	}

	public int getNodeB() {
		return this.nodeB;
	}

	public int getDist() {
		return this.dist;
	}
	// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge o) {
		return this.dist -o.dist;
	}
}
//크루스칼방법
public class Main_G4_1197_최소스패닝트리 {
	// 노드의 개수(V)와 간선(Union 연산)의 개수(E)
	static int V,E;
	static int [] parents;
	// 부모 테이블상에서, 부모를 자기 자신으로 초기화
	private static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	// 특정 원소가 속한 집합을 찾기
	private static int find(int x) {
		// 자신이 루트이면 그냥 자기 자신의 번호 리턴. 
		if(x== parents[x]) return x;
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		return parents[x] = find(parents[x]);
	}
	// 두 원소가 속한 집합을 합치기
	private static void union(int a, int b) {
		// 자신의 부모를 찾고.
		a = find(a);
		b = find(b);
		// b의 숫자가 더 큰 경우 b의 부모를 a로
		if(a<b) parents[b]=a;
		// a의 숫자가 더 큰 경우 a의 부모를 b로 설정.
		else parents[a] = b;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		// 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
		ArrayList<Edge> edge = new ArrayList<>();
		int result = 0; // 최소 스패닝 트리의 가중치 저장받을 변수.
		// 모든 간선에 대한 정보 받기.
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edge.add(new Edge(a,b,d));
		}
		make(); // 자기 자신을 부모로 초기화.
		// 1. [ 간선을 비용(거리)순 ]으로 정렬
		Collections.sort(edge);
		// 2. 간선을 하나씩 확인하며
		for (int i = 0; i < edge.size(); i++) {
			int nodea = edge.get(i).getNodeA();
			int nodeb = edge.get(i).getNodeB();
			int dist = edge.get(i).getDist();
			// 사이클이 [ 발생하지 않는 경우에만 ] 집합에 포함
			if(find(nodea) != find(nodeb)) {
				union(nodea, nodeb);
				result += dist;
			}		
		}
		System.out.println(result);	
	}
}
