package Programmers;

import java.util.Arrays;

public class Lv1_로또의최고순위와최저순위 {
    // 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
	public static void main(String[] args) {
		int [] lottos = {44, 1, 0, 0, 31, 25};
		int [] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lottos,win_nums))); // 답 : [3, 5]
		int [] lottos1 = {0, 0, 0, 0, 0, 0};
		int [] win_nums1 = {38, 19, 20, 40, 15, 25};
		System.out.println(Arrays.toString(solution(lottos1,win_nums1)));  // 답 : [1, 6]
		int [] lottos2 = {45, 4, 35, 20, 3, 9};
		int [] win_nums2 = {20, 9, 3, 45, 4, 35};
		System.out.println(Arrays.toString(solution(lottos2,win_nums2)));  // 답 : [1, 1]
	}

	 public static int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        int match = 0;
	        int zeroCount = 0;
	        for(int i = 0; i < lottos.length; i++ ){
	            if(lottos[i] == 0){
	                zeroCount++;
	                continue;
	            }
	            for(int j = 0; j < win_nums.length; j++){
	                if(lottos[i] == win_nums[j]) { // 해당 로또 번호가, 당첨 번호와 일치하는 번호가 있으면 
	                    match++; // match 변수 증가 
	                }   
	            }
	        }
	        // 최고 순위와, 최저 순위를 차례대로 배열에 담음.
	        answer[0] = rank( zeroCount + match ); // 알아볼 수 없는 번호(0) 가 모두 당첨 번호와 일치할 경우 
	        answer[1] = rank( match ); // 알아볼 수 없는 번호가 모두 당첨 번호와 불일치할 경우
	        return answer;
	    }
	    public static int rank(int num){
	        switch(num){
	            case 6 : 
	                return 1;
	            case 5 : 
	                return 2;
	            case 4 : 
	                return 3;
	            case 3 : 
	                return 4;
	            case 2 : 
	                return 5;
	            default :
	                return 6;
	        }
	    }
}