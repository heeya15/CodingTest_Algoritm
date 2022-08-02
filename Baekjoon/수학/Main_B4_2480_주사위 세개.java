package 수학;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_B4_2480_주사위세개 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = 0;
		// 3개 모두 같은 눈이 나올 때
		if(a == b && a == c && b == c) result = 10000 + a * 1000;
		
		// 같은 눈이 2개 나올때 
		if(a == b && a != c) result =  1000 + a*100;
		
		if(a == c && a != b) result =  1000 + a*100;
		
		if(b == c && a != b) result =  1000 + b*100;
		
		// 모두 다른 눈이 나오는 경우
		if(a != b && a != c && b !=c ) result = Math.max(a,Math.max(b,c)) * 100;
		// 출력
		System.out.println(result);
	}
}
