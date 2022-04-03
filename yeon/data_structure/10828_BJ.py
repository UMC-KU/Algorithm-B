import sys
N = int(input())
result = []
#commands = ["push","pop","size","empty","top"]
for _ in range(N):
  input1 = sys.stdin.readline().rstrip().split()
  command = input1[0]
  if(len(input1)>1):
    value = int(input1[1])


  if command == "push":
    result.append(value)
  elif command == "pop" :
    if(len(result)==0):
      print(-1)
      continue
    print(result.pop())
  elif command == "size":
    print(len(result))
  elif command == "empty":
#    print((lambda size: not (result == 0))(len(result)) )
    if(len(result)==0):print(1)
    else: print(0)
  elif command == "top" :
    if(len(result)==0):
      print(-1)
      continue
    print(result[len(result)-1])


