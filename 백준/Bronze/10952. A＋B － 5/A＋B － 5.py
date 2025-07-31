L=[1,1]
while int(L[0])!=0 and int(L[1])!=0:
    L=input().split()
    if int(L[0])==0 and int(L[1])==0:
        break
    else:
        print(int(L[0])+int(L[1]))