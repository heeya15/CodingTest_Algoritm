package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_2567_색종이2 {
	static final int K = 101;
	// 우,상,하,좌
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		1. 색종이 수 입력.
		int n = Integer.parseInt(br.readLine());
		boolean[][] isSelected = new boolean[K][K];
		for (int a = 0; a < n; a++) { // 색종이 수 만큼 반복.
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // 색종이 왼쪽 변과 [ 도화지의 왼쪽변 ] 사이의 거리
			int y = Integer.parseInt(st.nextToken()); // 색종이의 아래쪽 변과 [ 도화지의 아래쪽변 ] 사이의 거리.
//	    2. 정사각형 모양 색종이 만드는 부분.
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (isSelected[i][j] == false) { // 방문하지 않았을 경우
						isSelected[i][j] = true; // 방문 처리. - 검은색 영역으로 칠하기.
					}
				}
			}
		}
		int sum = 0; // 영역의 둘레 저장 변수.
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				if (isSelected[i][j] == true) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx > K - 1 || ny > K - 1)continue;
						if (isSelected[nx][ny] == false)sum++; // 둘레 부분 누적하여 세어줌.
					}
				}
			}
		}
//      3. 색종이 둘레 출력. 
		System.out.println(sum);
	}
}
