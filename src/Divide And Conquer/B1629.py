import sys
input = sys.stdin.readline

A, B, C = map(int, input().split())

def pow(n, m) :
    if m == 1 :
        return n % C

    temp = pow(n, m//2)

    if m % 2 == 1 :
        return (temp * temp * n) % C
    else :
        return (temp * temp) % C

print(pow(A, B))