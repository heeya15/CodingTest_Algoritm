package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {
    static int K=100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10; // 10개의 테케
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int [][] map = new int[K][K];
         
            int max = 0;
            for (int i = 0; i < K; i++) {
                int row_sum =0;
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < K; j++) {
                    map[i][j] =Integer.parseInt(st.nextToken());
                    row_sum += map[i][j];
                }
                max = Math.max(max, row_sum);
            }
            // 열 합.
            for (int i = 0; i < K; i++) {
                int col_sum =0;
                for (int j = 0; j < K; j++) {
                    col_sum += map[j][i];
                }
                max = Math.max(max, col_sum);
            }
            int right_degak =0;
            int left_degak =0;
            int temp = K-1;
            for (int i = 0; i < K; i++) {
                right_degak += map[i][i];
                left_degak += map[i][temp--];           
            }
            right_degak = Math.max(right_degak, left_degak);
            max = Math.max(max, right_degak);
            sb.append("#").append(n).append(" ").append(max).append("\n");
        }
        System.out.println(sb); 
    }
}
/**
public class Solution_D3_1209_Sum2번째방법 {
	static final int N = 100;
	static int max;
	static int[][] map;
	static int nx, ny;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			// 값 초기화 부분.
			int degak_sum =0;
			int col_sum =0;
			nx=ny =0;
			max = Integer.MIN_VALUE;
			
			// 테케 입력및 맵 사이즈 초기화.
			int test_case = Integer.parseInt(br.readLine()); 
			map = new int[N][N];

			// 맵 좌표 입력 받을때 미리 "각 행의 합"을 저장 받아놓음.
			for (int i = 0; i < N; i++) {
				int row_sum = 0;
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					row_sum += map[i][j];
				}
				max = Math.max(max, row_sum);
			}
			// 열에 대한 합 구함.
			for (int i = 0; i < N; i++) {
				col_sum =0;
				for(int j=0; j < N; j++) {
					col_sum += map[j][i];
				}
				max = Math.max(max, col_sum);
			}
			// 오른쪽 대각 합.
			for (int i = 0; i < N; i++) {
				degak_sum += map[i][i];
			}
			max= Math.max(max, degak_sum); // 갱신. 큰 값 있다면.
			
			// 왼쪽 대각 합
			int k = N-1;
			degak_sum=0;
			ny = k;
			while (true) {
				degak_sum = map[0][k];
				nx += 1;
				ny -= 1;
				if (nx == N - 1 && ny == 0) {
					max = Math.max(max, degak_sum);
					break;
				}
				if (nx < N && ny > -1)
					degak_sum += map[nx][ny];
			}
			sb.append("#").append(test_case).append(" ").append(max);
			sb.append("\n");
		} // for end
		System.out.println(sb);
	}
}

**/