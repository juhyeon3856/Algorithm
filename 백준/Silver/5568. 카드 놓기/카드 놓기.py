# 시작시간 : 11시 1분
# 종료시간 : 11시 20분
# 소요시간 : 19분
# 디버깅 : set 사용법
# 아이디어 : 순열, 조합, set

# 문제
# n개 카드 중 k개를 뽑아 정렬하는 방법의 수
# 뽑는 방법의 수 -> 10^4
# 정렬하는 방법의 수 -> 4!


def combi(depth, start):
    if depth == K:
        perm(0, "", 0)
        return
    for i in range(start, N):
        card[depth] = lst[i]  # 카드 고르고
        combi(depth + 1, i + 1)
        # card[depth] = '-'     # 카드 지워주고 : 이건 안해도 괜찮음(다음번에 쓸 때 덮어지니까)


def perm(depth, st, flag):
    if depth == K:  # K개 다 배치하면
        if st not in sset:  # 같은 완성본 없으면
            sset.add(st)
            ans[0] += 1
        return
    for i in range(K):
        if flag & 1 << i: continue  # i번째 이미 썼으면
        perm(depth + 1, st + card[i], flag | 1 << i)


N = int(input())
K = int(input())

lst = [input() for _ in range(N)]
card = ['-'] * K  # 선택한 카드 작성하는 곳
sset = set()
ans = [0]
combi(0, 0)
print(ans[0])