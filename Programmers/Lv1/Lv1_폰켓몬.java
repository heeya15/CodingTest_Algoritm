package Programmers;
import java.util.*;

public class Lv1_폰켓몬 {
	/**
	 * 처음에 문제 설명 예시가 조합에 대한 설명 같길래 조합으로 풀었더니 시간초과 ...... 
	 * 계속해서 문제를 좀 더 쉽게 접근하려고 했다.
	 */
	public static void main(String[] args) {
		int[] arr = { 3,1,2,3 };
		System.out.println(solution(arr)); // 답 : 2
		int[] arr2 = { 3,3,3,2,2,4 };
		System.out.println(solution(arr2));// 답 : 3
		int[] arr3 = { 3,3,3,2,2,2 };
		System.out.println(solution(arr3));// 답 : 2
	}

	public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        // 중복을 제거한 숫자를 HashSet 집합에 담는다.
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        // 중복은 제거한 집합(종류) 수와, 폰켓몬 수/2 중 더 작은 [ 폰켓몬 종류의 수 ]를 answer에 저장.
        /**
         *  ex) [ 중복을 제거한 ] 폰켓몬 번호 집합이 < 2개 > 인대, 
         *       폰켓몬 수 /2 마리 선택하는 종류의 수가 < 3개 > 라면 
         *       폰켓몬 번호 2개의 수를 가지고 3마리 만큼의 종류를 가질 수 없어서 
         *       중복을 제거한 집합 수 만큼의 폰켓몬  종류의 수를 가질 수 있게 된다.
         */
        answer = Math.min(set.size(), nums.length/2);
        return answer;
    }
}