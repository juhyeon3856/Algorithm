from collections import deque

def solution(priorities, location):
    time = 0
    data = deque(priorities)
    priorities.sort(reverse=True)
    maxCheck = deque(priorities)
    check = maxCheck.popleft()
    while True:
        _data1_ = data.popleft()
        if _data1_ == check:
            if location == 0:
                return time + 1
            else:
                time += 1
                location -= 1
                check = maxCheck.popleft()
        else:
            if location == 0:
                location = len(data)
                data.append(_data1_)
            else:
                location -= 1
                data.append(_data1_)

