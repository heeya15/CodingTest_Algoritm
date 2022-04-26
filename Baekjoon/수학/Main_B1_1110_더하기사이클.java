package BOJ;
import java.io.*;
import java.util.*;
public class Main_B1_1110_더하기사이클 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		int result = 0;
		int count = 0;
		while(true) {
			int sum = 0;
			int front = temp/10;
			int back = temp%10;
			sum = front+back; // 2 + 6
			if(sum < 10)temp = back*10 + sum; // 68
			else temp = (back *10) + (sum%10);
			result = temp;
			count++;
			if(result == N)break;
		}
		System.out.println(count);
	}
}
