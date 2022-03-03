package Programmers;
import java.util.*;
/** 
  가로 : W, 세로 : H --> 직각삼각형 2개로 나누어짐
  사용할 수 있는 정사각형 개수를 구해라
  "전체 개수"에서 사용 불가능한 사각형을 빼자 
  (핵심)
  1. 그림을 보고 규칙을 찾아보자.
  2. 최대 공약수를 떠올려라 
  불가능한 사각형 : w + h - 최대공약수
ex) 2*3인(최대공약수 1인) 경우 사용 불가능한 사각형 -> 2 + 3 - 1(최대 공약수) = 4로 구해진다.
ex) 4*6인(최대공약수 2인) 경우 사용 불가능한 사각형 -> 4 + 6 - 2(최대 공약수) = 8로 구해진다.
ex) 6*9인(최대공약수 3인) 경우 사용 불가능한 사각형 -> 6 + 9 - 3(최대 공약수) = 12로 구해진다.
x(총 길이 : 8)는 2씩, y(총 길이 : 12)는 3씩 증가하는 패턴을 찾을 수 있음.
8 <- 2
12 <- 3 으로 되는 것을 보고 둘 다 4로 나눈 값인 것을 발견할 수 있고 이 것이 [ 두 수의 최대 공약수 ]로 알 수 있다.
**/
public class Lv2_멀쩡한사각형 {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}
	public static long solution(int w, int h) {
        long answer = 1;
        long x = w;
        long y = h;
        long gcd = gcd(x,y);
        answer = ( x * y ) - (x + y - gcd);
        return answer;
    }
    
    public static long gcd(long x, long y){ //최대 공약수 알고리즘 - 호재법을 이용하여 직접 gcd 구현
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
