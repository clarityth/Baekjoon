import sys
from collections import deque

input = sys.stdin.readline
N = int(input().rstrip())
graph = [[] for _ in range(N + 1)]
parent = [0] * (N + 1)

for i in range(N - 1) :
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def bfs() :
    q = deque([1])
    parent[1] = 1

    while q :
        cur = q.popleft()
        for next in graph[cur] :
            if parent[next] == 0 :
                parent[next] = cur
                q.append(next)

bfs()

for i in range(2, N + 1) :
    print(parent[i])