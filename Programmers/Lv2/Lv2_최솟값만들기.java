package Programmers;

import java.util.*;
import java.lang.*;
/**
 * (처음 생각)
 * - 순열 또는 DFS를 통하여 완전 탐색을 해야하지 않을까 라고 생각..
 * - A에서 0번째 인덱스를 선택했다면, B에서 0번째 인덱스를 선택하면 안 된다고 이해했지만, 
 * - 예시를 설명하는 부분을 보면[  A와 B 배열 모두 첫 번째 숫자를 선택 ]했기 때문에 잘못 이해했다는 것을 깨달았다.
 * 
 * ( 정말 햇갈렸던 부분 ) 
 * 예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면

    A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
    A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
    A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
    - 위 지문 때문에 "두번째 숫자, 세번째 숫자 4를 뽑아 곱하여 더합니다"를  
    - 보고 순간 선택했던 인덱스를 선택하면 안된다 -> 라고 생각...
    
 * ( 중요한 점 )
 * '한 번 선택한 숫자는 다시 사용할 수 없다'
 * (A배열에서의 최솟값 * B배열에서의 최댓값)을 수행하면 최솟값을 만들 수 있을 것 같다고 생각
 */
public class Lv2_최솟값만들기 {
	public static void main(String[] args) {
//		int [] A = {1,4,2};
//		int [] B = {5, 4, 4};
//		
//		System.out.println(solution(A, B)); // 29
		
		int [] A = {1, 2};
		int [] B = {3, 4};
		
		System.out.println(solution(A, B)); // 10
	}

	public static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		// A는 오름차순, B는 내림차순으로 예시 처럼 계산.
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[(A.length - i) - 1];
		}
		return answer;
	}
}
