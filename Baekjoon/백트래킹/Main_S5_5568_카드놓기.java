package BOJ;
import java.io.*;
import java.util.*;
public class Main_S5_5568_카드놓기 {
	static int n, k, result;
	static int [] numbers,inputs;
	static LinkedHashSet<String> set;
	static boolean [] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 초기화.
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		set = new LinkedHashSet<String>();  // 중복된 값을 자동으로 제거해 줌.
		inputs = new int[n];
		isSelected = new boolean[n];
		numbers = new int[k];
		// 카드에 적혀있는 수 입력 받기.
		for(int i=0; i< n ; i++) inputs[i] = Integer.parseInt(br.readLine());
		
		per(0); // 순열 사용.
	
		System.out.println(set.size()); // set의 사이즈, 즉 상근이가 만들 수 있는 정수의 개수를 출력.
	}
	private static void per(int depth) {
		if(depth == k) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k; i++) sb.append(numbers[i]).append("");	
			set.add(sb.toString());// 중복값이 있을경우 안 넣음.
			return;
		}	
		for(int i=0; i < n ; i++) {	
			if(!isSelected[i]) { // 해당 i 번째 카드를 사용하지 않았을 경우.
				isSelected[i] = true; 
				numbers[depth] = inputs[i];
				per(depth+1);	
				isSelected[i] = false; // [ 다음 순열을 뽑기 위해 ]서 i는 사용 중이 아님을 표시. -- 다른 순열을 뽑기 위해서.
			}
		}
	}
}
