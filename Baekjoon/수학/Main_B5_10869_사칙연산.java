package BOJ;
import java.util.*;
import java.io.*;
public class Main_B5_10869_사칙연산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append(A+B).append("\n")
		.append(A-B).append("\n")
		.append(A*B).append("\n")
		.append(A/B).append("\n")
		.append(A%B).append("\n");
		System.out.println(sb.toString());
	}
}
