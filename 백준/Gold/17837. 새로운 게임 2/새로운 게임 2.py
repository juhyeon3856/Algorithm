# 입력
N, K = map(int, input().split())
# 체스판을 벗어나는 경우에는 파란색과 같은 경우이다. -> 패딩
board_arr = [[2] * (N + 2)] + [[2] + list(map(int, input().split())) + [2] for _ in range(N)] + [[2] * (N + 2)]

# 우 좌 상 하
dr = [100, 0, 0, -1, 1]
dc = [100, 1, -1, 0, 0]
dt = [100, 1, -1, 1, -1]  # 방향 반대로 가중치(d에 더함)


class Node:
    def __init__(self, id, r, c, d):
        self.id = id
        self.r = r
        self.c = c
        self.d = d

    def __repr__(self):
        return f"{self.id}{dir_dict[self.d]}"

    def move(self, dir):
        self.r, self.c = self.r + dr[dir], self.c + dc[dir]

    def turn(self):
        self.d = self.d + dt[self.d]


node_arr = [[[] for _ in range(N + 2)] for _ in range(N + 2)]
node_lst = []

for i in range(1, K + 1):
    inp_r, inp_c, inp_d = map(int, input().split())
    new_node = Node(i, inp_r, inp_c, inp_d)
    node_lst.append(new_node)
    node_arr[inp_r][inp_c].append(new_node)


def find_height(node):
    # 몇층인지 찾기
    result = 0
    for arr_node in node_arr[node.r][node.c]:
        if node == arr_node:
            break
        result += 1
    else:
        print("NOOOOOOOOOOOOOOO")
    return result


def do_move(flst, fnr, fnc, fcr, fcc, fdir):
    for move_node in flst:  # node이동시키기
        move_node.move(fdir)

    node_arr[fnr][fnc].extend(flst)  # 다음 맵에 붙이기
    node_arr[fcr][fcc] = node_arr[fcr][fcc][:height]  # 기존 맵에서 제거
    if len(node_arr[nr][nc]) >= 4:
        return True
    return False


dir_dict = {1: '→', 2: '←', 3: '↑', 4: '↓'}


def print_arr():
    print("======================================================================")
    for llst in node_arr:
        for lllst in llst:
            end_str = '\t' * (4 - len(lllst))
            print(lllst, end=end_str)
        print()
        # print(*llst, sep='\t')


debug = 0

ans = 0
is_end = False  # 4개 이상이면 True로 바꾸기
# 로직
while not is_end:  # 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료
    ans += 1
    if ans > 1000:
        ans = -1
        break

    # 말 이동
    for cur_node in node_lst:
        # print_arr()
        cr, cc, cd = cur_node.r, cur_node.c, cur_node.d
        nr, nc = cr + dr[cd], cc + dc[cd]

        if board_arr[nr][nc] == 0:
            height = find_height(cur_node)
            move_lst = node_arr[cr][cc][height:]
            is_end = do_move(move_lst, nr, nc, cr, cc, cd)

        elif board_arr[nr][nc] == 1:
            height = find_height(cur_node)
            move_lst = node_arr[cr][cc][height:]
            is_end = do_move(move_lst[::-1], nr, nc, cr, cc, cd)

        elif board_arr[nr][nc] == 2:
            cur_node.turn()
            cr, cc, cd = cur_node.r, cur_node.c, cur_node.d
            nr, nc = cr + dr[cd], cc + dc[cd]
            if board_arr[nr][nc] == 0:
                height = find_height(cur_node)
                move_lst = node_arr[cr][cc][height:]
                is_end = do_move(move_lst, nr, nc, cr, cc, cd)

            elif board_arr[nr][nc] == 1:
                height = find_height(cur_node)
                move_lst = node_arr[cr][cc][height:]
                is_end = do_move(move_lst[::-1], nr, nc, cr, cc, cd)

        if is_end:
            break

print(ans)