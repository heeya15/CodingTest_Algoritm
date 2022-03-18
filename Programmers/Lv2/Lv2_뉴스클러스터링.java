package Programmers;

import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

public class Lv2_뉴스클러스터링 {

	public static void main(String[] args) {
//		System.out.println(solution("FRANCE", "french"));
//		System.out.println(solution("handshake","shake hands"));
//		System.out.println(solution("aa1+aa2","AAAA12"));
//		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}

	public static int solution(String str1, String str2) {
		String line1 = str1.toUpperCase();
		String line2 = str2.toUpperCase();
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> gogip = new ArrayList<>();
		int index = 0;

		while (true) {
			String line = "";
			if (index + 1 == line1.length())break;
			char first = line1.charAt(index);
			char second = line1.charAt(index + 1);
			if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
				line += first;
				line += second;
				list1.add(line);
			}
			index++;
		}

		index = 0;
		while (true) {
			String line = "";
			if (index + 1 == line2.length())break;
			char first = line2.charAt(index);
			char second = line2.charAt(index + 1);
			if (first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
				line += first;
				line += second;
				list2.add(line);
			}
			index++;
		}
		// list2 리스트에 list1 원소가 있다면 교집합 리스트에 추가.
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) {
				gogip.add(list1.get(i));
				list2.remove(list1.get(i)); // 교집합 요소를 list2 리스트에 제거. ( 합 집합을 만들기 위해)
			}
			union.add(list1.get(i));
		}

		// list2 요소를 합집합에 추가.
		for (int i = 0; i < list2.size(); i++) {
			union.add(list2.get(i));
		}

		int a = gogip.size();
		int b = union.size();
		double j = 0;

		// A와 집합 B가 모두 공집합일 경우 j를 1로 정의
		if (a == 0 && b == 0)j = 1;
		else j = (double) a / (double) b;
		return (int) (j * 65536);
	}
}
