package BOJ;
import java.io.*;
import java.util.*;
/**
 * 스네이크버드는 "자신의 길이"보다 < 작거나 같은 높이 >에 있는 과일들을 먹을 수 있습니다.
      스네이크버드의 처음 길이가 L일때 [ 과일들을 먹어 늘릴 수 있는 최대 길이 ]를 구하세요.
 *
 */
public class Main_S5_16435_스네이크버드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken()); // 과일의 개수
		int L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 ㅣ길이 정수
		int fruits [] = new int[N]; // 과일을 담을 배열 초기화.
		
		// 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i< N; i++) fruits[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(fruits); // 과일을 오름차순으로 정렬
		for(int i = 0; i< N; i++) {
			if(L>= fruits[i])L++;
		}
		System.out.println(L);
	}
}
