N, K = map(int, input().split())
coin = [int(input()) for _ in range(N)]
coin.sort(key=lambda x: -x)  # 역순 정렬

# 입력 완료! 로직 시작
# 아이디어 : 가치가 높은 동전 먼저 사용
ans = 0
for c in coin:
    ans += K // c
    K %= c
print(ans)
