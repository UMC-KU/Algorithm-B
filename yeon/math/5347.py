import sys, math

def lcm(m,n):
  return m*n // math.gcd(m,n) 

N = int(input())

for _ in range(N):
  M,N = map(int, sys.stdin.readline().rstrip().split() )
  print(lcm(M,N))