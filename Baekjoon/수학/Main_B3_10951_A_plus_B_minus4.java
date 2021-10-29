package 수학;
import java.io.*;
import java.util.*;
/** 수학, 구현, 사칙연산 알고리즘 분류
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * < 입력 >    < 출력 >
 *  1 1         2
	2 3         5
	3 4         7
	9 8         17
	5 2         7
 *
 */
public class Main_B3_10951_A_plus_B_minus4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str="" ;
		//  BufferedReader로 null을 반환하기 위해서는 EOF(파일의) 끝을 던져주어야 하기 때문에 ctrl + Z 눌러줌. 
		while((str = br.readLine())!=null) { // 읽은 문자가 null이 아닐때 까지.	
			st = new StringTokenizer(str," "); // 읽은 문자를 공백 단위로 쪼개서 저장.
			int A = Integer.parseInt(st.nextToken()); 
			int B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append("\n");
		}
		System.out.println(sb);
	}
}
