from collections import deque

N = int(input())

nums = list(map(lambda x: x+1,range(N)))
#nums = [x for x in range(1,n+1)]
nums = deque(nums)


while(len(nums) >1):
  ## que 로 안하고 스택(리스트) 로 pop 두번했더니 시간초과 나옴. 큐와 리스트의 성능차이
  nums.popleft()

  nums.append(nums.popleft())

print(nums[0])
  