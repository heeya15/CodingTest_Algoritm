package BOJ;
import java.io.*;
import java.util.*;
public class Main_B3_11022_A_plus_B_8 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append("Case #").append(i).append(": ")
			.append(A).append(" + ").append(B).append(" = ").append(A+B).append("\n");
		}
		System.out.println(sb.toString());	
	}
}
