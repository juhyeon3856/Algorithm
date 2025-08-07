# 시작시간 : 2시 8분
# 종료시간 : 2시 18뷴
# 제출횟수 : 1회


def cnt(sr, sc, llen):  # 시작 r, c 및 한변 길이
    if is_same(sr, sc, llen):  # 모두 같은 색이면
        return  # 그만
    nlen = llen // 2
    # 길이는 nlen, 시작점을 sr, sc / sr + nlen, sc / sr, sc + nlen / sr + nlen, sc + nlen
    cnt(sr, sc, nlen)  # 좌상
    cnt(sr + nlen, sc, nlen)  # 좌하
    cnt(sr, sc + nlen, nlen)  # 우상
    cnt(sr + nlen, sc + nlen, nlen)  # 우하


def is_same(sr, sc, llen):
    for r in range(sr, sr + llen):
        for c in range(sc, sc + llen):
            if arr[sr][sc] != arr[r][c]:
                return False  # 처음이랑 다르면
    ans[arr[sr][sc]] += 1  # 모두 처음이랑 같으면 정답 올리기
    return True


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = [0, 0]  # 0개수, 1개수
cnt(0, 0, N)
print(*ans, sep="\n")