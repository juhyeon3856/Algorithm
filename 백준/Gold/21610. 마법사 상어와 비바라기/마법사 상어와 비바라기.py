def oos(i, j):
    return 0 <= i < N and 0 <= j < N


def moveCloud(d,s):
    '''
     cloud를 이동시키는 함수(경계 넘어갈 수 있음.)
    '''
    new_cloud = set()
    for ci, cj in cloud:
        ni = (ci + dx[d] * s) % N
        nj = (cj + dy[d] * s) % N
        new_cloud.add((ni, nj))
    return new_cloud


def rain(arr):
    for i, j in cloud:
        arr[i][j] += 1
    for i, j in cloud:
        for k in range(1, 8, 2):     #대각선에 물이 있는지 체크
            ni = i + dx[k]
            nj = j + dy[k]
            if oos(ni, nj) and arr[ni][nj] > 0:      #내 대각선에 물이 있다면 내가 +1
                arr[i][j] += 1



def new_cloud(cloud):
    new_cloud = set()
    for i in range(N):
        for j in range(N):
            if (i, j) not in cloud and arr[i][j] >= 2:
                new_cloud.add((i,j))
                arr[i][j] -= 2
    return new_cloud


N, M = map(int,input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
magic = [list(map(int,input().split())) for _ in range(M)]   #방향(d), 거리(s) 리스트
cloud = {(N-2, 0), (N-2, 1), (N-1, 0), (N-1, 1)}
dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]


for _magic in magic:
    d, s = _magic[0]-1, _magic[1] #방향(d), 거리(s)
    cloud = moveCloud(d,s)    #d 방향으로 이동한 cloud 가 갱신됨.
    rain(arr)

    # 구름이 있던 칸을 제외한 나머지 칸에서 물 양이 2 이상인 칸에 구름 생김!
    cloud = new_cloud(cloud)

print(sum(sum(arr,[])))
