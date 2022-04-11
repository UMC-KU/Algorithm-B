def isPrime(n):
  if n == 1: return False
  elif n == 2 : return True
  for i in range(2,int(n/2)+1):
    if n % i == 0: return False
  return True


M=int(input())
N=int(input())

pool = list(range(M,N+1))
prime = []

for number in pool:
  if isPrime(number): prime.append(number)

if not prime: 
  print(-1)
else:
  print(sum(prime))
  print(min(prime))
