package Programmers;

import java.util.*;
/**
	 문자열 자르기 또는 데이터 형 변환을 잘 활용하면 쉽게 풀 수 있는 문제
**/
public class Lv2_최댓값과최솟값 {
	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4")); // 답 :"1 4"
		System.out.println(solution("-1 -2 -3 -4")); // 답 : "-4 -1"
		System.out.println(solution("-1 -1")); // 답 : "-1 -1"
	}
    // 1. 규칙에 따라 숫자나 '-'인 경우 num 문자열 변수에 누적 하고 
	// 공백을 만났거나, 맨 마지막 배열 원소인 경우 min, max 값을 갱신 시켜줌.
	public static String solution(String s) {
        String answer = "";
        char [] temp = s.toCharArray();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String num = "";
        for(int i = 0 ; i < temp.length ; i++ ){
            char data = temp[i];
            if(data >= '0' && data <= '9'){
                num += data;
                if(i == temp.length-1){
                    min = Math.min(min, Integer.parseInt(num));
                    max = Math.max(max, Integer.parseInt(num));
                    num = "";
                }
            }
            if(data == '-') num += data;
                  
            if(data == ' '){
                min = Math.min(min, Integer.parseInt(num));
                max = Math.max(max, Integer.parseInt(num));
                num = "";
            }
        }
        answer = Integer.toString(min) + " "+ Integer.toString(max);
        return answer;
     }
	 // 2. 문자열을 공백 단위로 자른 문자열 배열을 이용하여 오름차순 정렬을 한 뒤
	 //    처음과, 가장 끝을 문자열로 형 변환하여 출력. 
	 public static String solution1(String s) {
	        String answer = "";
	        String [] temp = s.split(" ");
	        int [] arr = new int[temp.length];
	        for(int i = 0 ; i < temp.length; i++){
	            arr[i] = Integer.parseInt(temp[i]);
	        }
	        Arrays.sort(arr);
	        answer = Integer.toString(arr[0]) +" " + Integer.toString(arr[arr.length-1]); 
	        return answer;
	 }
}