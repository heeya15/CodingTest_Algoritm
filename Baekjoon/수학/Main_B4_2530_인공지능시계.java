package BaekJoon_self;
import java.io.*;
import java.util.*;
public class Main_B4_2530_인공지능시계 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int hour = Integer.parseInt(st.nextToken()); // 시 
		int min = Integer.parseInt(st.nextToken());  // 분
		int sec = Integer.parseInt(st.nextToken());  // 초
		int food_time = Integer.parseInt(br.readLine());
		
		// 먼저 맨 뒤의 초에 음식시간에 걸리는 시간 초를 더해준다.
		sec += food_time;
		// sec 초를 60초 아래로 정리해주기 위해 나눠서 [ 몫과 나머지를 ] 분과 초에 합산 및 대입
		min += sec/60;
		sec %= 60;
		// min 분을 60분 아래로 정리해주기 위해 나눠서 [ 몫과 나머지를 ] 시간과 분에 합산 및 대입
		hour+= min /60;
		min %=60;
		/** 시간이 24와 48 사이 값이 나오기때문에 24 한번만 빼면 되겠지 생각했지만 
		       이 문제는 시간이 100 넘게 넘어가기 때문에 24를 나눈 나머지 값을 시간으로 하도록 했다.**/
		hour %=24;
		System.out.println(hour+" " + min + " "+ sec);
	}
}
