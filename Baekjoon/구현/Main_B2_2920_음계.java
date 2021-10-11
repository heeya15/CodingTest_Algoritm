package 구현;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.*;

public class Main_B2_2920_음계 {
	static final int K= 8; // 8개 단어 주어짐.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		       
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int temp [] = new int[K];
		// 8개의 숫자 입력.
		for (int i = 0; i < K; i++) temp[i] = Integer.parseInt(st.nextToken());
		
		int asc_count = 0;
		int desc_count = 0;
		for (int i = 1; i <= K; i++) {
			if(temp[i-1] == i)asc_count++;
			else break; // 차례대로 연주한게 아니라면 바로 for문 벗어나게 해줌.
		}
		
		int index = 0;
		for (int i = K; i >=1; i--) {
			if(temp[index++] ==i )desc_count++;
			else break; // 차례대로 연주한게 아니라면 바로 for문 벗어나게 해줌.
		}
		// 차례대로 연주한게 아닌경우 mixed 출력.
		if(asc_count != K && desc_count != K)System.out.println("mixed");
		if(asc_count == K)System.out.println("ascending");
		else if(desc_count == K)System.out.println("descending");
		
		/** 아래는 문자열 라이브러리 사용한 다른방법 코드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

        String asc = "1 2 3 4 5 6 7 8";
        String desc = "8 7 6 5 4 3 2 1";
        // 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수 contains를 사용하여 품.
        if(line.contains(asc)) System.out.println("ascending");
        else if(line.contains(desc))  System.out.println("descending");
        else System.out.println("mixed");
		 */
	}
}
