def checkPrimeNum(n):
  if n==1 : return False
  elif n==2 : return True
  elif n==4 : return False  
  for i in range(2, int(n/2)+1):
    if(n % i == 0): return False
  return True

def checkPelindrom(n):
  digitNum = len(str(n))
  for i in range(int(digitNum/2)):
    if list(str(n))[i] != list(str(n))[-i-1]: return False
  return True

N = int(input())
while True:
  if checkPelindrom(N) and checkPrimeNum(N): break
  N += 1

print(N)