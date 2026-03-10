import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

ans = []
visited = [False] * N

def dfs(n) :
    if len(ans) == M :
        print(*ans)
        return

    last_used = -1

    for i in range(len(nums)) :
        if not visited[i] and last_used != nums[i]:
            visited[i] = True
            ans.append(nums[i])
            last_used = nums[i]

            dfs(i)

            visited[i] = False
            ans.pop()

dfs(1)