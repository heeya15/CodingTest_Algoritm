package 이분탐색;
import java.io.*;
import java.util.*;
/**
 * 모든 요청이 배정될 수 없는 경우에는 [ 특정한 정수 상한액을 계산 ]하여 그 이상인 예산요청에는 
 * 모두 상한액을 배정한다. "상한액 이하의 예산요청에" 대해서는 요청한 금액을 그대로 배정한다.
 * 예를 들어, [ 전체 국가예산이 485이고 ] "4개 지방의 예산요청"이 각각 120, 110, 140, 150이라고 하자.
 * 이 경우, "상한액을 127로" 잡으면, 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 
 * [ 그 합이 484로 가능한 최대 ]가 된다.  
 */
public class Main_S3_2512_예산 {
	static int N;
	static long M, result;
	static int [] num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 정수 N이 주어짐.
		num = new int[N];
		// 예산 요청을 표현하는 N개의 정수 입력.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num); // 오름차순으로 정렬.
		
		M = Long.parseLong(br.readLine());// 국가 총 예산
		long left = 0;
		long right = num[N-1]; //최대 예산 요청으로 설정.
		
		long res = binarySearch(0, right, num);// 왼쪽, 오른쪽 탐색 위치, 배열을 인자로 넘김.
		
		System.out.println(res);
	}
	private static long binarySearch(long left, long right, int [] arr) {
		// 이분탐색은 "0부터" [ 배열의 마지막 가장 큰 값 사이(최대 예산 요청) ]를 "이분 탐색"하면서 찾음.
		while(left <= right) {
			long mid = (left + right) / 2; // 상한 액.
			long sum = 0; // 모든 지방 예산의 합을 저장 받을 변수
			for (int i=0; i< arr.length; i++) {
				// 지방 예산요청이 [ 상한액 보다 크거나 같다면 ]
				if(arr[i] >= mid) sum += mid; // 상한액을 누적으로 더함.
				// 지방 예산요청이 상한액 보다 작다면
				else if ( arr[i] < mid )sum += arr[i]; // 지방 예산을 더함
			}
			// ( 현재 지방 예산의 합이 )총 예산을 초과하면 right를 [ 상한액(mid) - 1로.]
			if(sum > M) right = mid - 1;
			// ( 현재 지방 예산의 합(총 합)이 [ 총 예산보다 작거나 같으면 ] left를 [ 상한액(mid) + 1로 ]
			else {
				left = mid + 1;
				result = Math.max(result,mid); // "총 예산과" 근접하게 되는 "상한선"을 구함.
			}
		}
		return result;
	}
}
