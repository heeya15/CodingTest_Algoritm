package BOJ;
import java.io.*;
import java.util.*;
public class Main_B5_3046_R2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R1 = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		System.out.println((S*2)-R1);
	}
}
