import sys
input = sys.stdin.readline
w = int(input().rstrip())

dy = [-1, 1, 0, 0, -1, -1, 1, 1] # 상하좌우/대각선
dx = [0, 0, -1, 1, -1, 1, -1, 1]

words = {} # trie 활용
visited = [[False] * 4 for _ in range(4)]

for i in range(w) :
    node = words  # 포인터
    word = input().rstrip()
    for c in word :
        if c not in node :
            node[c] = {}
        node = node[c]
    node['*'] = word # 단어 끝 표시

input()

b = int(input().rstrip())

def dfs(y, x, node) :
    if '*' in node : # 단어를 찾음
        found_words.add(node['*'])

    for i in range(8) :
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < 4 and 0 <= ny < 4 and not visited[ny][nx]:
            nc = board[ny][nx]

            if nc in node : # 백트래킹
                visited[ny][nx] = True
                dfs(ny, nx, node[nc])
                visited[ny][nx] = False

for i in range(b) :
    board = []
    found_words = set()

    for j in range(4) :
        s = input().rstrip()
        board.append(s)

    if i < b - 1 :
        input()

    node = words
    visited = [[False] * 4 for _ in range(4)]
    for j in range(4) :
        for k in range(4) :
            if board[j][k] in node :
                visited[j][k] = True
                dfs(j, k, node[board[j][k]])
                visited[j][k] = False

    sorted_found_words = sorted(found_words)
    max_len = 0
    max_len_word = None
    for f in sorted_found_words :
        if len(f) > max_len :
            max_len = len(f)
            max_len_word = f

    # 1글자, 2글자: 0점, 3글자, 4글자: 1점, 5글자: 2점, 6글자: 3점, 7글자: 5점, 8글자: 11점
    score = {1: 0, 2: 0, 3: 1, 4: 1, 5: 2, 6: 3, 7: 5, 8: 11}
    tot_score = 0
    for word in sorted_found_words :
        tot_score += score[len(word)]
    print(tot_score, max_len_word, len(sorted_found_words))
