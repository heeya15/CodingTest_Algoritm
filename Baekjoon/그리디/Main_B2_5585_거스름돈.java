package 그리디;

import java.util.Scanner;

public class Main_B2_5585_거스름돈{
	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		int num =sc.nextInt();
		int gipe [] = {500,100,50,10,5,1};
		int price = 1000- num;
		int count = 0, temp = 0;
		for (int i = 0; i < gipe.length; i++) {
			temp= price % gipe[i];
			count += price / gipe[i];
			price = temp;
			if (price ==0)break;
		}
		System.out.println(count);
	}
}

