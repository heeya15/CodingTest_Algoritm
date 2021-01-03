/*
< 문제 설명 >
정수를 담고 있는 배열 [ arr의 평균값을 return하는 함수 ], solution을 완성해보세요.

< 제한사항 >
arr은 길이 1 이상, 100 이하인 배열입니다.
arr의 원소는 - 10, 000 이상 10, 000 이하인 정수입니다.

< 입출력 예 >
 arr	      return
[1,2,3,4]	  2.5
[5,5]	      5
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
double solution(int arr[], size_t arr_len) {
	double answer = 0;
	for (int i = 0; i < arr_len; i++) {
		answer = answer+ arr[i];
		printf("%.1f\n", answer);
	}
	answer = answer / arr_len;

	return answer;
}

int main() {
	int arr[] = { 1,2,3,4 };
		// 배열의 크기를 구할 때는
		// 전체 공간을 요소의 크기로 나눠줌 --> sizeof(arr)/sizeof(int) 
	printf("답은: %.1f\n", solution(arr, sizeof(arr)/sizeof(int))); 
	system("pause");// 콘솔창 자동 종료 방지
	return 0;
}