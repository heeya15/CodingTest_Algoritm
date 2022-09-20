package 수학;

import java.util.*;
import java.io.*;

public class Main_B3_5063_TGN {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케 수
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken()); // 광고를 하지 않았을때 수익
			int e = Integer.parseInt(st.nextToken()); // 광고를 했을 때의 수익
			int c = Integer.parseInt(st.nextToken()); // 광고 비용
	
			if(r == e - c) sb.append("does not matter").append("\n");  // 광고를 하든 안하든 상관이 없음
			if(r < e- c) sb.append("advertise").append("\n");         // 광고를 했을때 수익이 나기때문에 광고 o
			if(r > e- c) sb.append("do not advertise").append("\n");  // 광고를 하지 않아야 한다면. ( 광고를 하면 더 손해이기 때문 )
		}
		System.out.println(sb.toString());
	}
}