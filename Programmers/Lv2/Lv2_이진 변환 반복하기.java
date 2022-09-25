package Programmers;

import java.util.*;
/**
 * ( 문제풀이 )
 * 1. 리턴할 answer 배열의 크기를 2로 선언 -> 이진 변환의 횟수와, 변환 과정에서 [ 제거된 모든 0의 개수 ]를 각 배열에 담기 위해
 * 2. 문자열 s의 길이가 1보다 클경우 까지 반복하여 돈다. -> s의 길이가 1이 될때까지 계속해서 반복한다는 뜻
 *    -> 여기서 이진변환을할 x의 길이를 저장할 변수 x_count를 0으로 초기화한다.
 * 3. 해당 s의 문자열 길이만큼 반복문을 돌면서 s에서 첫 문자 부터 0인지 0이 아닌지 판단
 *    0이면 제거한다는 의미로 answer[1]에 1씩 누적
 *    아닐경우 x의 길이를 표현하는 (x_count) 변수를 증가시켜준다.
 * 4. Integer.toBinaryString()함수의 인자로 x_count를 넣어줌으로 이진법으로 표기한다.
 *    이진법으로 표기한 것을 s 문자열에 초기값으로 넣어준다.
 * 5. 그 후 answer[0]에 이진 변환 횟수 1을 증가시켜준다.
 * 6. 최종 answer을 return 시켜주면 끝
**/
public class Lv2_이진변환반복하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("110010101001")));  // 답 : [3,8]
		System.out.println(Arrays.toString(solution2("110010101001"))); 
	}
	public static int[] solution(String s) {
        int[] answer = new int[2];  // 이진 변환의 횟수와, 변환 과정에서 [ 제거된 모든 0의 개수 ]를 각 배열에 담는다.
        while(s.length() > 1){ //s가 1일 될때까지 계속해서 반복
            int x_count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') answer[1]++; // 변환 과정에서 제거된 0의 개수 누적
                else x_count++;  // 1의 개수 -> 즉 1의 개수의 길이를 구하는 용도의 변수 -> c를 의미함
            }
            s = Integer.toBinaryString(x_count); //0을 제거하고 남은 1의 개수를 2진법으로 표현한다.
            answer[0]++; // 이진 변환의 횟수 누적
        }
        return answer;
	}
	public static int[] solution2(String s) {
        int[] answer = new int[2];  // 이진 변환의 횟수와, 변환 과정에서 [ 제거된 모든 0의 개수 ]를 각 배열에 담는다.
        int temp = 0;
        while(!s.equals("1")){
        	answer[1] += s.length();
        	s = s.replace("0", "");
        	temp = s.length();
            s = Integer.toBinaryString(temp); //0을 제거하고 남은 1의 개수를 2진법으로 표현한다.
            answer[0]++; // 이진 변환의 횟수 누적
            answer[1] -= temp;
        }
        return answer;
	}
}