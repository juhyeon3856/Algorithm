n=int(input())
L=list(map(int,input().split()))
for i in range(n):
	if i==0:
		a=L[0]
	if a<L[i]:
		a=L[i]
for i in range(n):
	if i==0:
		b=L[0]
	if b>L[i]:
		b=L[i]
		
print(b,a)