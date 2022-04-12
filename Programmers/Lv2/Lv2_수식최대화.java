package Programmers;
import java.io.*;
import java.util.*;
public class Lv2_수식최대화 {
	static char[] prior = {'+', '-', '*'};
	static boolean[] check = new boolean[3];
	static ArrayList<Character> ops = new ArrayList<Character>(); // 연산자 담을 리스트
	public static ArrayList<Long> numbers = new ArrayList<>(); // 숫자 담을 리스트 
	static long answer = 0;
	static char [] temp;
	public static void main(String[] args) {
		System.out.println(solution("50*6-3*2"));
//		System.out.println(solution("100-200*300-500+20"));
	}
	static public long solution(String expression) {
		String num="";
		temp = new char[3];
        for(int i=0;i<expression.length();i++){
        	// 0~ 9 사이 문자인 경우 문자열에 문자를 붙여줌.
            if((int)expression.charAt(i) >= 48 && (int)expression.charAt(i) <= 59){
                num += expression.charAt(i);
            }else{ // 특수 기호를 만났다면
            	numbers.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        numbers.add(Long.parseLong(num));
        for(char number : ops)System.out.println(number);
        per(0, temp);
        return answer;
    }
	// 순열
	static public void per(int depth, char[] temp) {
		if(depth == 3) {
			 System.out.println("hi"+Arrays.toString(temp));
			 ArrayList<Long> copy_Numbers = new ArrayList<>(numbers); // ArrayList 원본을 인쇄 함
	         ArrayList<Character> copy_Ops = new ArrayList<Character>(ops); // ArrayList 원본을 인쇄 함
//	         System.out.println(copy_Ops.size());
		     for(int i=0;i<temp.length;i++){
		        for(int j=0; j< copy_Ops.size(); j++){
		            if(temp[i] == copy_Ops.get(j)){
		                Long res = 0L;
		                System.out.println("j는: "+j);
		                switch (temp[i]) {
		                // 현재 해당 좌표와, 해당 오른쪽 좌표 값을 제거 시켜 계산
		                	case'+' : {	 	  
		                		res= copy_Numbers.remove(j) + copy_Numbers.remove(j);
		                		break;
		                	}
		                	case'-' : {	           
		                		res= copy_Numbers.remove(j) - copy_Numbers.remove(j);
		                		break;
		                	}
		                	case'*' : {	   
		                		res= copy_Numbers.remove(j) * copy_Numbers.remove(j);
		                		break;
		                	} 	
		                }
		                copy_Numbers.add(j, res);
		                copy_Ops.remove(j);
		                j--; //전체 적으로 ArrayList의 크기가 하나 줄어서 -1로 하나씩 사이즈를 땡겨준다.
		            }
		        }
		     }
		     // [ 우승 상금은 ] 연산자 우선 순위 조합으로 계산한 수식의 결과 값에 절대값을 취한 것이 가장 큰 값이 된다.
		     answer = Math.max(answer, Math.abs(copy_Numbers.get(0)));
		     return;
		}
		
		for(int i =0; i < 3; i++) {
			if(!check[i]) {
				check[i] = true;
				temp[depth] = prior[i];
				per(depth+1, temp);
				check[i] = false;
			}
		}
	}
}
