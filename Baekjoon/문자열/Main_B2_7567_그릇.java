package 문자열;
import java.io.*;
public class Main_B2_7567_그릇 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] arr = br.readLine().toCharArray();
		int last_height = 10;
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(temp != arr[i]) {
				last_height += 10;
				temp = arr[i];
			}else last_height +=5;
		}
		System.out.println(last_height);
	}
}
