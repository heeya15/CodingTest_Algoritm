package 문자열;
import java.util.*;
import java.io.*;
public class Main_S5_1181_단어정렬  {
	static class Words implements Comparable<Words>{
		String word;	
		public Words(String word) {
			this.word = word;
		}
		@Override
		public int compareTo(Words o) {	
			if(this.word.length() == o.word.length()) { // 단어 길이 비교후 같을 경우 사전순으로 정렬
				return this.word.compareTo(o.word);
			} 
			else return this.word.length() - o.word.length(); // 그 외 단어 길이 순으로 정렬(오름차순).
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 단어의 개수
		Words []  word=  new Words[N];
		// 알파벳 소문자로 이루어진 단어 입력.
		for(int i=0; i< N; i++) {
			word[i] = new Words(br.readLine());
		}
		Arrays.sort(word);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N-1; i++) {
			if(word[i].word.equals(word[i+1].word))continue; // 같은 단어인 경우 무시.
			sb.append(word[i].word).append("\n");			 // 같은 단어가 아니라면 추가.
		}
		sb.append(word[N-1].word).append("\n"); // word 배열의 마지막 단어를 StringBuilder에 추가.
		System.out.println(sb.toString());	    // 출력.
	}
}
