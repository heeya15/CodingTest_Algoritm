package 문자열;
import java.io.*;
public class Main_B3_10102_개표 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());// 심사위원의 수
		int A = 0;
		int B = 0;
		char [] temp = br.readLine().toCharArray();
		for (int i = 0; i < V; i++) {
			if(temp[i] == 'A') A++;
			else B++;
		}
		if(A == B) System.out.println("Tie");
		if(A > B) System.out.println("A");
		if(A < B) System.out.println("B");
	}
}