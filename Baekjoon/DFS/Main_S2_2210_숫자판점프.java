package DFS;

import java.util.*;
import java.io.*;
public class Main_S2_2210_숫자판점프 {
	/**
	 * 이 숫자판의 "임의의 위치에서 시작"해서, < 인접해 있는 네 방향으로 다섯 번 이동 >하면서, 
	 * 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 
	 * 이동을 할 때에는 < 한 번 거쳤던 칸을 다시 거쳐도 되며 >, 0으로 시작하는 000123과 같은 수로 만들 수 있다.
	 * 숫자판이 주어졌을 때, < 만들 수 있는 "서로 다른 여섯 자리의 수들의 개수" >를 구하는 프로그램을 작성하시오.
	 */
	static final int size = 5;
	static String[][] map ;
	// 상, 하, 좌, 우
	static int [] dr = { -1, 1, 0, 0 };
	static int [] dc = { 0, 0, -1, 1 };
	static ArrayList<String> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[size][size];// 5 * 5 크기의 숫자판
		list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; j++) {
				map[i][j] = st.nextToken();
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				dfs(i, j, 1, map[i][j]);
			}
		}
		System.out.println(list.size());
	}
	
	public static void dfs(int x, int y, int count, String temp) {
		if(count == 6) { // 6자리수가 완성 되었으면
			if(!list.contains(temp)) list.add(temp); // 중복되지 않는 숫자라면 list에 추가.
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if(nr < 0 || nc < 0 || nr >=size || nc >=size)continue;
			String number = temp + map[nr][nc];
			dfs(nr, nc, count+1, number);
		}
	}
}