# -*- coding: utf-8 -*-
"""
Created on Wed Apr 21 15:39:41 2021

@author: choon
"""
'''
def solution(n, lost, reserve1):
    count =0
    answer = 0
    cnt = [1] *(n+1)
    cnt[0] = 0
    for i in range(1,n+1):
        if i == lost[0] or i == lost[1]:
            cnt[i] -= 1
        elif i == reserve1[0]:
            cnt[i] += 1
    print(cnt)
    for i in range(0,n+1):
        if cnt[i] == 0:
            if cnt[i-1]>=1 :
                cnt[i] += cnt[i-1]
                count +=1
            elif cnt[i+1] >= 1:
                cnt[i] += cnt [i+1]
                count += 1
        else :
            count +=1 
    answer = count        
    return answer
'''
def solution(n, lost, reserve):
    # set을 이용하여 중복을 제거한다.
    # python에서 set은 집합 자료형을 의미하는데, 
    # 1. 중복을 허용하지 않는다. 2. 순서가 없다. 는 특징을 가지고 있다. 
    # 여기서는 1번의 특징을 이용하여 중복을 제거하였다. 
    #또한, set은 원소끼리 빼기가 가능하기 때문에 중복을 제거하기에 용이하다.


    set_lost = set(lost)-set(reserve) # 집합뺄셈으로 도난 집합을 구함
    set_reserve = set(reserve)-set(lost) # 집합 뺄셈으로 여분 집합을 구함.
    
    # 여분이 있는 학생을 기준으로  확인해
    '''
    그 다음, answer에 이미 체육복을 가진 학생의 수인 
    n - len(lost_n)를 넣고, lost_n을 순회하며 reserve_n에 앞순서, 
    뒷순서에 체육복을 가지고 있는 학생이 있으면 reserve_n에서 삭제하고 
    answer에 1을 늘린다.
    '''
    for i in set_reserve:
       
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    print(set_lost)
    return n-len(set_lost)
    
# 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

#n = int(input()) # 전체 학생의 수

print(solution(5, [2,4], [3]))