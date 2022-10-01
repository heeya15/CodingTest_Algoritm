package 수학;
import java.util.*;
public class Main_B1_11653_소인수분해 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int i = 2;
		while(i <= N) {
			if(N % i == 0) {
				sb.append(i).append("\n");
				N = N / i;
			}else i++;	
		}
		System.out.println(sb.toString());
	}
}
