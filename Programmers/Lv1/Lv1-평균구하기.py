# -*- coding: utf-8 -*-
"""
< 문제 설명 >
[정수를 담고 있는 배열] arr의 [평균값]을 return하는 함수, solution을 완성해보세요.

< 제한사항 >
arr은 길이 1 이상, 100 이하인 배열입니다.
arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.

< 입출력 예 >
arr	          return
[1,2,3,4]	   2.5
[5,5]           5
"""

'''
아래 solution 함수는.
arr 배열의 길이를 구하고, 배열을 각 인덱스 값을 각각 answer 변수에 누적으로 더한다.
그후, 배열의 전체합/ 배열 길이를 통해 평균값을 구합니다.

'''
def solution(arr):
    answer = 0
    length = len(arr)
    for a in range(length):
        answer += arr[a]
    answer /= length
    return answer
'''
- 아래방법은 sum 함수 생각을 못했다. 좀 더 생각을하고 풀자..
- sum 함수를 통해 배열의 모든 요소를 다더한다. 
  그후 배열 길이로 나누어서 평균값을 구함.  
'''
def solution1(arr):
    answer=0
    answer= sum(arr)/len(arr)
    return answer

x_list = [1, 2, 3, 4]
y_list = [5,5]
k = [0,-1,-2]
print(solution(x_list))
print(solution1(x_list))
