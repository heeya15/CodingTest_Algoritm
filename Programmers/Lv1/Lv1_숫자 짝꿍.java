package Programmers;

/**
 * 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용
 */
public class Lv1_숫자짝꿍 {
	public static void main(String[] args) throws Exception {
		System.out.println(solution("100", "2345")); // 답 : -1
		System.out.println(solution("100", "123450")); // 답 : 10
	}
	public static String solution(String X, String Y) {
		String answer = "";
		int[] num1 = new int[10];
		int[] num2 = new int[10];
		MakeNumberCountArrays(num1, X);
		MakeNumberCountArrays(num2, Y);

		StringBuilder sb = new StringBuilder();
		// 먼저 공통으로 나타나는 숫자 추려내기 -> 여기서 큰 숫자 부터 StringBuilder에 넣어줄 거임.
		for (int i = num1.length - 1; i >= 0; i--) {
			while (num1[i] >= 1 && num2[i] >= 1) {
				num1[i]--;
				num2[i]--;
				sb.append(i);
			}
		}
		// 짝꿍이 존재하지 않으면
		if (sb.toString().equals("")) return "-1";
		// 첫 문자가 0 ->즉, 짝꿍이 0으로만 구성되어 있다면
		if (sb.toString().charAt(0) == '0') return "0";
		// X,Y 의 짝꿍중 가장 큰 정수 answer에 저장
		answer = sb.toString();
		return answer;
	}

	// 문자열을 숫자 배열에 숫자 개수 누적하여 만들기 함수
	public static void MakeNumberCountArrays(int[] arr, String n) {
		for (int i = 0; i < n.length(); i++) {
			char temp = n.charAt(i);
			arr[temp - '0']++;
		}
	}
}
