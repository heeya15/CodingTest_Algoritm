package 구현;

import java.util.*;
import java.io.*;
/**
 * 각 참가자는 자신있는 음식을 하나씩 만들어오고, < 서로 다른 사람의 음식을 > "점수로 평가"해준다.
 * 점수는 1점부터 5점까지 있다. 각 참가자가 얻은 점수는 < 다른 사람이 평가해 준 점수의 합 >이다. 
 * 각 참가자가 얻은 평가 점수가 주어졌을 때, [ 우승자 ]와 [ 그의 점수를 구하는 ] 프로그램을 작성하시오.
 */
public class Main_B3_2953_나는요리사다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Winner_number = 0;
		int max = Integer.MIN_VALUE;
		// 총 5개 줄에 각 참가자가 얻은 4개의 평가 점수가 공백으로 구분되어 주어진다.
		// 첫 번째 참가자 부터 다섯 번째 참가자 까지 순서대로 주어진다
		for (int i = 1; i <=5; i++) {
			int total_jumsu = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <4; j++) {
				total_jumsu += Integer.parseInt(st.nextToken());
			}
			if(max < total_jumsu) { // 얻은 점수가 max 보다 클 경우
				Winner_number = i;     // 우승자 번호를 winner_num에 저장
				max = total_jumsu;  // 그가 얻은 점수를 max에 저장
			}
		}
		System.out.println(Winner_number + " " + max);
	}
}