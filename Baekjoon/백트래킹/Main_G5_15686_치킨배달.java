package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_G5_15686_치킨배달 {
	static int N, M;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	static boolean isCheck[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 도시의 행 입력
		M = Integer.parseInt(st.nextToken()); // 최대 고를 횟 수
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		// 치킨 집과 , 본인 집 좌표를 미리 넣어둠.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {// 일반 집
					house.add(new int[] { i, j });
				} else if (temp == 2) { // 치킨집
					chicken.add(new int[] { i, j });
				}
			}
		} // for end
		isCheck = new boolean[chicken.size()]; // 해당 치킨집 좌표가 들어있는 배열 사이즈 만큼 생성.
		comb(0, 0);
		System.out.println(result);
	}
	// 백트래킹 사용.
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(isCheck));
			int dist = 0;
			for (int i = 0; i < house.size(); i++) { // 모든 집에서
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) { // 선택한 치킨 집의 거리를 구하는 부분.
					if (isCheck[j]) {
						// 집과, 치킨집 사이의 거리를 구함. -- 가장 작은 거리를 구함.
						temp = Math.min(temp, Math.abs(house.get(i)[0] - chicken.get(j)[0])
								+ Math.abs(house.get(i)[1] - chicken.get(j)[1]));
					}
				}
				dist += temp;
			}
			result = Math.min(result, dist);
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			isCheck[i] = true;
			comb(cnt + 1, i + 1);
			isCheck[i] = false;
		}
	}
}
