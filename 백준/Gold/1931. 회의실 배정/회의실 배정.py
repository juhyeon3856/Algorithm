# 입력
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
arr.sort(key=lambda x: (x[1], x[0]))
end_time = [-1]  # 회의실마다 끝나는 시간 저장
ans = 0

# 로직
# 아이디어: 회의가 빨리 끝나는 것 부터 먼저 확인
for s, e in arr:
    if end_time[0] <= s:  # 회의실에 들어갈 수 있으면
        end_time[0] = e
        ans += 1

# 정답 출력
print(ans)