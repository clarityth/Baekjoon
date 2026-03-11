import sys
input = sys.stdin.readline

N, M = map(int, input().split())
days = [int(input().rstrip()) for _ in range(N)]
l = max(days) # 최소 인출 금액: 가장 높은 금액을 뽑는 경우
r = sum(days) # 최대 인출 금액: 모든 인출 금액을 뽑는 경우

ans = r
while l <= r :
    m = (l+r)//2
    cnt = 1
    cur_money = m # 첫번째 인출
    for day in days: # 일일 지출
        if day > cur_money : # 일일 지출이 현재 잔고보다 크다면 남은 금액을 집어넣고 인출
            cnt += 1
            cur_money = m
        cur_money -= day # 지출 반영

    if cnt > M : # 현재 인출 횟수가 M보다 크면 불가능, 최소 인출 금액을 증가
        l = m + 1
    else : # 현재 인출 횟수가 M보다 작거나 같다면 가능(추가로 인출해서 횟수 맞추기 가능), 인출 금액을 더 줄일 수 있는지 탐색
        r = m - 1
        ans = m

print(ans)
