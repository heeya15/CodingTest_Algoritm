package Programmers;
import java.util.*;

public class Lv2_가장큰수 {
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2 };
		System.out.println(solution(numbers)); // 답 : "6210"
		int[] numbers1 = {3, 30, 34, 5, 9 };
		System.out.println(solution(numbers1)); // 답 : "9534330"
		int[] numbers2 = {0,0,0,0 };
		System.out.println(solution(numbers2)); // 답 : "0"
	}

	public static String solution(int[] numbers) {
        String answer = "";
        String [] str = new String[numbers.length];
        for(int i =0; i < numbers.length ; i++){
            str[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
          //  6+10인 610과 10+6인 106을 비교하면 610이 더 크므로 자리를 바꿀 필요가 없다. 
           public int compare(String o1, String o2){
               return (o2+o1).compareTo(o1+o2); // 내림 차순 정렬.
           } 
        });
      
       
        int count = 0;
        for(String num : str){
            if(num.equals("0")) count++;
            answer += num;  
        } 
        // 모두 0으로 입력이 되는 경우 위와 같은 로직으로는 0000.... 과 같이 0이 지속될 수 있으므로
        // 0의 개수가 배열 길이와 같다면  0을 반환하는 예외처리를 추가해줌
        if(count == numbers.length) return "0";
        return answer;
    }
}