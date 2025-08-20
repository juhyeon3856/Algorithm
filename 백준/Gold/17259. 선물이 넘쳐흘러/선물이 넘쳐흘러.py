# 입력
B, N, M = map(int, input().split())  # 공장크기, 직원수, 선물개수
arr = [list(map(int, input().split())) for _ in range(N)]

# [1] arr를 선물 만나는 순서대로 배치
# 주의사항 (1, B-2), (B-2, B-2)인지 두개 확인

emp = []  # time, 코너 여부(코너1), 정렬순서
for r, c, t in arr:
    is_c = (r, c) == (1, B - 2) or (r, c) == (B - 2, B - 2)
    sort_i = r * 10000 - c if r == B - 2 else r * 10000 + c
    emp.append((t, is_c, sort_i))

emp.sort(key=lambda x: x[2])

debug = 0

# [2] emp가 포장하는 선물은 false로 바꾸기
box = [0, 0] + [1] * M + [0, 0]

for t, is_c, _ in emp:
    ci = 0
    while ci < M + 2:
        if box[ci]:  # 선물이 있으면
            box[ci] = 0  # 포장함
            ci += t  # 다음 인덱스까지 못만짐
            continue
        elif is_c:  # 코너에 있는 사람이면
            if box[ci + 2]:  # 두칸 뒤에서 있는 선물 있으면
                box[ci+2] = 0
                ci += t
                continue

        ci += 1

# 포장한 선물의 개수
print(M - sum(box))