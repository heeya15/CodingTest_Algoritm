package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_20299_3대측정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 팀의 수
		int k = Integer.parseInt(st.nextToken()); // 팀원 3명의 [ 레이팅 합 ]에 대한 클럽 가입 조건
		int l = Integer.parseInt(st.nextToken()); // 개인 레이팅에 대한 클럽 가입 조건
		int rating[] = new int[3];
		int total = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			int count = 0;
			st = new StringTokenizer(br.readLine(), " ");
			// 3명의 팀의 레이팅 정보 입력.
			for (int j = 0; j < 3; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp >= l) { // 개인 레이팅 가입조건 이상인 경우
					rating[j] = tmp;  // 선수 레이팅 저장.
					sum += rating[j]; // 선수 레이팅 합을 누적. 
					count++;		  // 신청한 팀원 중 가입할 수 있는 팀원 수 저장.
				}
			}
			// 3명다 신청 가능하며, 팀원 세명의 레이팅의 합이 K이상인 팀인 경우.
			if (count == 3 && sum >= k) {
				for (int j = 0; j < 3; j++) {
					sb.append(rating[j]).append(" "); // 한 팀당 3명의 선수 회원들의 레이팅을 저장.
				}
				total++; // 가입 가능한 팀의 수 누적.
			}
		}
		// VIP 클럽에 가입할 수 있는 팀의 수
		System.out.println(total);
		// VIP 회원들의 레이팅
		System.out.println(sb);
	}
}
