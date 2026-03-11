import sys
input = sys.stdin.readline

N = int(input())
cards = set(map(int, input().split()))

M = int(input())
questions = list(map(int, input().split()))

res = [1 if q in cards else 0 for q in questions]
print(*res)