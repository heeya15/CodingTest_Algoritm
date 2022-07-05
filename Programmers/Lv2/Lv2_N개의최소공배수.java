package Programmers;

/**
 * 유클리드 호제법(최대 공약수)와 LCM 최소 공배수를 이용하여 해결 가능하다.
 * 최소 공배수 = ( 두수의 곱 / 두수의 최대 공약수 )
 * [ 문제 풀이 방법 ]
 * 앞서 두 개의 자연수에 최소 공배수에 대해 해당 값들을 구한 뒤, 
 * < 해당 최소 공배수 값과 다음 배열 값을 이용 >하여 최대공약수, 새로운 최소 공배수를 구하면 
 * 최종 최소공배수를 N개에 대해 구할 수 있다. 
 **/
public class Lv2_N개의최소공배수 {
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		System.out.println(solution(arr)); 
		int[] arr1 = {1, 2, 3};
		System.out.println(solution(arr1)); 
	}

	public static int solution(int[] arr) {
		int answer = arr[0]; // 처음 원소 값 저장.
		for (int i = 1; i < arr.length; i++) {
			/**
			 * 새로운 최소 공배수 = 
			 * (앞서 구한 두 자연수의 최소 공배수 * 다음 원소 값) / (앞서 구한 두 자연수의 최소 공배수, 다음 원소 값)의 최대 공약수(유클리드 호제법)를 구한다.
			 **/
			answer = (answer * arr[i]) / gcd(answer, arr[i]);
		}
		return answer;
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
}