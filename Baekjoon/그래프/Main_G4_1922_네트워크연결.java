package 그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//크루스칼방법
public class Main_G4_1922_네트워크연결 {
	static class Node implements Comparable<Node> {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		//오름차순 정렬.
		@Override
		public int compareTo(Node o) {	
			return this.d - o.d;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
	}
	static int N,M;
	static int [] parent;
	// 부모 테이블상에서, 부모를 자기 자신으로 초기화
	static void make() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	// 특정 원소가 속한 집합을 찾기
	static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	// 두 원소가 속한 집합을 합치기
	static void union(int a, int b) {
		// 자신의 부모를 찾고.
		a = find(a);
		b = find(b);
		if(a>b) parent[a] = b;
		else parent[b] = a;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //컴퓨터의 수( 정점의 수 )
		M = Integer.parseInt(br.readLine()); //연결할 수 있는 수 ( 간선의 수)
		parent = new int[N + 1];
		// 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
		ArrayList<Node> edge = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edge.add(new Node(a,b,d));
		}
		// 부모 테이블상에서, 부모를 자기 자신으로 초기화
		make();
		// 1. [ 간선을 비용순 ]으로 정렬
		Collections.sort(edge);
		int result = 0; // 최소 비용을 저장받을 변수
		
		// 2. 간선을 하나씩 확인
		for (int i = 0; i < edge.size(); i++) {
			int a = edge.get(i).x;
			int b = edge.get(i).y;
			int d = edge.get(i).d;
			// 사이클이 [ 발생하지 않는 경우에만 ] 집합에 포함
			if(find(a)!= find(b)) {
				union(a,b);
				result += d; // 최소 비용 누적.
			}
		}
		System.out.println(result);
		//System.out.println(edge.toString());
	}
}
