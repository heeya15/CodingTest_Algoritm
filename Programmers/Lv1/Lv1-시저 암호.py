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

# 아직 테스트케이스 부분 통과를 못하였음 -- 추가 해결 방안 생각...
"""


def solution(s, n):
    answer = ''   
    for i in s:  
       temp = 0
       if ord(i)>=ord('a') and ord(i)<ord('z') or ord(i) >=ord('A') and ord(i)< ord('Z') :
          temp = ord(i) + n
          print(temp)
          if temp >ord('z') :
             temp -= 26
          if temp >ord('Z'):
             temp -= 26 
          
          answer += chr(temp)
                   
       if i == ' ':
          answer += ' '
       if i == 'z' or i == 'Z' : # 문제 있는 부분 .
          temp = ord(i)-26 + n
          answer += chr(temp)# a 이전 아스키코드 문자 숫자로 가서 + n 만큼 이동해준다.                   
    return answer

print(solution("a B z", 4))