
"""
- 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 [ 같은 행, 같은 열의 값을 ] 서로 더한 결과가 됩니다. 
- 2개의 행렬 arr1과 arr2를 입력받아, [ 행렬 덧셈의 결과를 반환 ]하는 함수, solution을 완성해주세요.

입출력 예
arr1	           arr2       	return
[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
[[1],[2]]	   [[3],[4]]	   [[4],[6]]
"""

def solution(arr1, arr2):
    answer = []  
    tmp = []
    for i in range(len(arr1)):
        for x in range(len(arr1[i])):
            tmp.append(arr1[i][x] + arr2[i][x])
        answer.append(tmp)
        tmp = [] # 배열 초기화 . -- 기존의 같은행, 같은열 더한 값이 들어간 list 초기화.
    return answer
# 다른 방법 . - 각 리스트 같은 위치의 원소 끼리 더한 값을 누적하여 결과를 반환. 
def solution1(arr1, arr2):
    for i in range(len(arr1)) :
        for j in range(len(arr1[i])):
            arr1[i][j] += arr2[i][j] 
    return arr1
#print(solution([[1],[2]],[[3],[4]]))
print(solution1([[1,2],[2,3]],[[3,4],[5,6]]))
