n=int(input())
for i in range(n):
	j=i+1
	L=input().split()
	print('Case #',end='')
	print(j,end='')
	print(': ',end='')
	print(int(L[0])+int(L[1]))