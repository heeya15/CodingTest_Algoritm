package 해시;
import java.util.*;
import java.io.*;

/**
 * 카드는 [ 하나의 모양 ]과 [ 하나의 숫자를 ] 가진다고 가정 
 * 실제 그림 대신 문자로 대체 --> P,K,H, T에 해당. 
 * 숫자는 1~13 에 해당하는 정수. 
 * T는 모양, XY는 숫자에 해당 완벽한 카드 한 세트는 52개로 이루어져 있다. (4 (모양)x 13(숫자))
 * 즉, P01 카드를 가지고 있다면 [ 나머지 12개의 숫자의 카드를 ] 가지고 있지 않은것.
 * 
 * [문제를 해결하면서 겪은 문제상황 ]
 * 기존에 Hash에 key를 P,K,H,T로 두니 
 * H02 중 H의 KEY가 다음 H10 의 H의 키로 변경되며 값도 변경되어서 -> 즉 해당 키의 값을 덮어버려서
 * 처음 읽은 카드 H02와 맨 마지막에 읽은 H02 카드가 똑같은 카드가 존재하는지 비교를 하지 못했다.
 * 그래서, "H02" 자체를 "키"로 두고, "02"를 "값"으로 두어 해결했다.
 */
public class Main_S5_11507_카드셋트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
//		[ 카드 모양의 값과 숫자를 더한 값을 Key ], [ 카드 숫자에 해당하는 것 ]을 문자열 값으로 HashMap에 저장시킨다.
		HashMap<String, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int Card_count[] = new int[4]; // 해당 모양의 [ 카드의 개수를 ] 해당 인덱스에 누적 시켜주는 용도로 사용.
//		문자열을 읽어 얼마나 많은 카드를 잃어버렸는지 세면 된다.
		for (int i = 0, size = line.length(); i < size; i = i + 3) {
			Character temp[] = new Character[3]; 
			int count = 0;
			// P01 이런식의 문자를 각각 temp 배열의 인덱스에 값을 넣어줌.
			for (int j = i; j < i + 3; j++) {
				temp[count++] = line.charAt(j);
			}
			int key_num = 0;
			switch (temp[0]) { // 카드 모양에 해당하는 문자를 CASE에 따라 숫자로 변경 처리 부분.
			case 'P':
				key_num = 0;
				break;
			case 'K':
				key_num = 1;
				break;
			case 'H':
				key_num = 2;
				break;
			case 'T':
				key_num = 3;
				break;
			}
			// 카드 모양을 key에 저장.
			String shape = temp[0].toString();
			// 카드의 숫자에 해당하는 값을 문자열 변수 s에 저장.
			String s = temp[1].toString() + temp[2].toString();
			String key = shape +s; // P01, P02 ... 이런식의 KEY를 HashMap의 key로 설정할 용도.
			// 키가 null 이 아니라면
			if (map.get(key) != null) {
				// 이미 키에 해당하는 값(카드의 숫자가) 방금 읽은 카드의  값 숫자와 같다면 GRESKA를 출력하고 종료. 
				if (map.get(key).contains(s)) {
					System.out.print("GRESKA");
					return;
				}
			}	
			map.put(key, s);      // 카드의 모양과 숫자 값을 더한 것을 키로, 숫자  문자열을 값으로 HashMap에 넣어줌.
			Card_count[key_num]++;// 카드의 모양 키의 값에 해당하는 인덱스 개수를 증가시켜줌.
		}
		// (하나의 모양 카드의 총 숫자 13) - (해당 모양의 카드를 가지고 있는 숫자)
		for (int i = 0; i < 4; i++) {
			sb.append(13 - Card_count[i]).append(" ");
		}
		// 출력.
		System.out.println(sb);
	}
}
