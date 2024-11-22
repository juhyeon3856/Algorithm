def solution(s, skip, index):
    answer = ''
    for sp in s:
        spOrd = ord(sp)
        _index = index
        while _index > 0:
            spOrd += 1
            if spOrd > 122: 
                spOrd = spOrd - 26
            if chr(spOrd) not in skip:
                _index -= 1
        answer += chr(spOrd)
    return answer