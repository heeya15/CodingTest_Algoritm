package 그래프;

import java.util.*;
import java.io.*;

public class Main_G4_10282_해킹 {
	static class Node implements Comparable<Node>{
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		// 거리가 짧은 순으로 정렬.
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	static ArrayList<Node> [] graph;
	static int [] dist;
	static int count, time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()) + 1; // 컴퓨터 개수(노드)
			int d = Integer.parseInt(st.nextToken());     // 의존성 개수(간선)
			int c = Integer.parseInt(st.nextToken());     // 해킹당한 컴퓨터의 번호
			
			graph = new ArrayList[n];
			dist = new int[n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for (int j = 0; j < n; j++) graph[j] = new ArrayList<Node>();
			
			// d개의 줄에는 각 의존성을 나태내는 정수 a,b,s가 주어진다.
			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a가
				int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b를 의존
				int s = Integer.parseInt(st.nextToken()); // b가 감염되면 s초 후 a도 감염된다.
				//컴퓨터 b가 감염되면 "s초후" [ a도 감염됨 ]을 뜻하게 그래프 초기 생성
				graph[b].add(new Node(a,s));
			}
			
			dijkstra(c); // 최단 경로 구하기 위해 -> 다익스트라 알고리즘 수행
			count = 0;   // [ 감염되는 컴퓨터 수 ]를 저장하는 변수
			time = 0;    // [ 마지막 컴퓨터가 감염되기 까지 걸리는 시간 ]을 저장하는 변수
			for (int j = 1; j < n; j++) {
				if(dist[j] != Integer.MAX_VALUE) { // 최단 거리 테이블이 갱신되어 있다면
					count++;                       // 개수를 증가 시켜주고 
					/**
					 *  마지막 컴퓨터 까지 감염되는 시간 즉 [ 가장 오래 걸린 시간을 저장. ]
					 *  ex) 1  2  3  -> 최단 거리 테이블 노드 번호
					 *      0  2  6  -> 해당 노드에 도달하는 시간
					 * 즉, 위 예시를 보면 1번 노드가 감염될 때 동시에 1번과 관련된 2번 3번 노드도 해당 시간 후에 감염이 된다는 의미
					 * 따라서 2초 뒤에 2번 노드가 감염되고,  3번 노드는 2초 + 4초 뒤 총 6초 뒤에 감염이 된다.
					 * 따라서 마지막 컴퓨터 까지 감염되기 까지 걸린 시간이 6초로 
					 * -> 여기서 "최단 거리 테이블이 갱신된 것 중" 가장 오래된 시간으로 time을 갱신해 주면 
					 *    총 마지막 컴퓨터 까지 감염된 시간을 구할 수 있음.
					**/
					time = Math.max(time, dist[j]);
				}
			}
			sb.append(count).append(" ").append(time).append("\n");
		}
		System.out.println(sb.toString());	
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start] = 0; // 자기로 가는 시간은 0
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.index;         // 현재 거쳐갈 노드
			int distanse = node.distance; // 현재 노드까지의 최소 거리
			// 최단거리 테이블에 해당 거쳐갈 노드의 거리 값이 [ 이미 처리된 적이 있는 노드 ]라면 무시.     
			if(dist[now] < distanse) continue;
			for (int i = 0; i < graph[now].size(); i++) {
				Node next = graph[now].get(i);
				// 다음 노드까지 가는 최단 비용 거리가 > 현재 노드를 거쳐 다른 노드로 가는 비용이 더 작다면
				if(dist[next.index] > dist[now] + next.distance) {
					dist[next.index] = dist[now] + next.distance;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
	}
}