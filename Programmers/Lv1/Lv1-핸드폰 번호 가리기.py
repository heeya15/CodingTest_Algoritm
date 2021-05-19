"""
[ 문제 설명 ]
- 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 [ 고객들의 전화번호의 일부를 가립 ]니다.

- 전화번호가 [ 문자열 phone_number로 주어졌을 때 ], 
  전화번호의 [ 뒷 4자리를 제외한 ] '나머지 숫자를 전부 '*'으로 가린 
  문자열을 리턴'하는 함수, solution을 완성해주세요.
  
  [ 입출력 예 ]
phone_number	          return
"01033334444"	       "*******4444"
"027778888"	           "*****8888"
"""


def solution(phone_number):
    answer = '' # 빈 문자열을 만든다.
    for i in range(len(phone_number[:-4])): # 뒤에 4자리를 제외한 범위
        answer += "*" # 빈 문자열 answer에 * 을 추가해주고
    for i in phone_number[-4:]: # phone_number 리스트에서 [ 뒤에 4번째부터 마지막까지 ]
        answer += i # answer 에 넣어준다.
    return answer





print(solution("01033334444"))
print(solution("4444"))