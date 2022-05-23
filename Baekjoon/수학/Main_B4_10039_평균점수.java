package BOJ;
import java.io.*;
import java.util.*;
public class Main_B4_10039_평균점수 {

	public static void main(String[] args) {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			if(num < 40 ) sum += 40;
			else sum += num;
		}
		System.out.println(sum/5);
	}
}
