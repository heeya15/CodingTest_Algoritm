package Programmers;

public class Lv1_신규아이디추천 {
    // 2021 KAKAO BLIND RECRUITMENT - 문자열 처리 문제
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm")); // 답 : "bat.y.abcdefghi"
		System.out.println(solution("z-+.^."));// 답 : "z--"
		System.out.println(solution("=.="));// 답 : aaa
		System.out.println(solution("123_.def"));// 답 : 123_.def
	}

	public static String solution(String new_id) {
		String answer = "";
		// 1. 모든 대문자를 대응되는 소문자로 치환
		new_id = new_id.toLowerCase();
		// 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
		for (int i = 0; i < new_id.length(); i++) {
			char tmp = new_id.charAt(i);
			if (tmp >= 'a' && tmp <= 'z' || tmp >= '0' && tmp <= '9' || tmp == '_' || tmp == '-' || tmp == '.') {
				answer += tmp;
			}
		}
		// 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		while (answer.contains("..")) {
			answer = answer.replace("..", ".");
		}

		// 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		/**
		 * if (new_id.length() > 0)를 하는 이유 1~4단계 도중 문자열이 다 지워져서 빈 문자열인 경우가 있기 때문
		 **/
		if (answer.length() > 0) {
			if (answer.charAt(0) == '.') {
				answer = answer.substring(1, answer.length());
			}
		}
		if (answer.length() > 0) {
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = answer.substring(0, answer.length() - 1);
			}
		}

		// 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (answer.equals(""))
			answer = "a";

		// 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (answer.length() >= 16) answer = answer.substring(0, 15);
		if (answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);

		// 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		char last_word = answer.charAt(answer.length() - 1);
		while (answer.length() <= 2) {
			answer += last_word;
			if (answer.length() == 3)
				break;
		}
		return answer;
	}
}