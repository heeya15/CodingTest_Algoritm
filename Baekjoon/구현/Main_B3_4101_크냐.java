package BOJ;
import java.util.*;
import java.io.*;
public class Main_B3_4101_크냐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int first_num = Integer.parseInt(st.nextToken());
			int second_num = Integer.parseInt(st.nextToken());
			if(first_num == 0  && second_num == 0)break;
			if(first_num > second_num) sb.append("Yes").append("\n");
			else sb.append("No").append("\n");	
		}
		System.out.println(sb.toString());
	}
}
