import sys
input = sys.stdin.readline

og_grid = [[0] * 10 for _ in range(10)]
tgt_grid = [[0] * 10 for _ in range(10)]

for i in range(10) :
    s = input().rstrip()
    for j in range(10) :
        if s[j] == '#' : # 꺼진 전구
            og_grid[i][j] = 0
        else : # 켜진 전구
            og_grid[i][j] = 1

def press(arr, r, c) :
    arr[r][c] ^= 1 # 본인 반전
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    for i in range(4) : # 상하좌우 반전
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < 10 and 0 <= nc < 10 :
            arr[nr][nc] ^= 1

cnts = []
for i in range(1024) : # 첫째 줄의 각 칸을 눌렀을 때의 조합을 나눔 (각 칸의 누름 여부를 이진수로 변환)
    cnt = 0
    temp_grid = [row[:] for row in og_grid]
    for j in range(10) : # 비트마스킹: 각 조합마다 0번~9번 스위치를 확인
        if i & (1 << j):
            press(temp_grid, 0, j)
            cnt += 1
    for k in range(1, 10) : # 행
        for l in range(10) : # 열
            if temp_grid[k - 1][l] != tgt_grid[k - 1][l] : # 이전 줄에 켜진 불 끄기
                press(temp_grid, k, l)
                cnt += 1
    if temp_grid == tgt_grid:
        cnts.append(cnt)
if cnts :
    print(min(cnts))
else :
    print(-1)