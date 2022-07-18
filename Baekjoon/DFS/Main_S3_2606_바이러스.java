package DFS;
import java.io.*;
import java.util.*;
public class Main_S3_2606_바이러스 {
	static boolean[] visit;
    static int arr [][];
    static int count = 0;
    static int node,line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        line = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수 ( 간선 수 )
        visit = new boolean[node+1];
        //인접 행렬
        arr = new int[node+1][node+1];
       
        for (int i = 1; i <= line; i++) { // 인접 행렬 그래프 구성
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int start) {
    	visit[start] = true; // 처음 1번 컴퓨터 바이러스 처리.
        for (int i = 1; i <= node; i++) {  
            if ((arr[start][i] == 1 && arr[i][start] == 1) && !visit[i]) {  // 연결되어 있는 것들 중에 방문하지 않은 것 선별
            	count++; // 감염된 수 ++
            	dfs(i);
            }
        }
    }
}
