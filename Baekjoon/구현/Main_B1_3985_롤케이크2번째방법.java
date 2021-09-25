package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_3985_롤케이크2번째방법 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 케이크 길이.
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		// 방청객 i가 종이에 적어낸 수.
		int cake[] = new int[L + 1];
		int maxPerson = Integer.MIN_VALUE;    //가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
		int realmaxPerson = Integer.MIN_VALUE; // 실제로 많은 조각을 받은 방청객의 번호 저장.
		int temp = 0; // 실제 가장 많이 받은 케이크 조각 수 저장 변수.
		int tmp = 0;  // 기대하는 케이크 조각 수 임시 저장 변수.
		
		for (int i = 1; i <= N; i++) {
			// 방청객이 종이에 적어낸 수 (원하는 조각 범위 ) 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
//			가장 많은 조각을 [ 받을 것으로 "기대" ]하는 방청객의 번호 저장.
			if (tmp < k - p) {
				tmp = k - p;   // 가장 많은 케이크 조각을 받는 수 저장. 
				maxPerson = i; 
			}
//			"실제로" 가장 많은 조각을 받은 방청객을 구하는 부분.
			int count = 0;
			for (int j = p; j <= k; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					count++;
				}
				// 이전 방청객의 조각 수보다 현재 방청객이 받은 조각 수가 크다면.
				if (temp < count) {
					temp = count; // 실제로 가장 많은 조각을 받은 갯수 저장.
					realmaxPerson = i; // 실제로 많이 받는 방청객 번호 저장.
				}
			}
		}
		// 첫째 줄에 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
		System.out.println(maxPerson);
		// 둘째 줄에 실제로 가장 많은 조각을 받은 방청객의 번호.
		System.out.println(realmaxPerson);
	}
}
