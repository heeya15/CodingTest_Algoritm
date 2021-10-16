package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 백트래킹, 조합론
public class Main_S2_6603_로또 {
	static int first_num = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();
	static int [] numbers ;
	static int [] inputs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(first_num != 0) {		
			String[] line = br.readLine().split(" ");
			int size = line.length;
			//System.out.println(size);
			first_num = Integer.parseInt(line[0]); // 첫번째 수를 따로 저장, 해당 수의 개수만큼 골라 집합을 만들려고 해서.
			numbers = new int [first_num];		   // 뽑은 집합에 대한 로또번호를 저장받을 배열 선언.
			inputs = new int[first_num];   		   // "집합 S에 포함되는 수"를 저장받을 배열 변수 선언.
			int index =0;
			for (int i = 1; i < size; i++) {
				inputs[index++] = Integer.parseInt(line[i]); // 입력받은 수를 집합 s에 포함시키게 저장.
			}
			comb(0,0); // 독일 로또의 경우의 수를 구하도록 "조합" 사용
			sb.append("\n"); // 테스트 케이스가 끝날때 마다 빈줄 하나 출력.
		}
		System.out.println(sb);// 최종 출력.
	}
	private static void comb(int lev, int start) {
		if(lev == 6) { // 6개를 골랐을 경우.
			for (int i = 0; i < lev; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		//고르는 모든 방법을 재귀적으로 호출.
		for (int i = start; i < first_num; i++) {
			numbers[lev] = inputs[i];
			comb(lev+1, i+1);
		}
	}
}	
