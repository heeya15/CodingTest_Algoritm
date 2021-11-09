package DP;

import java.util.*;
import java.io.*;

/* 알고리즘 분류 : 플로이드 워셜
 * 당신은 도로를 따라 운동을 하기 위한 경로를 찾으려고 한다. 운동을 한 후에는 다시 시작점으로 돌아오는 것이 좋기 때문
 * 사이클을 이루는 [ 도로의 길이의 합이 최소가 되도록 ] 찾으려고 함
 * [ 도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성 ]
 * ex)
 * 0 [[0, 0, 0, 0], 
 * 1 [0, 0, 1, 3], 
 * 2 [0, 536870911, 0, 2],
 * 3 [0, 536870911, 1, 0]]
 * 
 * 2 -> 3으로 가고, 3 -> 2로 갈 수 있으므로 사이클 발생. 따라서 2 + 1 = 3 이 최소 사이클의 도로 길이의 합이 됨.
 */
public class Main_G4_1956_운동 {
	static int V, E;
	static final int INF = Integer.MAX_VALUE>>2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[V + 1][V + 1];
			
		//  자기 자신으로 가는 비용 제외 모든 노드에서 가는 비용을 (무한으로) 초기화 해 놓음
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i != j)graph[i][j] = INF;
			}
		}
		
		for(int i = 0; i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			// a번 마을에서 b번 마을로 가는 [ 거리 c가 있다는의미. ]
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		// 경 출 도
		for(int k = 1; k<=V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if(i == j) continue; // 자기 자신을 가는 경우 무시.
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+ graph[k][j]);
				}
			}
		}
		int result = INF;
		// a -> b, b-> a 양방향 으로 갈 수 있는 경우 사이클 발생으로 생각.
		// [ 사이클을 이루는 ] "도로의 길이의 합이 최소가 되도록" 찾으려고 함
		for(int i = 1; i <= V; i++) {
			for(int j =1; j <= V; j++) {
				if( i== j) continue;
				if(graph[i][j] != INF && graph[j][i] != INF) {
					result = Math.min(result, graph[i][j]+ graph[j][i]);
				}
			}
		}
		result = result == INF ? -1 : result;
		System.out.println(result);
	}
}
