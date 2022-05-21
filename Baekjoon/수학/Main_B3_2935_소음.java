package BOJ;

import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main_B3_2935_소음 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine());
		String oper = br.readLine();
		BigInteger B = new BigInteger(br.readLine());
		if(oper.equals("+")) System.out.println(A.add(B));
		else System.out.println(A.multiply(B));
	}
}
