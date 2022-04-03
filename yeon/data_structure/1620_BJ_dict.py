import sys
n,m =  map(int,input().split())

data_dict = dict()
q_list = list()
for index in range(n+m):
  if index < n:
    data_dict[index+1] = sys.stdin.readline().rstrip()
  else:
    q_list.append(sys.stdin.readline().rstrip())

reverse_data_dict = dict(map(reversed,data_dict.items()))

for index in range(m):
  if(q_list[index].isdigit()):
    print(data_dict[int(q_list[index])])

  else:
    print(reverse_data_dict[q_list[index]])
  