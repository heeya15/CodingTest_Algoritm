package 이분탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//M 개의 수들중 A안에 존재하는지 알아내면 된다.
public class Main_S4_1920_수찾기 {
	static int N,M ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] A = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i <M; i++) {
			sb.append(binarySearchRecur(A, 0, N-1, Integer.parseInt(st.nextToken())));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// key에 해당하는 원소의 인덱스 리턴.
	static int binarySearchRecur(int[] arr, int start, int end, int target) {
		if (start > end)
			return 0;
		int mid = (start + end) >> 1; // 중간 위치

		if (arr[mid] == target)return 1;
		// 중간점의 값이 찾고자 하는 경우의 타겟보다 더 큰 경우.
		else if (arr[mid] > target)
			return binarySearchRecur(arr, start, mid - 1, target);
		// 중간점의 값이 찾고자 하는 타겟보다 "더 작은 경우"
		else
			return binarySearchRecur(arr, mid + 1, end, target);
	}
}
