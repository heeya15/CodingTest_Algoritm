package 문자열;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
class Number implements Comparable<Number>{
	String number, number_english;
	public Number(String number, String number_english) {
		super();
		this.number = number;
		this.number_english = number_english;
	}
	@Override
	public int compareTo(Number o) { // 영어 사전순으로 정렬하기 위해 사용.
		return this.number_english.compareTo(o.number_english);		
	}	
}
// 수학, 문자열, 정렬 알고리즘 분류 문제.
public class Main_S4_1755_숫자놀이 {
	// 각 정수 하나씩 해당하는 숫자 영어 배열 선언.
	static String[] eng_change = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight","nine"};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
// 		 M과 N 입력. 8, 28 or  37, 58 
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Number> list = new ArrayList<>();
		for (int i = M; i <= N; i++) { // M~ N이하 숫자를 문자열로 저장받아.
			String num = i+"";
			sb = new StringBuilder();
			int cnt = 1;
			for (int j = 0, size = num.length(); j < size; j++) { // 입력된 숫자 길이 만큼
				int temp = num.charAt(j)-'0'; 		 // 정수를 숫자 하나씩 읽어줌.
				if(cnt > 1)sb.append(" "); 			// 길이가 1 이상이면 공백 추가 시켜줌.
				sb.append(eng_change[temp]);		// 해당하는 숫자를 영어로 바꿔서 Stringbuilder에 추가.
				cnt++; 								//정수 숫자 하나씩 길이를 세어줌.
			}
			list.add(new Number(num,sb.toString())); // 리스트에 정수와, 해당 정수를 영어로 읽는 문자열 넣기.   
		}
		Collections.sort(list); // 영어 사전순으로 정렬 수행.
		sb = new StringBuilder();
//		결과 출력.
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i).number + " "); 	 // 정수를 하나씩 들고와서 읽음.
			if((i+1) % 10 == 0) sb.append("\n"); // 10개가 출력되면 줄 바꿈 해준다.
		}
		System.out.println(sb);
	}
}
