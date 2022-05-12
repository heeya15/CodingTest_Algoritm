package BOJ;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;
public class Main_B5_10757_큰수A_plus_B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BigInteger A =new BigInteger(st.nextToken());
		BigInteger B =new BigInteger(st.nextToken());
		System.out.println(A.add(B));
	}
}
