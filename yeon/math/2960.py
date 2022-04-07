N , K = map(int,input().split())

nums = list(range(2,N+1))
primes = []

n = 0 # n번째 지움
while True:
  P = nums[0]
  primes.append(P)

  n += 1
  nums.remove(P)
  if n==K: 
    print(P)
    break
    
  if len(nums) == 0: break
  
  i=1
  while P*i <= nums[-1]:
    if P*i in nums:
      n+=1
      nums.remove(P*i)
      if n==K: 
        print(P*i)
        break

    
    i += 1

    
  
