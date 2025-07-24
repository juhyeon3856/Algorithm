flag = '22233344455566677778889999'
st = input()
ans = 0

for s in st:
    ans += int(flag[ord(s) - 65]) + 1

print(ans)