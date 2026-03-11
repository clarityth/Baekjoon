import sys
input = sys.stdin.readline

N = int(input().rstrip())
nums = list(map(int, input().split()))
nums.sort()

cnt = 0

for i in range(N) :
    target = nums[i]
    start = 0
    end = N - 1
    while start < end :
        # 자기 자신 제외
        if start == i :
            start += 1
            continue
        if end == i :
            end -= 1
            continue

        temp_sum = nums[start] + nums[end]

        if temp_sum == target :
            cnt += 1
            break
        elif temp_sum > target :
            end -= 1
        else :
            start += 1
print(cnt)