# -*- coding: utf-8 -*-
"""
< 문제 설명 >
정수 num이 [ 짝수 ]일 경우 Even을 반환하고 
[ 홀수인 ] 경우 Odd를 반환하는 함수, solution을 완성해주세요.

제한 조건
num은 int 범위의 정수입니다.
0은 짝수입니다.

< 입출력 예 >
num	return
3	Odd
4	Even
"""

'''
삼항 표현식 문법
- true_value if condition else false_value
- [ if조건식의 condition값이 True이면 ] true_value를 반환하고 
- False이면 false_value를 반환한다.
즉, num을 나눈 나머지값이 0인 [ 짝수 ]인경우 'Even을 반환'
아닌경우 'Odd' 반환 
'''
def solution(num):
    answer = ''
    answer = 'Even' if (num % 2)==0 else 'Odd'
    return answer

print(solution(3))

