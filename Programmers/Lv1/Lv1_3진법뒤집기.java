package Programmers;
import java.util.*;
/**
 * 자연수 n이 매개변수로 주어집니다. 
 * n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 * n (10진법)	    n (3진법)	       앞뒤 반전(3진법)	10진법으로 표현
     45	         1200	        0021	         7
 *
 */
public class Lv1_3진법뒤집기 {
	public static void main(String[] args) {
		System.out.println(solution(45)); // 답 : 7
		System.out.println(solution(125));// 답 : 229
	}

	public static int solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        // 3으로 나눈 나머지가 3진법의 으로 표시될 숫자.
        while(n!=0){
            list.add(n%3);
            n /= 3;
        }
        
        int size = list.size()-1;
        for(int i =0; i<list.size(); i++) answer += list.get(i) * Math.pow(3,size--);
        return answer;
    }
}