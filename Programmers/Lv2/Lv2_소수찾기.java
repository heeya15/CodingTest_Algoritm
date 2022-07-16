package Programmers;
import java.util.*;

/**
 * Lv2_소수 찾기( 완탐 문제 ) 
 * 
 * ( 문제 풀이 )
 * - i부터 ~ numbers.length() 길이 만큼의 순열 경우의 수를 만들어 준다.
 * - 중복되는 숫자는 제외하고 ArrayList에 넣어준다.
 * - list 안에 있는 숫자 중 소수인지 아닌지 판단하여 소수라면 "소수 개수를 증가"시켜준다.
 **/
public class Lv2_소수찾기 {
	public static ArrayList<Integer> arr;
	public static boolean[] isSelected;
	public static void main(String[] args) {
		System.out.println(solution("17")); // 답 :3
		System.out.println(solution("011")); // 답 :2
	}

	public static int solution(String numbers) {
		int answer = 0;
		arr = new ArrayList<>();
		isSelected = new boolean[7];
		for (int i = 1; i <= numbers.length(); i++) {
			per(numbers, "", i); // 숫자가 적힌 문자열, 소수를 만들용도의 빈 문자열, i개의 숫자 길이인 경우
		}

		// 리스트에 담긴 모든 값을 소수인지 아닌지 판단.
		for (int i = 0; i < arr.size(); i++) {
			if (prime(arr.get(i))) answer++;
		}
		return answer;
	}

	public static void per(String numbers, String temp, int depth) {
		if (temp.length() == depth) { // 숫자가 적힌 문자열을 이용하여 depth 길이 만큼의 숫자를 만들었다면
			int num = Integer.parseInt(temp);
			if (!arr.contains(num)) arr.add(num); // ArrayList에 중복을 제외한 숫자를 넣어준다.
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				temp += numbers.charAt(i);
				per(numbers, temp, depth);
				isSelected[i] = false;
				// temp 문자열에서 마지막 인덱스 문자를 제거한 것을 temp에 저장.
				temp = temp.substring(0, temp.length() - 1);
			}
		}
	}

	// 소수 판단
	public static boolean prime(int n) {
		if (n < 2) return false;
		/**
		 * i=1부터가 아닌 이유는 1은 나눌 필요 없는 수여서 나누어 떨어지면 소수가 아니므로 false
		 **/
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		// 나누어 떨어지지 않으면 ( 소수인 경우 ) true
		return true;
	}
}