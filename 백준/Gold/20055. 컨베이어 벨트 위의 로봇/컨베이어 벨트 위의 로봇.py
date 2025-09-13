# 입력
N, K = map(int, input().split())
lst = list(map(int, input().split()))

# 이동 : 가장 먼저 벨트에 올라간 로봇부터
M = 2 * N
si, ei = 0, N - 1
box = [0] * M

ans = 0

while K > 0:
    # 회전한다.
    si = (si - 1) % M
    ei = (ei - 1) % M

    if box[ei]:
        box[ei] -= 1  # 내리는 지점

    # 이동한다.
    for i in range(N):
        if box[(ei - i) % M]:
            if box[(ei - i + 1) % M]:  # 다음칸 있으면
                continue
            if lst[(ei - i + 1) % M] == 0:  # 내구도 0이면
                continue
                
            box[(ei - i) % M] -= 1  # 기존박스 빼기
            box[(ei - i + 1) % M] += 1 # 박스 추가
            lst[(ei - i + 1) % M] -= 1

            if (ei - i + 1) % M == ei:  # 도착지점이면
                box[(ei - i + 1) % M] -= 1  # 내리기

            if lst[(ei - i + 1) % M] == 0:
                K -= 1

    # 로봇 올린다.
    if lst[si]:  # 시작지점 내구도 남아있으면
        box[si] += 1
        lst[si] -= 1
        if lst[si] == 0:
            K -= 1

    # 0개수...(앞에서 하게될듯)
    ans += 1

print(ans)