package 해시;

import java.io.*;
import java.util.*;
/**
 * 
 * [ 입 출력 ]                                     	 	[결과 ]
	 	[["yellowhat", "headgear"], 
1번 테케	 ["bluesunglasses", "eyewear"], 
	 	 ["green_turban", "headgear"]                     5
	 	 ]                                          
2번 테케  [["crowmask", "face"], 
        ["bluesunglasses", "face"], 
        ["smoky_makeup", "face"]]	                  3 
< 1번 테케로 설명> 
headgear : 2개
eyewear : 1개 
--> headgear 1번만 입을경우, 2번만 입을경우, 아얘 안 입을경우 총 3가지 경우의 수
--> eywear 입을경우(headgear 안입는 경우 해당), 안 입을경우( 1번 or 2번만 입을 경우 안 입는 경우 해당)
따라서 3 * 2 = 6가지의 경우의 수지만 우리는 둘 다 안입는 경우의 수는 제외 한 5가지가 정답이 됨.
**/
public class Lv2_위장 {
	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, 
				{ "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		System.out.print(solution(clothes)); // 답 : 5
	}
	public static int solution(String[][] clothes) {
		int answer = 0;
		int row = clothes.length; // 행의 수

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < row; i++) {
			String type = clothes[i][1];
			if (map.containsKey(type)) { // 해당하는 키의 종류가 있다면 true
				map.put(type, map.get(type) + 1); // 종류와,해당 타입의 종류 개수를 들고와서 +1 한걸 다시 넣어줌.
			} else {
				map.put(type, 1);
			}
		}
		int result = 1; // 의상을 입을 수 있는 경우의 수를 저장할 변수
		for (int val : map.values())
			result *= val + 1;

		answer = result - 1; // 모두 안입는 경우의 수 1을 빼줌.
		return answer;
	}
}
