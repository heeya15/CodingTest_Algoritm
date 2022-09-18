package 수학;

import java.util.*;
import java.io.*;

/**
 * 창영이는 자신의 앨범에 포함되어있는 저작권이 있는 멜로디의 평균값을 구해보기로 했다. 
 * 이 값은 아래와 같이 구할 수 있다.
 * (창영이 앨범에 수록된 곡에 포함되어 있는 저작권이 있는 멜로디의 개수) / (앨범에 수록된 곡의 개수)
 * [ 평균값 ]은 항상 올림을 해서 정수로 만들어야 한다
 *
 * ( 문제 풀이 )
 * I = m/A
 * m = A * I가 된다.
 * 위 공식 중 I는 올림한 수를 뜻 한다.
 * 예를 들어서 입력 값 I 가 24 일 때, 23 < I ≤ 24라는 소리다.
 * 즉 평균값이 적어도 23.01 일경우 -> 24 
 * 따라서 생각한 것이 평균값이 올림 되어 나온 것이니, 최소 기존 평균 값이 되게 -0.99 를 빼주자
 * 그 후, 곡의 개수(A) * 기존 최소 평균값(I) 를 곱한 후 무조건 올림 함수인 Math.ceil을 사용해 주면 된다.
 */
public class Main_B3_2914_저작권 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()); // 앨범에 수록된 곡의 개수
		int I = Integer.parseInt(st.nextToken()); // 평균값
		double temp = I-0.99;
		int m = (int)Math.ceil(A * (temp));  // 저작권이 있는 멜로디의 개수
		System.out.println(m);
	}
}