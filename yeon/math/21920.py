import math, sys


N = int(input())

pool = map(int, sys.stdin.readline().rstrip().split())
X = int(input())
coPrimes = []
for number in pool:
  if math.gcd(number, X) == 1:
    coPrimes.append(number)


print( sum(coPrimes) / len(coPrimes) )