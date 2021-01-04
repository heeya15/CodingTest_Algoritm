/*
[ 문제 설명 ]
- 자연수 N이 주어지면, [ N의 각 자릿수의 합을 구해 ]서 
  return 하는 solution 함수를 만들어 주세요.
 예를들어 N = 123이면 [ 1 + 2 + 3 = 6을 return 하면 ] 됩니다.

[ 제한사항 ]
N의 범위 : 100,000,000 이하의 자연수
[ 입출력 예 ]
N	  answer
123	  6
987	   24
[ 입출력 예 설명 ]
입출력 예 #2
9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

/*
1. 123 %10 = 3 , n = 12  answer = 3
2. 12 % 10 = 2,  n = 1   answer = 5
3.  1 % 10 = 1,  n = 0 , answer = 6 , while 문 조건 = 0으로 빠져나옴. 
*/
int solution(int n) {
	int answer = 0;
	while (n) {
		answer = answer + (n % 10); //나머지값. 
		n = n / 10; //몫
	}
	return answer;
}

int main() {
	int n = 123;
	printf("%d\n", solution(n));
	system("pause");
	return 0;
}