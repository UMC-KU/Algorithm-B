import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
q = deque()
for _ in range(N):
  input = sys.stdin.readline().rstrip().split()
  if input[0]=="push" :
    q.append(int(input[1]))
  elif input[0]=="pop":
    if not q: 
      print(-1)
      continue
    print(q.popleft())
  elif input[0]== "size" :
    print(len(q))
  elif input[0]== "empty" :
    if not q: print(1)
    else: print(0)
  elif input[0]== "front" :
    if not q:
      print(-1)
      continue
    print(q[0])
  elif input[0] == "back" :
    if not q:
      print(-1)
      continue
    print(q[-1])

    
    
    
    