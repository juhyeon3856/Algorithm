TC = int(input())

for tc in range(1, TC + 1):
    # 입력
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    # 전처리
    arr.sort(key=lambda x: (x[1], x[0]))
    ans, end_time = 0, 0

    # 로직
    # 아이디어: 종료시간이 빠른 것 부터 넣는다.
    for s, e in arr:
        if s >= end_time:  # 이전 작업 종료 후면
            ans += 1  # 작업 수행
            end_time = e  # 종료시간 갱신
        # else:   # 이전 작업 종료 전이면
        #     pass    # 해당 작업 수행하지 않음

    # 정답 출력
    print(f"#{tc} {ans}")