st = input().upper()
cnt = [0] * 26

for s in st:
    cnt[ord(s)-65] += 1  # ord('A') == 65

mx = 0
for i in range(26):
    if mx < cnt[i]:
        ans = i
        mx = cnt[i]
    elif mx == cnt[i]:
        ans = -2 # ord('?') = 63

print(chr(ans + 65))