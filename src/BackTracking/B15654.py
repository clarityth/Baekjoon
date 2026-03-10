import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

ans = []
visited = [False] * N

def dfs() :
    if len(ans) == M :
        print(*ans)
        return

    for i in range(0, len(nums)) :
        if not visited[i] :
            ans.append(nums[i])
            visited[i] = True
            dfs()
            visited[i] = False
            ans.pop()

dfs()