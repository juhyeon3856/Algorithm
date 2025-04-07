n=int(input())
if n==1 or n==2 or n==4 or n==7:
    print(-1)
else:
    three=0
    while n%5!=0:
        n=n-3
        three=three+1
    print(n//5+three)