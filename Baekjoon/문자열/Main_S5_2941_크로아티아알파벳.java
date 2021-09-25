package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S5_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		/** contains 라이브러리 사용하여 푼 방법.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] word = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String line = br.readLine();
		for (int i = 0; i < word.length; i++) {
			if(line.contains(word[i])) line = line.replace(word[i]," ");	
		}
		System.out.println(line.length());
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = br.readLine();
		int count = 0;
		int right =0; // 현재 단어 한칸 오른쪽 단어 체크용 변수.
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) == 'c') {
				right = i + 1;
				if (right < words.length() && (words.charAt(right) == '=' | words.charAt(right) == '-')) {
					i++;
				}
			} else if (words.charAt(i) == 'd') {
				right = i + 1;
				if (right < words.length() && words.charAt(right) == 'z') {
					if (right+1 < words.length() && words.charAt(right+1) == '=') {
						i+=2;
					}
				}
				else if (right < words.length() && words.charAt(right) == '-') {
					i++;
				}

			} else if (words.charAt(i) == 'l') {
				right = i + 1;
				if (right < words.length() && words.charAt(right) == 'j') {
					i++;

				}
			} else if (words.charAt(i) == 's') {
				right = i + 1;
				if (right < words.length() && words.charAt(right) == '=') {
					i++;

				}
			} else if (words.charAt(i) == 'z') {
				right = i + 1;
				if (right < words.length() && words.charAt(right) == '=') {
					i++;

				}
			} else if (words.charAt(i) == 'n') {
				right = i + 1;
				// 문자열 길이 넘지 않으며, nj 단어인 경우.
				if (right < words.length() && words.charAt(right) == 'j') {
					i++;
				}
			} // else if end
			count++; // 해당 목록에 없는 알파벳인 경우 세어줌.
		} // for end
		System.out.println(count);
	}
}
