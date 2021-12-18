package 이분탐색;
import java.util.*;
import java.io.*;
public class Main_S4_10815_숫자카드 {
	static int N,M;
	static int card[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 숫자 카드에 적혀있는 정수가 주어짐.
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순 정렬 먼저.
		Arrays.sort(card);
		M = Integer.parseInt(br.readLine()); // 정수 M개 개수
		
		// 이 수가 적혀있는 숫자 카드를 [ 상근이가 가지고 있는지 아닌지 ]를 구하는 프로그램 작성.
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(card, 0, N-1, num)).append(" ");
		}
		// 출력
		System.out.print(sb);
	}
	static int binarySearch(int[] arr, int start, int end, int target) {
		// 시작 탐색이 종료 탐색보다 작거나 같을경우 동안 반복.
		while(start<=end) {
			int mid = (start + end) /2; // 중간 기준 구하기.
			// 내가 찾고자  하는 target 값을 찾았다면 1을 리턴.
			if(arr[mid] == target)return 1; 
			// 타겟보다 중간 지점 숫자가 크다면 끝에 탐색 위치를 중간 탐색 위치에서 -1 해줌.
			if(arr[mid] > target) end = mid-1;
			// 타겟보다 중간 지점 숫자가 더 작다면 시작 탐색 위치를 중간 탐색 위치에서 +1 해줌.
			else start = mid +1;
		}
		return 0;
	}
}
