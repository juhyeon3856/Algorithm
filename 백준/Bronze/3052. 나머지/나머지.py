L=[]
q=0
for i in range(10):
    a=int(input())
    L.append(a)
for i in range(10):
    L[i]=L[i]%42
L.sort()
a=L[0]
for i in range(10):
    if a!=L[0]:
        a=L[0]
        q+=1
    L=L[1:]
print(q+1)
        