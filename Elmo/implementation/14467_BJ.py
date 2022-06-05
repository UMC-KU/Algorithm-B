import sys
input = sys.stdin.readline

n = int(input())
cow_map = {}
answer = 0
for i in range(n):
    i1, i2 =  map(int, input().split())
    if(i1 in cow_map and cow_map[i1] != i2):
        cow_map[i1] = i2
        answer += 1
    else: cow_map[i1] = i2
print(answer)