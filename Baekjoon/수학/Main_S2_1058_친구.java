package BOJ;
import java.io.*;
import java.util.*;
public class Main_S2_1058_친구 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 뒤 두자리를 가능하면 작게 만들려 함.
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
	
		int temp = (N /100) * 100; // 맨 뒤의 숫자를 00으로 채워줌 
		int result = 0;
		// 뒤의 두자리를 가능하면 가장 작게 만들려 함
		while(true) {
			if(temp % F == 0) {
				result = temp % 100; // 해당 마지막 두 자리 숫자를 result 변수에 담음
				if(result <10) System.out.println("0"+result);
				else System.out.println(result);
				return;
			}
			temp++;
		}
	}
}
