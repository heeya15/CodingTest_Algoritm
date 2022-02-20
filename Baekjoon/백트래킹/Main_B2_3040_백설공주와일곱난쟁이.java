package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
- 매일 매일 일곱 난쟁이는 광산으로 일을 하러 간다. 
- 난쟁이가 일을 하는 동안 백설공주는 그들을 위해 저녁 식사를 준비한다. 백설공주는 의자 일곱개, 접시 일곱개, 나이프 일곱개를 준비한다.
   어느 날 광산에서 아홉 난쟁이가 돌아왔다. (왜 그리고 어떻게 아홉 난쟁이가 돌아왔는지는 아무도 모른다) 
- 아홉 난쟁이는 각각 자신이 백설공주의 일곱 난쟁이라고 우기고 있다.
- 백설공주는 이런 일이 생길 것을 대비해서, 난쟁이가 쓰고 다니는 모자에 [ 100보다 작은 양의 정수 ]를 적어 놓았다.
    사실 백설 공주는 공주가 되기 전에 매우 유명한 수학자였다. 따라서, 일곱 난쟁이의 모자에 쓰여 있는 [ 숫자의 합이 100이 되도록 적어 놓았다. ]
- 아홉 난쟁이의 모자에 쓰여 있는 수가 주어졌을 때, 일곱 난쟁이를 찾는 프로그램을 작성하시오. (아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)
 */
public class Main_B2_3040_백설공주와일곱난쟁이 {
	static int n=9, r = 7;
	static StringBuilder sb = new StringBuilder();
	static int [] numbers, capnum;
	static boolean [] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		capnum = new int[n];
		numbers = new int[r];
		// 아홉 난쟁이의 모자에 쓰여 있는 수 입력.
		for (int i = 0; i < n; i++) capnum[i] = Integer.parseInt(br.readLine());		
		comb(0,0);
		System.out.println(sb);
	}
	private static void comb(int start, int depth) {
		if(depth == r) { // 기저 조건
			int sum = 0; 
			for (int i = 0; i < r; i++) {
				if(sum > 100) return;
				sum += numbers[i];
			}
			// 7곱 난쟁이의 모자에 적힌 수의 합이 100인 경우 한줄에 하나씩 출력하기 위해 StringBuilder에 저장.
			if(sum==100) for (int i = 0; i < r; i++) sb.append(numbers[i]).append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			numbers[depth] = capnum[i];
			comb(i+1, depth+1);
		}
	}
}
