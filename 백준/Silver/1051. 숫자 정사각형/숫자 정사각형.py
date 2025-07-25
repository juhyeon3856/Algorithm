# 조건
# 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램
# N과 M은 50보다 작거나 같은 자연수

# 아이디어
# 가장 큰 정사각형부터 시작해서 네 꼭짓점이 같은 값을 가지는지 확인한다.

N, M = map(int, input().split())

arr = [list(map(int, input())) for _ in range(N)]


def main():
    s = min(N, M) - 1  # 만들 수 있는 가장 큰 정사각형
    # s가 1씩 작아진다.
    while s > 0:
        # 왼쪽으로 한칸씩 이동
        for i in range(N - s):
            # 아래로 한칸씩 이동
            for j in range(M - s):
                # 네 꼭짓점이 같은지 비교
                if arr[i][j] == arr[i + s][j] == arr[i][j + s] == arr[i + s][j + s]:
                    return (s + 1)**2

        s -= 1
    return s+1

print(main())