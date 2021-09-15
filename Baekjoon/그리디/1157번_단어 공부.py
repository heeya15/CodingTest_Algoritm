# -*- coding: utf-8 -*-
"""
- 아직 해결 x
"""


n = input().lower()

count = [0] * len(n) 
for i in range(len(n)):
    for j in range(len(n)):
        tmp = n[j]
        if n[i] == tmp:
            count[i] +=1
            
print(count)
print(n[max(count)])