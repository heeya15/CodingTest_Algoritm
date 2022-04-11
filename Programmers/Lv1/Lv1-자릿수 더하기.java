package Programmers;
/*
1. 123 %10 = 3 , n = 12  answer = 3
2. 12 % 10 = 2,  n = 1   answer = 5
3.  1 % 10 = 1,  n = 0 , answer = 6 , while 문 조건 != 0으로 빠져나옴. 
*/
public class Lv1_자릿수더하기 {
	public static void main(String[] args) {
		System.out.println(solution(123));
	}	
	static public int solution(int n) {
        int answer = 0;
        while(n!=0){
            answer = answer + (n%10);
            n = n /10;
        }
        return answer;
    }
}
