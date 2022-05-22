import sys

input = sys.stdin.readline

n, m = map(int, input().split())
icecream = [[False for _ in range(n)] for _ in range(n)]
for i in range(m):
    i1, i2 = map(int, input().split())
    icecream[i1 - 1][i2 - 1] = True
    icecream[i2 - 1][i1 - 1] = True

result = 0

# 선택할 아이스크림 i,j,k
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            if not icecream[i][j] and not icecream[i][k] and not icecream[j][k]:
                result += 1

print(result)