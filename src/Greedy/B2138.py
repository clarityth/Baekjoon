import sys

input = sys.stdin.readline
N = int(input())
cur = list(map(int, input().rstrip()))
tgt = list(map(int, input().rstrip()))

def press(a, idx) :
    if 0 <= idx - 1 < N:
        a[idx - 1] ^= 1
    if 0 <= idx < N :
        a[idx] ^= 1
    if 0 <= idx + 1 < N :
        a[idx + 1] ^= 1

# 첫번째 칸의 상태를 나누기
tmp1 = cur.copy() # 첫째 칸을 누른 상황
tmp2 = cur.copy() # 첫째 칸을 누르지 않은 상황

cnt1 = 0
cnt2 = 0

press(tmp1, 0)
cnt1 += 1

for i in range(1, N) :
    if tmp1[i - 1] != tgt[i - 1] :
        press(tmp1, i)
        cnt1 += 1
    if tmp2[i - 1] != tgt[i - 1] :
        press(tmp2, i)
        cnt2 += 1

ans = []
if tmp1 == tgt :
    ans.append(cnt1)
if tmp2 == tgt :
    ans.append(cnt2)
if ans :
    print(min(ans))
else :
    print(-1)