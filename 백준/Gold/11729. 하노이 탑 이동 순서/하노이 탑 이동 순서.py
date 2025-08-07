# 시작시간 : 2시 18분
# 종료시간 : 2시 30분
# 제출횟수 : 1회

# 아이디어:
# s에서 e로 n개를 이동시킬 때
# n-1개를 s에서 m(비어있는 칸)으로 n-1개 이동시킨 후(재귀 호출)
# s에서 e로 가장 아래 것을 이동(실제 이동)
# 그 후 다시 m에서 e로 n-1개 호출(재귀 호출)

def hanoi(s, e, m, n):  # s에서 e로 n개 옮기겠다
    if n == 0:
        return
    cnt[0] += 1
    hanoi(s, m, e, n - 1)
    ans.append(f"{s} {e}")
    hanoi(m, e, s, n - 1)


N = int(input())
# 1에서 3으로 2를 temp 삼아서 N개 옮기겠다
ans = []  # 출력대신 저장해둠
cnt = [0]  # 이동 횟수 cnt
hanoi(1, 3, 2, N)

print(cnt[0])
print(*ans, sep="\n")
