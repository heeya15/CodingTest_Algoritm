package BaekJoon_self;
import java.io.*;
import java.util.*;
public class Main_B3_3009_네번째점 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int [] x = new int[1001];
		int [] y = new int[1001];
		for(int i = 0; i< 3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken()); 
			x[nx] = x[nx] +1;
			y[ny] = y[ny] +1;
		}
		int point_x = 0, point_y = 0;
		// x축과 y축에서 한번씩만 나왔다면 그것이 직사각형을 만들기 위해 필요한 네번째 점 x, y축이 됨. 
		for(int i =0; i< x.length; i++) {
			if(x[i] == 1) point_x = i;
			if(y[i] == 1) point_y = i;
		}
		System.out.println(point_x +" "+point_y);
	}
}
