package Programmers;

public class Lv1_옹알이 {
	// 조카 발음은 중복해서 사용 x
	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa" };
		System.out.println(solution(babbling)); // 답 : 1
		String[] babbling1 = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
		System.out.println(solution(babbling1)); // 답 : 2

		System.out.println(solution1(babbling)); // 답 : 1
		System.out.println(solution1(babbling1)); // 답 : 2
	}

	// 1번째 방법
	public static int solution(String[] babbling) {
		int answer = 0;
		String[] pronunciation = { "aya", "ye", "woo", "ma" };
		for (int i = 0; i < babbling.length; i++) {
			char temp[] = babbling[i].toCharArray();
			String word = "";      // 현재 만들어가고 있는 발음
			String prev_word = ""; // 이전 조카가 발음하는 단어 ( 중복 발음을 걸러내기 위한 변수)
			for (int j = 0; j < temp.length; j++) {
				word += temp[j];
				// 조카가 4가지 발음중 발음할 수 있는 경우이면서,
				if (word.equals(pronunciation[0]) || word.equals(pronunciation[1]) ||
				    word.equals(pronunciation[2]) || word.equals(pronunciation[3])) {
					if (!prev_word.equals(word)) { // 현재 만든 발음과, 이전 발음이 같지 않다면
						prev_word = word;
						word = "";
					}
				}
			}
			if (word.length() == 0)
				answer++;
		}
		return answer;
	}

	// 2번째 방법
	public static int solution1(String[] babbling) {
		int answer = 0;
		String[] pronunciation = { "aya", "ye", "woo", "ma" };
		String[] duplication_pronunciation = { "ayaaya", "yeye", "woowoo", "mama" };
		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < pronunciation.length; j++) {
				// 문자열 배열이 발음 중복(포함) 되지 않는다면, 문자열 배열을 조카가 발음할 수 있는 현재 단어 원소로 치환해 준다.
				if (!babbling[i].contains(duplication_pronunciation[j])) {
					babbling[i] = babbling[i].replace(pronunciation[j], "1"); // 해당 조카 발음을 1로 치환
				}
			}
			babbling[i] = babbling[i].replace("1", ""); // 문자열 배열 원소중 숫자 1 문자를 공백으로 치환해 주기
			if (babbling[i].length() == 0) answer++; // 문자열 배열 남은 길이가 0이라면 발음할 수 있는 단어 개수 +1 해주기
		}
		return answer;
	}
}