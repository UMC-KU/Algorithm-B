import sys
def checkPrimeNum(n):
  if n == 1 : return False
  elif n == 2 : return True
  elif n == 4 : return False  
  for i in range(2,int(n/2)):
    if n/i == int(n/i):

      return False
  return True


N = int(input())
inputs = list(map(int, sys.stdin.readline().rstrip().split()))
count = 0
for input in inputs:
  if checkPrimeNum(input): count+=1

print(count)