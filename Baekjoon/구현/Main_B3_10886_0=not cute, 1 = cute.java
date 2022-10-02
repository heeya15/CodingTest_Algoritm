package 구현;

import java.io.*;
public class Main_B3_10886_0notcute_1cute {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 설문 조사를 한 사람의 수
		int [] cute_info = new int[2]; // 0은 귀엽지 않다, 1은 귀엽다에 대한 인덱스
		for (int i = 0; i < N; i++) {
			int opinion = Integer.parseInt(br.readLine()); // 설문조사 의견
			cute_info[opinion]++;
		}
		String answer = cute_info[0] > cute_info[1] ? "Junhee is not cute!" :"Junhee is cute!";
		System.out.println(answer);
	}
}