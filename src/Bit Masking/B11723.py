import sys
input = sys.stdin.readline

M = int(input())
S = 0
for _ in range(M) :
    command = input().split()
    op = command[0]
    if len(command) > 1 :
        num = int(command[1])
        if op == "add" :
            S |= (1 << num)
        elif op == "remove" :
            S &= ~(1 << num)
        elif op == "check" :
            print(1 if S & (1 << num) else 0)
        elif op == "toggle" :
            if S & (1 << num) :
                S &= ~(1 << num)
            else :
                S |= (1 << num)
    else :
        if op == "all" :
            S = (1 << 21) - 1
        elif op == "empty" :
            S = 0