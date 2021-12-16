package 이분탐색;
import java.io.*;
import java.util.*;
/**
 * A는 B를 먹는다. A는 "자기보다 크기가 작은 먹이만" 먹을 수 있다. 
 * 예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에
 * A가 B를 먹을 수 있는 [ 쌍의 개수는 7가지 ]가 있다. 
 * 8-3, 8-6, 8-1, 
 * 7-3, 7-6, 7-1,
 * 3-1.
 * 두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 [ B보다 큰 쌍이 몇 개나 있는지 ] 구하는 프로그램을 작성하시오.
 *
 */
public class Main_S3_7795_먹을것인가먹힐것인가 {
	static int N,M;
	static int [] A,B;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케 수 입력.
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // A의 수
			M = Integer.parseInt(st.nextToken()); // B의 수
			// 배열 초기화.
			A = new int[N];
			B = new int[M];
			// A의 수 입력
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) A[j] = Integer.parseInt(st.nextToken());
			// B의 수 입력.
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) B[j] = Integer.parseInt(st.nextToken());
			
			// A, B 생명체 둘다 오름차순 정렬.
			Arrays.sort(A);
			Arrays.sort(B);
			int result = 0;
			for (int j = 0; j < N; j++) {
				// B 생명체 배열, 시작, 끝, A의 생명체 숫자 타겟을 인자로 넘겨줌 .
				// "타겟보다" 작은 숫자가 없을 시 [ -1을 리턴하기 때문에 ] +1 해줌. -->0개를 뜻하므로
				// 타겟이 B 생명체에서 0번째 인덱스에 A생명체 보다 "작은 숫자 하나밖에 없으면"
				// 0번째 인덱스를 반환해서, 즉 1개 뿐이므로 +1을 해줘서 --> 숫자의 개수를 구할 수 있다.
				int num = binary_search(B,0, M-1,A[j])+1;
				result += num; // A의 크기가 더큰 쌍의 개수 누적.( A보다 작은 B의 숫자 개수 누적)
			}
			sb.append(result).append("\n");
		}
		// 출력
		System.out.print(sb);
	}
	private static int binary_search(int[] arr, int start, int end, int target) {
		int res = -1; // 타겟보다 작은 숫자가 없으면 -1 리턴.
		while(start<= end) {
			int mid = (start+end) /2;
			if(arr[mid] < target) {
				res = mid;
				start = mid + 1;
			}else end = mid - 1;
		}
		// 오름차순 정렬이 되어있는 배열에서 "타겟보다 작은 인덱스를 알면"
		// 앞에 몇개의 숫자가 있는지 알 수 있다.
		return res; // 타겟보다 작은 인덱스를 리턴.
	}
}
