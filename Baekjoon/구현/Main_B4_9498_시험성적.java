package BOJ;
import java.io.*;
import java.util.*;
public class Main_B4_9498_시험성적 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jumsu = sc.nextInt();
		if(jumsu >=90 &&jumsu <= 100) {
			System.out.println('A');
		}else if(jumsu >=80 &&jumsu <= 89) {
			System.out.println('B');
		}else if(jumsu >=70 &&jumsu <= 79) {
			System.out.println('C');
		}else if(jumsu >=60 &&jumsu <= 69) {
			System.out.println('D');
		}else {
			System.out.println('F');
		}
	}
}
