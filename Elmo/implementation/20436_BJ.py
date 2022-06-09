import string
import sys
from tokenize import String
input = sys.stdin.readline

left = {'q':(0,2),'w':(1,2),'e':(2,2),'r':(3,2),'t':(4,2),
        'a':(0,1),'s':(1,1),'d':(2,1),'f':(3,1),'g':(4,1),
        'z':(0,0),'x':(1,0),'c':(2,0),'v':(3,0)}

right = {'y':(1,2),'u':(2,2),'i':(3,2),'o':(4,2),'p':(5,2),
         'h':(1,1),'j':(2,1),'k':(3,1),'l':(4,1),
         'b':(0,0),'n':(1,0),'m':(2,0)}

sl, sr = input().strip().split(" ")
str = list(input().strip())

answer = len(str)
for i in range(len(str)):
    if(sl == str[i]):
        continue
    elif(sr == str[i]):
        continue
    elif(str[i] in left):
        x = abs(left[sl][0] - left[str[i]][0])
        y = abs(left[sl][1] - left[str[i]][1])
        sl = str[i]
        answer = answer + x + y
    elif(str[i] in right):
        x = abs(right[sr][0] - right[str[i]][0])
        y = abs(right[sr][1] - right[str[i]][1])
        sr = str[i]
        answer = answer + x + y
print(answer)