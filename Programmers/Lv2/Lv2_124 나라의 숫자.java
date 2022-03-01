package Programmers;

public class Lv2_124나라의숫자 {
	/** 
    124 나라에는 0이 없다는 것!. - > 즉 3으로 나눈 나머지가 0일 경우 4로 변환하여 저장해 주면 됨.
    n을 3으로 나눈 나머지를 계속해서 가장 뒤에 붙여 쌓어 나가고, (n - 1을) 해줌 
    ex) n = 10
    (1) 10 % 3 = 1 --> '1'
    (2) n = (10 -1) /3 = 3
    (3) 3 % 3 = 0  --> '4'
        답: 즉 41이 됨. 
        
    ex) n = 7
     1) n % 3 = 1
        n = n / 3 = 2

	 2) n % 3 = 2
	    n = n /3 = 0
         답 : 21
	 **/
   public static String solution(int n) {
      // 나머지 연산으로 나온 숫자를 인덱스로 하는 124 나라의 숫자를 나타내는 배열 초기 선언.
       String[] number = {"4", "1", "2"};
	   String answer = ""; // (바로 이전에 n을 3으로 나눈 나머지 숫자 값을 124 나라의 숫자 값으로 저장.)
       while(n > 0){  
    	   // answer 앞에 n을 3으로 나눈 나머지 숫자를 붙여 124 나라에서 사용하는 숫자로 바꾼 값으로 갱신.
           answer = number[n % 3] + answer; 
           n = (n-1) /3 ; // (n-1)에 3을 나눈 '몫'을 n에 저장.
       }  
       return answer;
   }
   /** 다른 방법 풀이. 무조건 n-1을 해서 3을 나눈 몫을 n으로 다시 저장하는 것이 아닌
   	   3으로 나누어 떨어질 때만 해주는 방법
	    ex) n = 6
	    1) n % 3 = 0  --> 4 로 변환 됨. 
	 	   n = n / 3 = 1 --> 위에서 n이 3으로 나누어 떨어지기 때문에  
	 	                     n -1 을 해서 "n = 5 를 3으로 나눈 몫"은 < 1이 됨. >
	 	   
		2) n % 3 = 1
		   n = n /3 = 0
		     답 : 14
    **/
   public static String solution2(int n) {
      // 나머지 연산으로 나온 숫자를 인덱스로 하는 124 나라의 숫자를 나타내는 배열 초기 선언.
       String[] number = {"4", "1", "2"};
	   String answer = ""; // (바로 이전에 n을 3으로 나눈 나머지 숫자 값을 124 나라의 숫자 값으로 저장.)
      
     
      while(n > 0){  
	     // answer 앞에 n을 3으로 나눈 나머지 숫자를 붙여 124 나라에서 사용하는 숫자로 바꾼 값으로 갱신.
	     answer = number[n % 3] + answer; 
	     if( n % 3 == 0  ) n --; // n 이 3으로 나누어 떨어지면 -1 을 해줌.
	     n = n /3 ; 
      }
       
       return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(10));  // 답 : 41
		System.out.println(solution2(10));  // 답 : 41	
	}
}
