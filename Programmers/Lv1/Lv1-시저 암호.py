"""
[ 문제 설명 ]
- 어떤 문장의 각 알파벳을 [ 일정한 거리만큼 밀어서 ] 
  다른 알파벳으로 바꾸는 [ 암호화 방식 ]을 시저 암호라고 합니다.
 예를 들어 "AB"는 [ 1만큼 ] 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
 "z"는 1만큼 밀면 "a"가 됩니다.

- [문자열] s와 [거리] n을 입력받아 [s를 n만큼 민 암호문]을 만드는 함수, solution을 완성해 보세요.

입출력 예
s	       n	result
"AB"	   1	"BC"
"z"	       1	"a"
"a B z"	   4	"e F d"

- ord, chr 함수는 생각을 하였지만, isupper, islower 함수 생각을 못함.
 그리고, %26을 해주는 이유 ? z 또는 Z의 범위를 넘어가지 않도록 하기 위해

"""

def solution(s, n):
    s = list(s) 
    print(ord('Z'))
    for i in range(len(s)): 
        if s[i].isupper(): # 대문자인 경우
            s[i]=chr((ord(s[i])-ord('A')+ n)%26 + ord('A')) 
        elif s[i].islower(): # 소문자인 경우 
            s[i]=chr((ord(s[i])-ord('a')+ n)%26 + ord('a')) 
    print(s)    
    return ''.join(s)



print(solution("a x y K", 4))