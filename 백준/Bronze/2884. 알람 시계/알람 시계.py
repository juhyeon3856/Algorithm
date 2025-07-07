a=input().split()
a[1]=int(a[1])-45
if int(a[1])<0:
    if int(a[0])==0: print('23',60+int(a[1]))
    else: print((int(a[0])-1),(60+int(a[1])))
else:
    print(a[0],a[1])