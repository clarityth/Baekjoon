import sys

input = sys.stdin.readline
INF = float('inf')
N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

dp = [[-1] * (1 << N) for _ in range(N)]
# dp[current][visited]
# = (상태) 현재 위치가 current이고, visited의 비트가 1인 노드들을 이미 거쳐왔을 때,
# = (저장할 값) "여기서부터 출발해서 아직 방문하지 않은 남은 노드들을 다 돌고 시작점으로 돌아가는 데 드는 최소 비용"

def dfs(cur_node, visited) :
    # 종료 조건: 모든 도시를 방문했을 때 (비트가 모두 1로 켜진 상태)
    if visited == (1 << N) - 1 :
        # 출발지(0번)로 돌아가는 길이 존재하면 그 비용을 반환, 없으면 INF
        if W[cur_node][0] != 0 :
            return W[cur_node][0]
        else :
            return INF

    # 메모이제이션: 이미 계산해 둔 상태라면 캐싱된 값 즉시 반환
    if dp[cur_node][visited] != -1 :
        return dp[cur_node][visited]

    min_cost = INF

    # 다음 상태로의 전이 탐색
    for next_node in range(N) :
        # 가는 길이 없거나(비용이 0), 이미 방문한 도시라면 건너뜀
        if W[cur_node][next_node] == 0 or visited & (1 << next_node) :
            continue

        # 다음 도시를 방문 상태로 추가 (visited | (1 << next_node))
        # DFS 재귀호출을 통해 '다음 도시에서 끝까지 가는 데 드는 최소 비용'을 구해 현재 간선 비용을 더함
        cost = dfs(next_node, visited | (1 << next_node)) + W[cur_node][next_node]
        min_cost = min(min_cost, cost)

    # 탐색 결과를 기록(캐싱)하고 반환
    dp[cur_node][visited] = min_cost
    return min_cost

# 어느 도시에서 출발하든 TSP는 하나의 '사이클'이므로 결과가 같습니다.
# 중복 연산을 막기 위해 0번 도시에서 고정으로 출발합니다. (초기 방문 상태: 1)
print(dfs(0, 1))


