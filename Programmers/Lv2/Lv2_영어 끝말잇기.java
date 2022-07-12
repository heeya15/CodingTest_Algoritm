package Programmers;

import java.util.*;

/**
 * Summer/Winter Coding(~2018) - Lv2_영어 끝말잇기 ( 구현 문제 )
 * [ 문제 규칙 ] 
 * 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 
 * 다음은 "3명이" 끝말잇기를 하는 상황을 나타냅니다.
 * tank → kick → know → wheel → land → dream → mother → robot → tank
 * 
 * 끝말잇기를 계속 진행해 나가다 보면, 
 * "3번 사람이" 자신의 "세 번째 차례에" 말한 tank 라는 단어는 [ 이전에 등장했던 단어 ]이므로 탈락하게 됩니다.
 * 
 * ( 문제 풀이 ) 
 * 이전에 사용한 영어 단어를 변수에 저장해 두고 영어 끝말잇기 규칙에 활용하였다.
 * 즉, 핵심은 [ 주어진 영어 끝말잇기 규칙에 따라 구현 ]하면 쉽게 해결 가능하다.
**/
public class Lv2_영어끝말잇기 {
	public static void main(String[] args) {
		String words[] = { "tank", "kick", "know", "wheel", "land",
				          "dream", "mother", "robot", "tank" };
		System.out.println(solution(3, words)); // 답 :[3,3]
		String words1[] = { "hello", "observe", "effect", "take", "either", 
				           "recognize", "encourage", "ensure", "establish", "hang", 
				           "gather", "refer", "reference", "estimate", "executive" };
		System.out.println(solution(3, words1)); // 답 :[0,0]
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int turn = 1; // 차례를 나타내는 변수
		int person_index = 0; // 몇번째 사람을 나타내는 변수
		String last_word = ""; // 이전에 사용된 단어를 저장하는 용도의 변수
		boolean flag = false; // 끝말 잇기 규칙에 어긋나는지 체크 용도의 변수
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String temp = words[i];
			char end = ' ';
			String temp1 = "";
			if (list.isEmpty()) { // 끝말잇기 단어가 비어있는 경우
				list.add(temp);
				person_index++;
				last_word = temp;
			} else { // 끝말잇기 단어가 비어있지 않는 경우
				if (last_word.length() > 0) { // 이전 끝말잇기 단어의 마지막 문자를 추출해내는 부분
					end = last_word.charAt(last_word.length() - 1);
					temp1 += end;
				}
				// "현재 사람의 영어 단어가" 앞 사람이 말한 단어의 마지막 문자로 시작하는 단어가 아닌경우
				if (temp.length() > 0 && !temp1.equals(temp.substring(0, 1))) {
					person_index++;
					flag = true;
					break;
				}

				// 한 글자인 단어인 경우 인정 되지 않는다의 조건
				if (temp.length() == 1) {
					person_index++;
					flag = true;
					break;
				}

				// 이전에 등장했던 단어를 사용할 경우 탈락
				if (list.contains(temp)) {
					person_index++;
					flag = true;
					break;
				}
				// 이전에 등장했던 영어 단어가 아니고 규칙을 어긋나지 않은 경우.
				else if (!list.contains(temp)) {
					list.add(temp);
					person_index++;
					last_word = temp;
				}

				// 마지막 사람이 단어를 말한 다음에는 다시 1번 부터 시작.
				if (person_index == n) {
					person_index = 0;
					turn++;
				}
			}
		}

		if (flag) {
			answer[0] = person_index;
			answer[1] = turn;
		}
		return answer;
	}
}