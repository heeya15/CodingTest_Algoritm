package 이분탐색;
import java.io.*;
import java.util.*;
/**
 * 먼저 제자들에게 N개의 원소를 가진 [ 배열A를 ] 주고, 
 * A의 원소들이 오름차순으로 정렬된 배열B를 만들게 한다. 그다음 M개의 질문을 한다. 각 질문에는 정수 D가 주어진다. 
 * 제자들은 주어진 정수D가 B에서 가장 먼저 등장한 위치를 출력하면 된다.
 * 단, D가 B에 존재하지 않는 경우에는 -1를 출력한다. 
 * Sort 마스터의 자리를 너무나도 물려받고 싶은 창국이를 위해 지훈이의 문제를 풀 수 있는 프로그램을 만들어 주자.
 */
public class Main_S4_20551_Sort마스터배지훈의후계자 {
	static int N, M;
	static int [] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // 원소의 개수
		M = Integer.parseInt(st.nextToken()); // 질문의 개수
		// 1. N개의 원소를 가진 A배열 생성
		A = new int[N];
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());
		Arrays.sort(A); //2. A이 원소들이 오름차순으로 정렬된 배열 B가 된 것.
		
		// 3. M개의 질문을 한다.
		for (int i = 0; i < M; i++) {
	    // 4. D가 B에서 처음으로 등장한 인덱스 위치를 이분탐색으로 얻어냄
			int D = Integer.parseInt(br.readLine());
			int result = binarySearch(A, 0, N-1, D);
			sb.append(result).append("\n");
		}
		// 5.출력
		System.out.println(sb);
	}
	static int binarySearch(int [] arr, int left, int right , int target) {
		int res = -1;
		while(left <= right) {
			int mid = (left + right) /2;
			if(arr[mid] == target) { // 해당 타겟을 찾을경우 
				res = mid;        // 현재 해당 인덱스 위치로 저장.
				right = mid - 1;  // 오른쪽 끝에 범위를 [ 현재 탐색 위치(MID) -1 로 ] 지정
			}	
			if(arr[mid] > target) right = mid -1; // 타겟보다 탐색한 데이터의 값이 크다면
			if(arr[mid] < target) left = mid +1;  // 타겟보다 탐색한 데이터 값이 작다면
		}
		return res; // 존재하면 해당 인덱스 위치, 존재 하지 않으면 -1 리턴.
	}
}
