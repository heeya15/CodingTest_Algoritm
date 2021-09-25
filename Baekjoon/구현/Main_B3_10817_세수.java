package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B3_10817_세수 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		// 세 개의 정수 주어진다고 하여 3개의 정수형을 담을 배열 초기화.
		int numbers [] = new int[3];
		String line [] = sc.nextLine().split(" ");
		
		for (int i = 0; i < line.length; i++) {
			numbers[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(numbers);
		System.out.println(numbers[1]);
	}

}
