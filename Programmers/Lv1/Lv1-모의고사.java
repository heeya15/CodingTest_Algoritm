package 구현;
import java.util.*;
import java.lang.*;
/**
- 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록
- answers의 매개변수로 넘어온 배열 길이가 first 보다 길어질 경우를 생각 
  ex) first 길이 5인대 answers 의 길이가 6일경우면  answers 길이만큼 반복 비교시 에러가 나기때문에
      i % first.length() 를 해주게 되면 --> first 5번째 원소와, answers 5번째 원소 비교하고,  
      answers 6번째 원소와, 다시 first 6 % 5 = 1 번째 원소를 비교해주면 
      answers의 길이가 first보다 길어지는 경우를 해결 가능.
**/
public class Lv1_모의고사 {
	public static void main(String[] args) {
		int [] num = {1,2,3,4,5};
		System.out.println(solution(num)); // [1] 출력
		int [] num1 = {1,3,2,4,2}; 
		System.out.println(solution(num1));// [1,2,3] 출력
	}
	public static ArrayList<Integer> solution(int[] answers) {
        String first = "12345";      // 1번 수포자가 찍는 방식 패턴
        String second = "21232425";  // 2번 수포자가 찍는 방식 패턴
        String third = "3311224455"; // 3번 수포자가 찍는 방식 패턴
        int [] answer = new int[3];
        for(int i = 0 ; i < answers.length; i++){
            int num1 = first.charAt(i % first.length()) - '0';
            int num2 = second.charAt(i % second.length()) - '0';
            int num3 = third.charAt(i % third.length()) - '0';
            if(answers[i] == num1) answer[0]++;
            if(answers[i] == num2) answer[1]++;
            if(answers[i] == num3) answer[2]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max =  Math.max(answer[0], Math.max(answer[1],answer[2]));
       
        if(max == answer[0]) list.add(1);
        if(max == answer[1]) list.add(2);
        if(max == answer[2]) list.add(3);
        Collections.sort(list);
        return list;
    }
}
