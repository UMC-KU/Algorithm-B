n, k = map(int,input().split())
inputs = list(range(1, n+1))
outputs = list()
head=0
for count in range(1, len(inputs)+1):
  head= (head+(k-1)) % len(inputs)
  outputs.append(inputs[head])
  del inputs[head]

print(f"<{', '.join(map(str,outputs))}>")


##풀이
## 리스트로 풀이했다. 개수만큼 반복하며 나머지연산자로 인덱스를 수학적으로 뽑아보았다
## 원형 linked-list 가 생각나는 문제이긴 했다. 혹은 큐?