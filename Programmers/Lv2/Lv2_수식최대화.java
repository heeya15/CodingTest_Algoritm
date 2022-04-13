package Programmers;
import java.io.*;
import java.util.*;
public class Lv2_수식최대화 {
	static char [] op = {'+','-', '*'};
	static boolean[] isSelected = new boolean[3];
	static ArrayList<Long> numbers = new ArrayList<>();// 숫자 담을 리스트 
	static ArrayList<Character> ops = new ArrayList<>();// 연산자 담을 리스트
	static long answer = 0;
	static char [] temp;
	public static void main(String[] args) {
//		System.out.println(solution("50*6-3*2"));
		System.out.println(solution("100-200*300-500+20"));
	}
	static public long solution(String expression) {
		String number ="";	
        for(int i=0;i<expression.length();i++){
        	// 0~ 9 사이 문자인 경우 문자열에 문자를 붙여줌.
            if((int)expression.charAt(i) >= 48 && (int)expression.charAt(i) <= 59){
            	 number += expression.charAt(i);
            }else{ // 특수 기호를 만났다면
            	numbers.add(Long.parseLong(number));
            	number = "";
                ops.add(expression.charAt(i));
            }
        }
        numbers.add(Long.parseLong(number));
        temp = new char[3];
        per(0, temp);
        return answer;
    }
	// 순열
	static public void per(int depth, char[] temp) {
		if(depth == 3) {  // 3가지 연산자를 조합 골랐을 경우
			 System.out.println("hi"+Arrays.toString(temp));
			 ArrayList<Long> copy_numbers = new ArrayList<>(numbers); // ArrayList 원본을 인쇄 함
	         ArrayList<Character> copy_ops = new ArrayList<Character>(ops); // ArrayList 원본을 인쇄 함
//	         System.out.println(copy_Ops.size());
		     for(int i=0;i<temp.length;i++){
		        for(int j=0; j< copy_ops.size(); j++){
		            if(temp[i] == copy_ops.get(j)){
		            	long num = cal(copy_numbers.remove(j),copy_numbers.remove(j), temp[i]);
		            	copy_numbers.add(j, num);
		                copy_ops.remove(j);
		                j--; //전체 적으로 ArrayList의 크기가 하나 줄어서 -1로 하나씩 사이즈를 땡겨준다.
		            }
		        }
		     }
		     // [ 우승 상금은 ] 연산자 우선 순위 조합으로 계산한 수식의 결과 값에 절대값을 취한 것이 가장 큰 값이 된다.
		     answer = Math.max(answer, Math.abs(copy_numbers.get(0)));
		     return;
		}
		
		for(int i =0; i < 3; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				temp[depth] = op[i];
				per(depth+1, temp);
				isSelected[i] = false;
			}
		}
	}
	 public static long cal(long a, long b , char op){
	        long result = 0;
	        switch(op){
	            case '+':
	                result = a + b;
	                break;
	            case '-':
	                result = a - b;
	                break;
	            case '*':
	                result = a * b;
	                break;
	        }
	        return result;
	    }
}
