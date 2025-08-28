'''
경로가 중복되는 갯수 arr 만들어 해결하기
'''
res = []

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    cnt_arr = [0] * 200
    for _ in range(N):
        current_num, target_num = map(int, input().split())
        # if current_num == target_num:
        #     continue
        path_start = (current_num - 1) // 2
        path_end = (target_num - 1) // 2
        if path_start > path_end:
            path_start, path_end = path_end, path_start
        for i in range(path_start, path_end + 1):
            cnt_arr[i] += 1
    print(max(cnt_arr) * 10)