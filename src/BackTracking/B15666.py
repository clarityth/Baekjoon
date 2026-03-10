import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

ans = []

def dfs(start) :
    if len(ans) == M :
        print(*ans)
        return

    last_used = 0
    for i in range(start, len(nums)) :
        if last_used != nums[i] :
            ans.append(nums[i])
            last_used = nums[i]
            dfs(i)
            ans.pop()

dfs(0)