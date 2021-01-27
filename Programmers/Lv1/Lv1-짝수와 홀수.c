/*
[ 문제 설명 ]
정수 num이 [ 짝수일 경우 Even을 반환 ]하고 
[ 홀수인 경우 Odd를 반환 ]하는 함수, solution을 완성해주세요.

[ 제한 조건 ]
num은 int 범위의 정수입니다.
0은 짝수입니다.
[ 입출력 예 ]
num	  return
3	  Odd
4     Even
*/


#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int num) {
	// 리턴할 값은 메모리를 동적 할당해주세요
	char* answer = (char*)malloc(sizeof(char));
	if (num % 2 == 0) answer = "Even";
	else answer = "Odd";
	return answer;
}

int main() {
	printf("%s", solution(2));
	system("pause");
	return 0;
}
