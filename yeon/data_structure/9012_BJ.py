import sys

## 스택으로 하는 유명한문제 
## ) 는 스택에 입장할 수 없다는걸 파악하면 풀이 끝

def check(plist):
  temp = []
  for p in plist:
    if p == '(':
      temp.append(p)
    else :
    ## ) 가 마주하는건 empty 혹은 ( 이다. 동족은 못만남
      if not temp: return False #empty에 들어오면 false
      else : temp.pop()

    
  return len(temp) == 0

  
N = int(input())

for _ in range(N):
  plist = list(sys.stdin.readline().rstrip())
  if check(plist) : print("YES")
  else: print("NO")



