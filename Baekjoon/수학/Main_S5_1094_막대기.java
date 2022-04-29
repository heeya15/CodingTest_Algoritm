package BOJ;
import java.io.*;
/**
 * [ 풀이 ]
 * - 스틱의 길이는 64 -> 원하는 길이보다 크면 스틱을 절반으로 자름
 * - 원하는 길이 보다 작으면 원하는 길이에서 스틱의 길이를 빼고 [ 풀로 붙이는 횟수 증가. ]
 */
public class Main_S5_1094_막대기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stick = 64; // 가지고 있는 막대의 길이
		int X = Integer.parseInt(br.readLine());
		int count = 0;
		while(X>0) {
			if(stick > X)  stick /=2; // 막대가 원하는 막대의 길이보다 더 크면 반으로 짜름
			else {
				count++;
				X -=stick;
			}
		}
		System.out.println(count);
	}
}
