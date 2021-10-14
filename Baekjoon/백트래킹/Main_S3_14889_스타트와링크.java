package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_14889_스타트와링크 {
	static int N;
	static int[][] synerge;
	static boolean[] isSelected;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 축구를 하기 위해 모인 사람.
		synerge = new int[N][N]; // 능력치 저장.
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				synerge[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE; // 능력치 차이의 최솟값을 저장받을 변수.
		comb(0, 0);
		System.out.println(min);
	}

	private static void comb(int lev, int start) {
		if (lev == N / 2) {
			// System.out.println(Arrays.toString(isSelected));
			int start_team = 0;
			int link_team = 0;
			int temp = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isSelected[i] == true && isSelected[j] == true) {
						start_team += synerge[i][j];
					} else if (isSelected[i] == false && isSelected[j] == false) {
						link_team += synerge[i][j];
					}
				}
			}
			temp = Math.min(temp, Math.abs(start_team - link_team));
			// 가지치기 = 현재 능력치 차이가 이전 최소 능력치 차이보다 크다면 리턴
			if (temp > min)return;
			min = temp;
			return;
		}

		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			comb(lev + 1, i + 1);
			isSelected[i] = false;
		}
	}
}
