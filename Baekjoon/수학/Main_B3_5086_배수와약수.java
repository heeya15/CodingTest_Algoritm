package BOJ;
import java.io.*;
import java.util.*;
public class Main_B3_5086_배수와약수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if(first == 0 && second == 0)break;
			
			// 첫 번째 수가 두 번째 수의 약수일 때 (= 두 번째 수가 첫 번째 수의 배수일 때)
			if(second % first == 0) System.out.println("factor");
			// 첫 번째 수가 두 번째 수의 배수일 때 (= 두 번째 수가 첫 번째 수의 약수일 때)
			else if(first % second == 0) System.out.println("multiple");
			// 첫 번째 수와 두 번째 수가 서로 약수와 배수의 관계가 아닐 때
			else System.out.println("neither");
		}

	}

}
