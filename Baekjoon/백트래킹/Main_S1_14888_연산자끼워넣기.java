package BOJ;
import java.io.*;
import java.util.*;

public class Main_S1_14888_연산자끼워넣기 {
	static char [] op = {'+','-','*','/'};
	static ArrayList<Long> numbers = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
	static boolean [] isSelected ;
	static char [] temp;
	static int count;
	static long min = Integer.MAX_VALUE;
	static long max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			numbers.add(Long.parseLong(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine()," ");
		count = 0;
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int gop = Integer.parseInt(st.nextToken());
		int nanop = Integer.parseInt(st.nextToken());
		for (int i = 0; i < plus; i++) {
			ops.add('+');
			count++;
		}
		for (int i = 0; i < minus; i++) {
			ops.add('-');
			count++;
		}
		for (int i = 0; i < gop; i++) {
			ops.add('*');
			count++;
		}
		for (int i = 0; i < nanop; i++) {
			ops.add('/');
			count++;
		}

		isSelected = new boolean[count];
		temp = new char[count];
		per(0,temp);
		System.out.println(max);
		System.out.println(min);
	}
	private static void per(int depth, char[] temp) {
		if (depth == count) {	
			 ArrayList<Long> copy_numbers = new ArrayList<>(numbers);
			 long result = 0;
			 for (int i = 0; i < temp.length; i++) {
				int idx = i+1;
				/**
				 * [ 흐름 ] 
				 * 3 4 5 숫자가 있음. 앞에서 부터 계산 
				 * 3 + 4 = 7 ;
				 * 3 4 7( idx + 1 ) 5 -> 앞에 두개 숫자 계산한 것을 list에 추가했기 때문에  
				 * 기존 맨 앞의 숫자 3을 제거 시켜줌으로 원래 ArrayList 사이즈로 만들어 줌.
				 * 4 7 5 가 ArrayList에 있는 상태. -> 현재 i 는 1번째 인덱스를 가르킴으로 1번째 인덱스 숫자의 값의 7을 의미.
				 * 7  * 5(idx) = 35
				 * 4 7 5 35 에서  i =1 번째 인덱스 숫자 삭제 
				 * 4 5 35 가 ArrayList에 남아 있음. 결과 적으로 35 가 max 값이 됨.  
				 * 
				 * --> min을 구하는 과정도 위와 같음.
				 */

				result = cal(copy_numbers.get(i) , copy_numbers.get(idx),temp[i]);
				copy_numbers.add(idx+1, result); 
				copy_numbers.remove(i);
//				System.out.println(copy_numbers);
			}
		     max = Math.max(max,result);
		     min = Math.min(min,result);
		     return;		
		}
		
		for (int i = 0; i < count; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				temp[depth] = ops.get(i);
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
	            case '/':
	                result = a / b;
	                break;
	        }
	        return result;
	}
}
