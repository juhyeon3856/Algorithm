# 백준 2932 : 표 회전

# 조건
# N*N크기의 board, K번의 이동
# 2 ≤ N ≤ 10000 / 1 ≤ K ≤ 1000
# 필요한 회전 수 구하기
# 행 먼저 회전

# 아이디어
# "N*N == 1억"이므로 그 수의 위치를 이미 알고 있어야 함
# index배열을 만들어서 index[i]에는 i의 일차원 인덱스 값을 넣어둠 -> 바로 접근 가능
# 회전 할 때 마다 해당 행, 열을 업데이트 한다.

# 예상 복잡도
# N * K * 2
# -> 실패1 : 공간복잡도에서 터짐
# 돌리지 않은 것은 작성하지 않는다 전략
# lazy하게 처리
# 예상 복잡도 K * K

N, K = map(int, input().split())

moves = [list(map(int, input().split())) for _ in range(K)]
move_data = [[0, 0, 0, 0] for _ in range(K)]  # k번째 친구가 이동 직전에 어디 있었고, 이동 후에 어디 있었는지

for i in range(K):
    num, tr, tc = moves[i]
    # 초기 사작r, c / 목표 r, c
    sr, sc, tr, tc = (num - 1) // N, (num - 1) % N, tr - 1, tc - 1

    # i-1까지 회전이 반영된 r, c구하기
    for j in range(i):
        pr, pc, ptr, ptc = move_data[j]
        # 행이 같으면 prev c가 변한만큼 함께 변함
        if pr == sr:
            sc = (sc + (ptc - pc) + N) % N
        # 열이 같으면 prev r이 변한만큼 함께 변함
        if ptc == sc:
            sr = (sr + (ptr - pr) + N) % N

    # target r, target c까지 이동 횟수 print
    r_cnt = tr - sr if tr >= sr else tr - sr + N
    c_cnt = tc - sc if tc >= sc else tc - sc + N
    move_data[i] = [sr, sc, tr, tc]
    print(r_cnt + c_cnt)
