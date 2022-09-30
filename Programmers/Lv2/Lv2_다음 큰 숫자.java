package Programmers;

import java.util.*;

/**
( 문제 풀이 )
1. 먼저 n에 대한 2진수로 변환 후 1의 개수를 세어준다.
2. while 무한 루프 안에서 n을 1씩 증가시키면서 증가시킨 n을 2진수로 변환 후 1의 개수를 세어주고 
     처음 매개변수 n과 1씩 증가시킨 n에 대해 2진수로  변환 했을 때의 1의 갯수가 같으면 
   1씩 증가시킨 n을 answer에 대입하여 return 시켜줌
 **/
public class Lv2_다음큰숫자 {
	public static void main(String[] args) {
		System.out.println(solution(78)); // 답 : 83
		System.out.println(solution(15)); // 답 : 23
	}

	public static int solution(int n) {
        int answer = 0;
        String binary_num = Integer.toBinaryString(n);
        int one_count = 0;
        for(int i = 0; i < binary_num.length(); i++){
            char temp = binary_num.charAt(i);
            if(temp =='1')one_count++;
        }
        int count = 0;
        while(true){
            n++;
            String next_binary_num = Integer.toBinaryString(n);
            for(int i = 0; i < next_binary_num.length(); i++){
                char temp = next_binary_num.charAt(i);
                if(temp =='1')count++;
            }
            if(count == one_count) {
                answer = n;
                break;
            }
            count = 0;
        }
        return answer;
	}
}