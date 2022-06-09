package BaekJoon_self;
import java.io.*;
import java.util.*;
public class Main_B3_2525_오븐시계 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken()); // 현재 시각
		int B = Integer.parseInt(st.nextToken()); // 현재 분
		int food_time = Integer.parseInt(br.readLine());
		
		B += food_time;
		A += B/60;
		B = B%60;
		A %=24;
		System.out.println(A + " " + B);
	}
}