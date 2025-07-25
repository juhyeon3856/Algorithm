# 조건
# 1. 각 색종이가 보이는 부분의 면적
# 2. 색종이의 장수를 나타내는 정수 N (1 ≤ N ≤ 100)
# 3. 색종이가 놓이는 평면은 가로 최대 1001칸, 세로 최대 1001칸으로 구성된 격자 모양
# 4. 색종이가 격자 경계 밖으로 나가는 경우는 없다.

# 체크포인트
# 1001 * 1001크기 배열 만들 수 있다
# 복잡도 n^2 가능하다.

# 아이디어
# 그냥 입력 받는 순서대로 업데이트 한다(겹치면 갱신)
# 그 후 개수를 센다
    # 세는 방법
    # 1. 1적힌 것, 2적힌것...계속 세면 복잡도 100곱해짐 -> 10^8 -> 가능하나 아슬아슬
    # 2. count배열 추가로 만들어서 한번에 함 -> 공간복잡도 10^6 10M사용 / 64주니까 count배열 쓰는 것이 안전해보임

arr = [[0] * 1001 for _ in range(1001)]

N = int(input())
cnt = [0] * (N+1)
for n in range(1, N+1):
    r, c, w, h = map(int, input().split())
    for i in range(r, r+w):
        for j in range(c, c+h):
            arr[i][j] = n

for n in range(1, N+1):
    for i in range(1001):
        for j in range(1001):
            if arr[i][j] == n:
                cnt[n] += 1

cnt.remove(0)
print(*cnt, sep="\n")