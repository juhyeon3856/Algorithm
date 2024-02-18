def solution(data, ext, val_ext, sort_by):
    answer = []
    st = ["code", "date", "maximum", "remain"]
    num1 = st.index(ext)
    for i in range(len(data)):
        if data[i][num1] < val_ext:
            answer.append(data[i])
    num2 = st.index(sort_by)
    answer.sort(key = lambda x : x[num2])
    return answer