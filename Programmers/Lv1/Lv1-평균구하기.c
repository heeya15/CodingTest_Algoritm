/*
< ���� ���� >
������ ��� �ִ� �迭 [ arr�� ��հ��� return�ϴ� �Լ� ], solution�� �ϼ��غ�����.

< ���ѻ��� >
arr�� ���� 1 �̻�, 100 ������ �迭�Դϴ�.
arr�� ���Ҵ� - 10, 000 �̻� 10, 000 ������ �����Դϴ�.

< ����� �� >
 arr	      return
[1,2,3,4]	  2.5
[5,5]	      5
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len�� �迭 arr�� �����Դϴ�.
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
		// �迭�� ũ�⸦ ���� ����
		// ��ü ������ ����� ũ��� ������ --> sizeof(arr)/sizeof(int) 
	printf("����: %.1f\n", solution(arr, sizeof(arr)/sizeof(int))); 
	system("pause");// �ܼ�â �ڵ� ���� ����
	return 0;
}