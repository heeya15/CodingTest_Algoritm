# -*- coding: utf-8 -*-
"""
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, 
solution을 완성하세요. 
예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.

입출력 예
s	return
a234	false
1234	true
"""

'''
아래 solution 함수는.
- 주어진 문자열이 [ 숫자로 되어 있는지를 검사 ]하는데에는 
- 흔히 문자열의 메소드인 isdigit()을 사용
- 길이가 4 또는 6이 아니거나, 문자열이 숫자가 아닌경우 False 그외는 True를 반환한다. 
'''
def solution(s):
    answer = True 
    if (len(s) != 4 and len(s) != 6) or s.isdigit() == False:
      answer = False
    return answer

def solution1(s):
    return s.isdigit() and (len(s) == 4 or len(s) == 6)

s = "123a";
#print(int(s))
print(solution(s))
