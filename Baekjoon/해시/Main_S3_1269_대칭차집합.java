package 해시;
import java.util.*;
import java.io.*;
/**
 * [ 문제 ]
 * 두 집합의 대칭 [ 차집합의 원소의 개수를 출력 ]하는 프로그램을 작성하시오.
 * 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.
     예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때, 
   A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.
 *
 */
public class Main_S3_1269_대칭차집합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		HashSet<Integer> set1 = new HashSet();
		HashSet<Integer> set2 = new HashSet();
		// A의 원소, B의 원소의 개수 입력.
		int A = Integer.parseInt(st.nextToken()); 
		int B = Integer.parseInt(st.nextToken());
		int result = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < A; i++) { // A의 원소 입력
			int temp1 = Integer.parseInt(st.nextToken());
			set1.add(temp1);
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < B; i++) { // B의 원소 입력
			int temp2 = Integer.parseInt(st.nextToken());
			set2.add(temp2);
		}
		// 차집합 원소의 개수 카운팅
		for(int num1 : set1) {
			if(!set2.contains(num1)) result++;	
		}
		for(int num2 : set2) {
			if(!set1.contains(num2)) result++;	
		}
		// 출력.
		System.out.println(result);
	}
}
