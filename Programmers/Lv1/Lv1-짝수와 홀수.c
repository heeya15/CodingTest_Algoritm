/*
[ ���� ���� ]
���� num�� [ ¦���� ��� Even�� ��ȯ ]�ϰ� 
[ Ȧ���� ��� Odd�� ��ȯ ]�ϴ� �Լ�, solution�� �ϼ����ּ���.

[ ���� ���� ]
num�� int ������ �����Դϴ�.
0�� ¦���Դϴ�.
[ ����� �� ]
num	  return
3	  Odd
4     Even
*/


#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

char* solution(int num) {
	// ������ ���� �޸𸮸� ���� �Ҵ����ּ���
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
