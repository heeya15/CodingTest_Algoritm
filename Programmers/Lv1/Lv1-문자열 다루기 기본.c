/*
[ ���� ���� ]
���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, [ ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ� ],
solution�� �ϼ��ϼ���.
���� ��� s�� [ a234 ]�̸� False�� �����ϰ�
[ 1234��� ] True�� �����ϸ� �˴ϴ�.

[ ���� ���� ]
- s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
[ ����� �� ]
s	    return
a234	false
1234	true
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
/*
  isdigit �Լ��� Ȱ���ϸ� ���ڿ��� [ ���� �������� ] [ char������ ] �Ǵ��� �� �ִ�.
  ���� ���ڰ� [ char �� �̶�� 0�� ��ȯ ], char���� �ƴ� ����, �Ǽ����̶�� 1�� ��ȯ�Ѵ�.
*/
// �Ķ���ͷ� �־����� ���ڿ��� const�� �־����ϴ�. �����Ϸ��� ���ڿ��� �����ؼ� ����ϼ���.
bool solution(const char* s) {
	bool answer = true;
	if (strlen(s) == 4 || strlen(s) == 6) { //���ڿ� ���̰� 4 �Ǵ� 6�̰� 
		for (int i = 0; i < strlen(s); i++) { 
			if (isdigit(s[i]) == 0) {// ���ڿ� �� �ϳ��� [ ���ڷ� �����Ǹ� ] 
				answer = false; //������ ��ȯ.
				//return answer;
			}
		}
	}
	else   answer = false; // ���ڿ� ���̰� 4�Ǵ� 6�� �ƴϸ� ����.
	//�������� ���ڿ� ���̰� 4�Ǵ� 6�̰�, ���ڿ��� [ ���� ������ ��� ] true ��ȯ 
	return answer;
}
/*
[ �ι�°�� �ذ��� ���. ]
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


// �Ķ���ͷ� �־����� ���ڿ��� const�� �־����ϴ�. �����Ϸ��� ���ڿ��� �����ؼ� ����ϼ���.
bool solution(const char* s) {
	bool answer = true;
	if(strlen(s) !=4 && strlen(s) !=6) { // 4�Ǵ� 6�̾ƴϸ� �ٷ� ����.
		answer=false;
	}
	for(int i=0; i < strlen(s);i++){
		if(!(s[i]>='0' && s[i]<='9')){ //���� 0����~ 9���̰� �ƴѰɷ� �̷������� false
			answer =false;
		}
	}
	return answer;
}
*/
int main() {
	char s[] = { "1234" };
	printf("%s\n", solution(s) ? "true" :"false");
	system("pause");
	return 0;
}