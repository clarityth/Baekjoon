import sys
input = sys.stdin.readline

N, K = map(int, input().split())
Ws = [0]
Vs = [0]
for i in range(N) :
    W, V = map(int, input().split())
    Ws.append(W)
    Vs.append(V)

dp = [[0] * (K+1) for _ in range(N+1)]

for i in range(1, N + 1) :
    cur_w = Ws[i]
    cur_v = Vs[i]

    for j in range(1, K + 1):
        if cur_w > j :
            dp[i][j] = dp[i-1][j]
        else :
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-cur_w] + cur_v)

print(dp[N][K])