import sys
input = sys.stdin.readline

A, B = map(int, input().split())
cnt = 1

while B > A :
    if B % 10 == 1 : # 1로 끝난다면
        B //= 10 # 끝자리 1을 떼어냄
        cnt += 1

    elif B % 2 == 0 : # 2로 나누어진다면
        B //= 2 # 2로 나눔
        cnt += 1

    else :
        print(-1)
        exit()

if B == A :
    print(cnt)
else :
    print(-1)