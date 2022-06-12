package Programmers;
import java.util.*;
/**
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 */
public class Lv1_최대공약수와최소공배수 {
	public static void main(String[] args) {
		System.out.println(solution(3, 12)); // 답 :[3, 12]
		System.out.println(solution(2, 5));  // 답 :[1, 10]
	}
	public static ArrayList<Integer> solution(int n, int m) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int max = gcd(n, m); // 최대 공약수
		answer.add(max);
		answer.add((n * m) / max); // 최소 공배수(lcm) : n과 m을 곱한거에 최대 공약수로 나눠주면 최소 공배수가 됨.
		return answer;
	}
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
