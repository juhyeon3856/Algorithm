N, R = 9, 3
cards = [list(input().split()) for _ in range(N)]


# [1] 9C3의 조합으로 합 나올 수 있는지 확인

# 합인지 확인하는 코드
def check(t1, t2, t3):  # 모두 같거나 모두 다르면
    return (t1 == t2 and t2 == t3) or (t1 != t2 and t1 != t3 and t2 != t3)


def is_H():
    s1, s2, s3 = cards[nums[0]][0], cards[nums[1]][0], cards[nums[2]][0]
    c1, c2, c3 = cards[nums[0]][1], cards[nums[1]][1], cards[nums[2]][1]
    b1, b2, b3 = cards[nums[0]][2], cards[nums[1]][2], cards[nums[2]][2]
    return check(s1, s2, s3) and check(c1, c2, c3) and check(b1, b2, b3)


# nums = [0, 4, 5]
# is_H()


# 조합
hlst = set()


def combi(depth, start, flag):
    if depth == R:
        if is_H():
            hlst.add(flag)
        return
    for i in range(start, N):
        nums[depth] = i
        combi(depth + 1, i + 1, flag | 1 << i)


nums = [0, 0, 0]
combi(0, 0, 0)

debug = 0

# [2] 플레이어의 입력에 따른 점수 부여
ans = 0
isG = 0
K = int(input())
for _ in range(K):
    nxt = list(input().split())
    if nxt[0] == 'H':
        fflag = (1 << (int(nxt[1]) - 1)) + (1 << (int(nxt[2]) - 1)) + (1 << (int(nxt[3]) - 1))
        if fflag in hlst:  # 합이면
            ans += 1
            hlst.remove(fflag)
        else:
            ans -= 1
    else:
        if hlst:  # 있으면
            ans -= 1
        elif isG:
            ans -= 1
        else:
            ans += 3
            isG = 1

# [3] 점수 출력
print(ans)