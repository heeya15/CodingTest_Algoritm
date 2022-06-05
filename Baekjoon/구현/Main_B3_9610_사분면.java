package BaekJoon_self;
import java.io.*;
import java.util.*;
public class Main_B3_9610_사분면 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int q1=0, q2=0, q3=0, q4=0, axis=0;
		int N = Integer.parseInt(br.readLine());// 점의 개수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x== 0 || y==0)axis++;
			else if(x > 0 && y > 0) q1++;
			else if(x > 0 && y < 0) q4++;
			else if(x < 0 && y > 0) q2++;
			else if(x < 0 && y < 0) q3++;
		}
		sb.append("Q1: ").append(q1).append("\n").
		append("Q2: ").append(q2).append("\n").
		append("Q3: ").append(q3).append("\n").
		append("Q4: ").append(q4).append("\n").
		append("AXIS: ").append(axis);
		System.out.println(sb.toString());
	}
}
