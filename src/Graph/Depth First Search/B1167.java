
// 트리의 지름
import java.io.*;
import java.util.*;

public class B1167 {
  static int V, maxCost = 0, maxCostIdx = 0;
  static ArrayList<Edge>[] d;
  static boolean visited[];

  static class Edge {
    int dest;
    int cost;

    Edge(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }

  static void dfs(int start, int costSum) {
    visited[start] = true;
    for (Edge e : d[start]) {
      // 현재 정점에 이어진 모든 간선에 대하여 반복
      int curDest = e.dest;
      int curCost = e.cost;
      if (!visited[curDest]) {
        // 방문하지 않은 정점 방문
        visited[curDest] = true;
        dfs(curDest, curCost + costSum);
      }
      if (maxCost < costSum) {
        // 최대 비용 갱신 및 최대 비용이 되는 정점의 인덱스 갱신
        maxCost = costSum;
        maxCostIdx = start;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    V = Integer.parseInt(br.readLine());
    d = new ArrayList[V + 1];
    visited = new boolean[V + 1];
    for (int i = 1; i <= V; i++) {
      d[i] = new ArrayList<Edge>();
    }

    for (int i = 1; i <= V; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startVertex = Integer.parseInt(st.nextToken());
      while (true) {
        int destVertex = Integer.parseInt(st.nextToken());
        if (destVertex == -1)
          break;
        int cost = Integer.parseInt(st.nextToken());
        d[startVertex].add(new Edge(destVertex, cost));
      }
    }

    visited = new boolean[V + 1];
    dfs(1, 0);
    // 임의의 한 정점에 대하여 dfs 수행
    visited = new boolean[V + 1];
    dfs(maxCostIdx, 0);
    // 최대 비용이 되는 정점에 대하여 dfs를 한번 더 수행 -> 해당 dfs의 수행 결과가 트리의 지름
    bw.flush();
    bw.write(String.valueOf(maxCost));
    bw.close();
    br.close();
  }
}