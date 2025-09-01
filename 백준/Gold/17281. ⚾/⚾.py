# 19시 18분

# 시간복잡도 8! * 50 * 4

# 입력
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

# 전처리
nums = [100] * 9
nums[3] = 0
visited = [0] * 9
visited[0] = 1

# debug_cnt = [0]

score_table = [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4]
score = 0


# 함수들
def perm(depth):
    if depth == 9:
        do_game()
        # print(nums)
        # debug_cnt[0] += 1
        return

    if depth == 3:
        perm(depth + 1)
        return

    for i in range(9):
        if visited[i]:
            continue
        visited[i] = 1
        nums[depth] = i
        perm(depth + 1)
        visited[i] = 0


def do_game():
    global score

    ci, cs = -1, 0  # 현재 선수, 현재 점수

    for i in range(N):  # i 번째 이닝
        if cs + (N-i)*24 <= score:  # 예영님 푸르닝
            return

        out = 0
        runner = 0  # (D) 이닝 끝나면 러너도 리셋

        while out < 3:
            ci = (ci + 1) % 9
            rs = arr[i][nums[ci]]
            if rs == 0:  # 아웃이면
                out += 1
                continue
            run_result = (runner << rs) + (1 << (rs - 1))  # 뛴 사람 갱신
            cs += score_table[run_result >> 3]  # 홈 들어온사람 더해주고
            # cs += bin(run_result >> 3).count('1')  # 홈 들어온사람 더해주고
            runner = run_result & 7  # 1, 2, 3루에 있는 사람들만 체크

    if cs > score:
        #     print(cs)
        #     print(nums)
        #     print()
        score = cs


# 로직
perm(0)
# print(debug_cnt[0])  # 예상 출력 8! = 40320

# 정답출력
print(score)
