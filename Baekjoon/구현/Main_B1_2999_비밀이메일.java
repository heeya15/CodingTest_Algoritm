package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B1_2999_비밀이메일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int r = 0, c = 0;
		for (int i = 1; i < line.length(); i++) {
/** 
	  - 정인이는 R<=C이고, R(행)*C(열)=N인 R과 C를 고른다. 만약, 
	       그러한 경우가 여러 개일 경우, "R이 큰 값"
	    < 주의 할 점>
	  - r로 n을 나눈 나머지가 0이 되어야  r*c 가 성립 
	        홀수일 경우 n = 5 면 1행 5열 에서 끝나야 하는데 "나머지 0인 경우를 빼게 되면" 2 2 가 되어버림.
**/
			if(line.length() %i ==0 && i<= line.length()/i ) {
				r= i;
				c= line.length()/r;
			}
		}
		char [][] arr = new char[r][c] ; // 배열 초기화.
		int index =0;
		for (int i = 0; i < c; i++) { // 열
			for (int j = 0; j < r; j++) { // 행
				arr[j][i] = line.charAt(index++);
			}
		}
//		최종 결과 출력.		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) { // 행
			for (int j = 0; j < c; j++) { //열
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb);
	}
}
