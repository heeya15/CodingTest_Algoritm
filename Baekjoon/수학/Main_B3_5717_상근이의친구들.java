package BOJ;
import java.io.*;
import java.util.*;
public class Main_B3_5717_상근이의친구들 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			if(M == 0 && F == 0)break;
			sb.append(M+F).append("\n");
		}
		System.out.println(sb.toString());
	}
}
