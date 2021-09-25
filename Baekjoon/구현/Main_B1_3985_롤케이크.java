package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_3985_롤케이크 {
	static int cake[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(br.readLine()); // 케이크 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		
		cake = new int[L+1];
		// 실제로 가장 많은 조각을 받을것이라 예상하는 방청객 번호 저장
		int temp = 0; 
		int real_max = Integer.MIN_VALUE;
		for (int i = 1; i <=N; i++) {
			// 방청객이 종이에 적어낸 수 (원하는 조각 범위 )
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(real_max < k-p) {
				temp = i;
				real_max = Math.max(real_max, k-p);
			}
			// 케이크에 방청객이 원하는 조각 인덱스에 인덱싱 처리.
			for (int j = p; j <= k; j++) {
				if(cake[j] ==0)cake[j] = i;
			}
		}
		
		int max = Integer.MIN_VALUE;
		// 최대 케이크 길이 배열 생성.
		int count [] = new int[1000];
//		방청객이 선택한 조각에 대한 수를 인덱스에 누적시킴.
		for (int i = 1; i < L+1; i++) {
			if(cake[i]!=0)count[cake[i]]++;
		}
		int number = 0; // 실제로 가장 많은 조각을 받은 방청객의 번호.
		for (int i = 1; i < L+1; i++) {
			if(max<count[i] &&count[i]!=0) {
				number = i;
				max = Math.max(max, count[i]);	
			}
		}
		// 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
		sb.append(temp).append("\n");
		// 실제로 가장 많은 조각을 받은 방청객의 번호.
		sb.append(number).append("\n");
		System.out.println(sb);
	}
}
