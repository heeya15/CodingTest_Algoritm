package Programmers;

/**
 * 2021 카카오 채용연계형 인턴십 - Lv1_숫자 문자열과 영단어 - 문자열 처리 문제
 * ( 문제 풀이 ) 
 * 
 * < 1번째 방법 풀이 >
 * - 문자열 배열에 0~9 까지 영어 단어를 넣어둔다. 
 * - 또한 또 다른 문자열 배열에 0~9 까지 숫자로 초기화 시켜준다. ( 나중에 영어 단어를 숫자로 치환 시키기 위해 )
 * - 매개변수로 주어진 문자열 s에 문자열 배열안에 영어 단어들 중 "포함된 숫자 영어 단어"가 있다면 
 * - 영어 단어를 숫자로 치환(replace) 시켜준다. 
 *
 * < 2번째 방법 풀이 >
 * - 문자열 배열에 0~9 까지 영어 단어를 넣어둔다. 
 * - 최종 원래 숫자 정보를 저장하는 변수(num)와, 숫자 영어 단어 임시 저장 변수(temp) 2가지를 이용한다.
 * - 숫자인 경우는 최종 원래 숫자 정보를 저장하는 변수에 누적, 그렇지 않다면 숫자 영어 단어 임시 저장변수에 누적하고, 
 * - "문자열 배열에 있는 숫자 영어 단어 중" temp 변수의 문자열과 같은 것이 있다면 영어단어 문자열 배열 인덱스를 num 변수에 누적 시킴으로 써 해결.
 */
public class Lv1_숫자문자열과영단어 {
	
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight")); // 답 : 1478
		System.out.println(solution("23four5six7"));// 답 : 234567
		System.out.println(solution("2three45sixseven"));// 답 : 234567
		System.out.println(solution("123"));// 답 : 123
		System.out.println();
		System.out.println(solution2("one4seveneight")); // 답 : 1478
		System.out.println(solution2("23four5six7"));// 답 : 234567
		System.out.println(solution2("2three45sixseven"));// 답 : 234567
		System.out.println(solution2("123"));// 답 : 123
	}

	public static int solution(String s) {
		String[] num = new String[10];
		String[] word = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < num.length; i++) num[i] = Integer.toString(i);

		for (int i = 0; i < word.length; i++) {
			if (s.contains(word[i])) s = s.replace(word[i], num[i]);
		}
		return Integer.parseInt(s);
	}
   /*********     2번째 방법       **************/
	public static int solution2(String s) {
		String numbers[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String num = "";  // 최종 원래 숫자 정보를 저장하는 변수
		String temp = ""; // 숫자 영어 단어 임시 저장 변수
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num += s.charAt(i); //'숫자' 문자라면 그냥 그대로 출력할 변수에 저장.
			} else { // 숫자 문자가 아닌 경우
				temp += s.charAt(i); // 영어 단어를 누적한다.
				// 문자열 배열(numbers)에 0~9 까지 영어 단어와 동일한 문자인 경우를 찾는 부분. 
				for (int j = 0; j < numbers.length; j++) {
					if (temp.equals(numbers[j])) { // 동일한 문자를 찾았다면
						num += j;  // 해당 인덱스가 숫자이기 때문에 출력할 변수에 누적.
						temp = ""; // 숫자 영어 단어는 숫자로 표현되었기 때문에 [ 다시 다른 숫자 영어 단어를 담기 위해 초기화. ]
					}
				}
			}
		}
		return Integer.parseInt(num);
	}
}