package BOJ;
import java.io.*;
import java.util.*;
public class Main_B2_1264_모음의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int count = 0;
			String line =br.readLine();
			if(line.equals("#")) break;		
			for(int i =0; i< line.length(); i++) {
				char temp = line.charAt(i);
				if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || 
				   temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U' ){
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
