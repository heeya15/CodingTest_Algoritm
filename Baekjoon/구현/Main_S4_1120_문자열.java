package BOJ;
import java.io.*;
import java.util.*;

/**
 * B문자열의 단어를 하나씩 A문자열 길이 만큼 돌면서 A문자열 과의 차이가 가장 적을 때
      그 차이를 출력하면 되는 문제.
     즉, Focus는 A와 B의 차이점에만 두고 해결.    
   [ 입력 ]
   A의 길이는 B의 길이보다 작거나 같다. B의 길이는 A보다 클 수 있다는 얘기!.
 */
public class Main_S4_1120_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int result = A.length();
		// A와 B의 길이가 같으면서 A와 B의 차이를 최소로. 
		// --> B-A 의 길이 만큼 한칸씩 B를 오른쪽으로 밀어서 A 문자열 길이만큼 반복하여 B문자열, A문자열 두 문자열 차이가 가장 적은 값을 result 변수에 저장.
		for (int i = 0; i <= B.length() - A.length() ; i++) {
			int count = 0;
			for (int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(i+j))count++;
			}	
			result = Math.min(result, count);
		}
		System.out.println(result);
	}
}
