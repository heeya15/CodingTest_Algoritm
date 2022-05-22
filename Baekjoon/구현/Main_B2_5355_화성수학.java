package BOJ;

import java.util.*;
import java.io.*;

public class Main_B2_5355_화성수학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String [] temp = br.readLine().split(" ");
			double total = Double.parseDouble(temp[0]);
			for(int j =1; j< temp.length; j++) {
				if(temp[j].equals("@")) total *=3;
				if(temp[j].equals("%")) total +=5;
				if(temp[j].equals("#")) total -=7;
			}
			System.out.format("%.2f\n", total);
		}
	}
}
