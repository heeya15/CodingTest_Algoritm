package 이분탐색;

import java.io.*;
import java.util.*;
public class Main_S4_10816_숫자카드2 {
	static int N, M;
	static int card[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 상근이의 숫자 카드의 개수
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 숫자 카드에 적혀있는 정수가 주어짐.
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순으로 정렬.
		Arrays.sort(card);
	
		M = Integer.parseInt(br.readLine()); // 정수의 개수 M개 입력
		st = new StringTokenizer(br.readLine(), " ");
		// 입력된 정수에서 [ 상근이가 가지고 있는 숫자 카드가 몇개있는지 ] "이진 탐색" 하는 부분. 
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 하한 : 찾고자 하는 값이 처음으로 나타나는 인덱스.
			// 상한 : 찾고자 하는 값 가장 마지막에 있는 인덱스.
			int low = lower_bound_binarySearch(card, 0, N-1, num);
			int high = upper_bound_binarySearch(card, 0, N-1, num);
			// 찾지 못했다면 -1 이 리턴되어서 개수 0으로 출력.
			if(low == -1 || high == -1) sb.append("0").append(" ");
			// 찾았다면 해당 상한 - 하한 으로 한 뒤 +1 을 해줘야 해당 숫자의 개수를 구할 수 있음.
			// 예를들어) 5 5 5 가 인덱스 3 ~ 5 까지 있다고 가정하면
			// 총 3개가 있는건대 5 - 3 으로 하면 2가 되어서 +1 해줌.
			else sb.append((high-low) + 1).append(" ");
		}
		System.out.print(sb);
	}

	static int lower_bound_binarySearch(int arr[], int start, int end, int target) {
		int ans = -1; 
		while(start <= end) {
			int mid = (start+end) /2 ;
			if(arr[mid]==target) { // 해당 타겟을 찾을 시
				ans = mid;  // 해당 타겟 인덱스 저장.
				end = mid-1;// 끝 좌표를 찾은 인덱스 -1 해줌.
			}
			// 해당 타겟과 같지 않으면서,타겟보다 중간 지점 숫자가 크다면 끝에 탐색 위치를 중간 탐색 위치에서 -1 해줌.
			else if(arr[mid] > target) end = mid-1;
			else start = mid+1;
		}
		return ans;
	}

	static int upper_bound_binarySearch(int arr[], int start, int end, int target) {
		int ans = -1;
		while(start <= end) {
			int mid = (start+end) /2 ;
			if(arr[mid]==target) { // 해당 찾을 숫자를 찾으면
				ans = mid; // 해당 인덱스 ans 에 저장.
				start = mid+1; // 찾은 인덱스 +1 한 것을 -> 탐색 시작점에 저장.
			}
			// 타겟보다 중간 지점 숫자가 크다면 끝에 탐색 위치를 중간 탐색 위치에서 -1 해줌.
			else if(arr[mid] > target) end = mid-1; 
			// 타겟보다 중간 지점 숫자가 더 작다면 시작 탐색 위치를 중간 탐색 위치에서 +1 해줌.
			else start = mid+1;
		}
		return ans;
	}
}
