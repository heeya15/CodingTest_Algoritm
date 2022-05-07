package BOJ;
import java.util.*;
import java.io.*;
public class Main_B3_11021_A_plus_B_7 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append("Case #").append(i+": ").append(A+B).append("\n");
		}
		System.out.println(sb.toString());
	}
}
