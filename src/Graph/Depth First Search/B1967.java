
// 트리의 지름
import java.io.*;
import java.util.*;

public class B1967 {
  static int n, maxCost = 0, maxCostIdx = 0;
  static ArrayList<Edge>[] d;
  static boolean visited[];

  static class Edge {
    int child;
    int weight;

    Edge(int child, int weight) {
      this.child = child;
      this.weight = weight;
    }
  }

  static void dfs(int start, int costSum) {
    visited[start] = true;
    for (Edge e : d[start]) {
      // 현재 정점에 이어진 모든 간선에 대하여 반복
      int curDest = e.child;
      int curCost = e.weight;
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
    n = Integer.parseInt(br.readLine());
    if (n == 1) {
      bw.write("0");
      bw.flush();
      bw.close();
      br.close();
      System.exit(0);
    }
    d = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    for (int i = 1; i <= n; ++i) {
      d[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < n - 1; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int parentNode = Integer.parseInt(st.nextToken());
      int childNode = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      // 방향이 없으므로 양방향 간선 추가
      d[parentNode].add(new Edge(childNode, weight));
      d[childNode].add(new Edge(parentNode, weight));
    }

    visited = new boolean[n + 1];
    dfs(1, 0);
    // 임의의 한 정점에 대하여 dfs 수행
    visited = new boolean[n + 1];
    dfs(maxCostIdx, 0);
    // 최대 비용이 되는 정점에 대하여 dfs를 한번 더 수행 -> 해당 dfs의 수행 결과가 트리의 지름
    bw.flush();
    bw.write(String.valueOf(maxCost));
    bw.close();
    br.close();
  }
}