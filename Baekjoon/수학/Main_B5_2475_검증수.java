package 수학;
import java.util.*;
import java.io.*;
public class Main_B5_2475_검증수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int gegop_sum = 0;
		for(int i=0, size = st.countTokens(); i < size; i++) { // 고유의 번호 숫자만큼 반복
			int num = Integer.parseInt(st.nextToken());
			gegop_sum += (int)Math.pow(num, 2); // 각 숫자들을 제곱한 수들의 합을 누적.
		}
		System.out.println(gegop_sum%10); // 최종 제곱한 수들의 합을 10으로 나눈 나머지를 "출력".
	}
}
