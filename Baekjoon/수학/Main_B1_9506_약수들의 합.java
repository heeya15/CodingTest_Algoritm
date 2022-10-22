package 수학;
import java.io.*;
public class Main_B1_9506_약수들의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {			
			int n = Integer.parseInt(br.readLine());
			if(n == -1) {
				System.out.println(sb.toString());
				return;
			}
			int sum = 0;
			for(int i = 1; i <n; i++) {
				if(n % i == 0) sum += i;		
			}
			
			if(sum == n) {
				sb.append(n+" = 1");
				for(int i = 2; i <n; i++) {
					if(n % i == 0) sb.append(" + ").append(i);	
				}
				sb.append("\n");
			}else sb.append(n + " is NOT perfect.").append("\n");
		}		
	}
}
