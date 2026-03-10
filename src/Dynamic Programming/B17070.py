import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

if board[N - 1][N - 1] == 1 :
    print(0)
    exit()

dp = [[[0] * N for _ in range(N)] for _ in range(3)] # [방향][y][x] = 올 수 있는 방법수
dp[0][0][1] = 1

for i in range(0, N) :
    for j in range(1, N) :
        if board[i][j] != 1 :
            if j - 1 >= 0 :
                dp[0][i][j] += dp[0][i][j - 1] + dp[2][i][j - 1]
            if i - 1 >= 0 :
                dp[1][i][j] += dp[1][i - 1][j] + dp[2][i - 1][j]
            if j - 1 >= 0 and i - 1 >= 0 and board[i - 1][j] == 0 and board[i][j - 1] == 0:
                dp[2][i][j] += dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1]

print(dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1])