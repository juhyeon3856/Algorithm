str = input()
answer = 0

temp = ""
for s in str:
    temp += s;
    if(s in {"=", '-'}):
        answer+=1
        temp=""
    elif(temp in {"lj", "nj"}):
        answer+=1
        temp=""
    elif(temp not in {"c", "d", "l", "n", "s", "z", "dz"}):
        answer += 1
        temp=temp[1:]
        if(temp != "" and temp not in {"c", "d", "l", "n", "s", "z", "dz"}):
           answer += 1
           temp=temp[1:]

print(answer + len(temp))