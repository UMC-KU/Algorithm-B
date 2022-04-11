a, b = map(list,input().split())

for i in range(len(a)):
  if a[i].isdigit():
    a[i] = int(a[i])
  else:
    a[i] = 10 + ord(a[i]) - ord('a')
for i in range(len(b)):
  if b[i].isdigit():
    b[i] = int(b[i])
  else:
    b[i] = 10 + ord(b[i]) - ord('a')



def getSolution(A,B):
  global a,b
  X1 = 0
  X2 = 0
  for i in range(1,len(a)+1):
    X1 += a[-i] * (A ** (i-1)) 
  for i in range(1,len(b)+1):
    X2 += b[-i] * (B ** (i-1))
  return X1 == X2

  
answer = []




for i in range(max(a)+1,37):
  for j in range(max(b)+1,37):
    if getSolution(i,j):
      answer.append([i,j])
      
for ans in answer:
  if ans[0] == ans[1]:
    answer.remove(ans)      

    
if not answer : print("Impossible")
elif len(answer) > 1: print("Multiple")
else: 
  Xa=0
  for i in range(1,len(a)+1):
    Xa += a[-i] * (answer[0][0] ** (i-1))   
  print(Xa,answer[0][0],answer[0][1])



