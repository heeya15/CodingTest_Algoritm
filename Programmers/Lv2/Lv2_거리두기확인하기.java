package BFS;
import java.util.*;

/**
	P : 응시자가 앉아있는 자리
	O : 빈 테이블
	X : 파티션을 의미
	대기실 별로 거리두기를 지키고 있으면 1, 한명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록.
	bfs 함수 에서 생각대로 if 조건 처리를 생각나는 대로 하여 
	추가 테케 점수 82점으로 1,3,5,8,11,16 테케가 통과 되지 않아 해결하는데 쫌 오래 걸렸다...
**/
public class Lv2_거리두기확인하기 {
	public static class Pos {
		int r, c, dis;
		public Pos(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	static boolean[][] visited;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	public static void main(String[] args) {
		String places[][] = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
							  {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
							  {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							  {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
							  {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(solution(places)); // 출력 : [1, 0, 1, 1, 1]
	}
	// 자리에 앉아있는 응시자들 정보와
             // 대기실 구조를 대기실별로 담은 2차원 문자열 배열 매개변수로 주어짐.
	public static String solution(String[][] places) {
		int[] answer = new int[places.length];
		int index = 0;
		next: for (int t = 0; t < places.length; t++) {
			String[] map = places[t];
			visited = new boolean[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i].charAt(j) == 'P' && !visited[i][j]) {
						if (!bfs(i, j, map)) { // 거리두기 한명이라도 지키지 않았다면
							answer[index++] = 0;
							continue next;
						}
					}
				}
			}
			answer[index++] = 1;
		}
		return Arrays.toString(answer);
	}

	public static boolean bfs(int r, int c, String[] map) {
		boolean result = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c, 0));
		visited[r][c] = true;
		while (!q.isEmpty()) {
			Pos temp = q.poll();
			int dis = temp.dis;
			if (dis > 2) return result;
			for (int i = 0; i < 4; i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				// X(파티션)인 경우는 무시 -> P X P 인경우 PXOP 인경우든 거리두기 지키는 것이기 때문
				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || map[nr].charAt(nc) == 'X' || visited[nr][nc] == true)
					continue;
				// 거리가 2보다 작은대, 다음 탐색 좌표가 P가 될 경우 거리 2이하로 앉아서
				// 거리두기를 지키지 않은 것이 됨
				if (dis < 2 && map[nr].charAt(nc) == 'P')return false;

				if (map[nr].charAt(nc) == 'O') {
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc, dis + 1));
				}
				// 현재 좌표가 'O(빈 테이블)'이면서 다음 좌표가 P 이면서 거리두기 2이하를 지키지 않은 것이됨
				// --> 그림 3번의 경우 해당
				if (map[temp.r].charAt(temp.c) == 'O' && map[nr].charAt(nc) == 'P') {
					if (dis + 1 <= 2) return false; // 현재 거리에서 +1 한 거리가 2 이하일 경우 거리두기 안 한 것
				}
			}
		}
		return result;
	}
}
