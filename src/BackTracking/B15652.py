import sys
input = sys.stdin.readline

N, M = map(int, input().split())

ans = []

def dfs(x) :
    if len(ans) == M :
        print(*ans)
        return

    for i in range(x, N + 1) :
        ans.append(i)
        dfs(i + 1)
        ans.pop()

dfs(1)