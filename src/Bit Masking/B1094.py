import sys
input = sys.stdin.readline

X = str(bin(int(input())))[2:]
print(X.count('1'))