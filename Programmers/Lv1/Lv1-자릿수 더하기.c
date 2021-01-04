/*
[ ���� ���� ]
- �ڿ��� N�� �־�����, [ N�� �� �ڸ����� ���� ���� ]�� 
  return �ϴ� solution �Լ��� ����� �ּ���.
 ������� N = 123�̸� [ 1 + 2 + 3 = 6�� return �ϸ� ] �˴ϴ�.

[ ���ѻ��� ]
N�� ���� : 100,000,000 ������ �ڿ���
[ ����� �� ]
N	  answer
123	  6
987	   24
[ ����� �� ���� ]
����� �� #2
9 + 8 + 7 = 24�̹Ƿ� 24�� return �ϸ� �˴ϴ�.
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

/*
1. 123 %10 = 3 , n = 12  answer = 3
2. 12 % 10 = 2,  n = 1   answer = 5
3.  1 % 10 = 1,  n = 0 , answer = 6 , while �� ���� = 0���� ��������. 
*/
int solution(int n) {
	int answer = 0;
	while (n) {
		answer = answer + (n % 10); //��������. 
		n = n / 10; //��
	}
	return answer;
}

int main() {
	int n = 123;
	printf("%d\n", solution(n));
	system("pause");
	return 0;
}