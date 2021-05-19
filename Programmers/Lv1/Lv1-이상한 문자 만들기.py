"""
[문제 설명]
- 문자열 s는 [ 한 개 이상의 단어 ]로 구성되어 있습니다. 
  각 단어는 [ 하나 이상의 공백문자로 구분 ]되어 있습니다. 
  각 단어의 '짝수번째' 알파벳은 [ 대문자 ]로, 
  '홀수번째' 알파벳은 [ 소문자 ]로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

[ 제한 사항 ]
문자열 전체의 짝/홀수 인덱스가 아니라, [ *** 단어(공백을 기준)별로 ** ] 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

[ 입출력 예 ]
    s	                    return
"try hello world"	   "TrY HeLlO WoRlD"
"""

def solution(s):
    answer = ''
    word_split = s.split(' ') #공백을 기준으로 잘라서 리스트를 만든다
    for word in word_split :
        for i in range(len(word)) :
                answer += word[i].upper() if i % 2 == 0 else word[i].lower()
        answer += ' ' # 앞의 리스트가 끝난 후 공백을 다시 붙여줌.
    return answer[:-1] # 처음부터 마지막 미만까지의 데이터를 반환( 마지막 문자열 뒤에 공백이 있기 때문.)

print(solution("try hello worldb bc"))

print(solution("try hello world"))