/*
[ 문제 설명 ]
문자열 s의 길이가 4 혹은 6이고, [ 숫자로만 구성돼있는지 확인해주는 함수 ],
solution을 완성하세요.
예를 들어 s가 [ a234 ]이면 False를 리턴하고
[ 1234라면 ] True를 리턴하면 됩니다.

[ 제한 사항 ]
- s는 길이 1 이상, 길이 8 이하인 문자열입니다.
[ 입출력 예 ]
s	    return
a234	false
1234	true
*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
/*
  isdigit 함수를 활용하면 문자열의 [ 문자 숫자인지 ] [ char형인지 ] 판단할 수 있다.
  만약 문자가 [ char 형 이라면 0을 반환 ], char형이 아닌 정수, 실수형이라며 1을 반환한다.
*/
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
	bool answer = true;
	if (strlen(s) == 4 || strlen(s) == 6) { //문자열 길이가 4 또는 6이고 
		for (int i = 0; i < strlen(s); i++) { 
			if (isdigit(s[i]) == 0) {// 문자열 중 하나가 [ 문자로 구성되면 ] 
				answer = false; //거짓을 반환.
				//return answer;
			}
		}
	}
	else   answer = false; // 문자열 길이가 4또는 6이 아니면 거짓.
	//나머지는 문자열 길이가 4또는 6이고, 문자열중 [ 전부 숫자인 경우 ] true 반환 
	return answer;
}
/*
[ 두번째로 해결한 방식. ]
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>


// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
	bool answer = true;
	if(strlen(s) !=4 && strlen(s) !=6) { // 4또는 6이아니면 바로 거짓.
		answer=false;
	}
	for(int i=0; i < strlen(s);i++){
		if(!(s[i]>='0' && s[i]<='9')){ //문자 0에서~ 9사이가 아닌걸로 이루어질경우 false
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