package 해시;
import java.util.*;
public class Lv2_전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" }; // false
		System.out.println(solution(phone_book));
		String[] phone_book1 = { "123", "456", "789" }; // true
		System.out.println(solution(phone_book1));
		String[] phone_book2 = { "934793", "34", "44", "9347" }; // fasle
		System.out.println(solution(phone_book2));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < phone_book.length; i++) map.put(phone_book[i], i);

		for (String line : phone_book) {
			for (int i = 0; i < line.length(); i++) {
				/**
				 * 3번 테케를 예로 들면 처음에 "1"만 hash안에 키로 들어가 있는지 검사 그 후, 
				 * 다음 원소인 123 중 "1"이 있는지, "12"가 있는지 검사하다 "12" 문자열의 키가 있어서 false가 되는 형태 
				 * 즉, 배열 안의 하나의 원소길이 보다 하나 작은 길이까지 잘라 키로 들어가 있는지를 검사하면 접두어가 있는 경우 검사가 가능하게 됨.
				 * 아래는 3번 테케 substring으로 인해 하나의 원소가 hash에 동일한 키가 있는지 검사하는 문자 예시다.
				 * 3번 테케 = {"12", "123", "1235", "567", "88"}
				 *  ex) 1, 1 , 12  -->  처음 원소 1까지만 검사, 2번째 원소 1 검사 후 12까지 검사 이때 hash에 12라는 키가 있어서
				 *  접두어 골라냄.
				 **/
				if (map.containsKey(line.substring(0, i))) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
}
