// 지름길
import java.io.*;
import java.util.*;

public class B1719 {
  static class Edge{
    int end;
    int cost;
    public Edge (int end, int cost) {
      this.end = end;
      this.cost = cost;
    }
  }
  static void dijkstra(int start) {
    Arrays.fill(dist[start], INF);
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> o1.cost - o2.cost);
    dist[start][start] = 0;
    pq.offer(new Edge(start, 0));
    
    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      int nowEnd = now.end;
      int nowCost = now.cost;
      if (dist[start][nowEnd] < nowCost)
        continue;
      for (Edge next : graph[nowEnd]) {
        int nextEnd = next.end;
        int nextCost = next.cost + nowCost;
        if (nextCost < dist[start][nextEnd]) {
          dist[start][nextEnd] = nextCost;
          // 순서 주의
          idx[nextEnd][start] = nowEnd;
          pq.offer(new Edge(nextEnd, nextCost));
        }
      }
    }
  }
  static final int INF = 987654321;
  static int n, m;
  static int dist[][], idx[][];
  static ArrayList<Edge> graph[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // 집하장의 개수
    m = Integer.parseInt(st.nextToken()); // 경로의 개수
    graph = new ArrayList[n+1];
    dist = new int[n+1][n+1];
    idx = new int[n+1][n+1];
    for (int i = 1; i <= n; ++i) {
      graph[i] = new ArrayList<Edge>();
    }
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph[s].add(new Edge(e, c));
      graph[e].add(new Edge(s, c));
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; ++i) {
      dijkstra(i);
    }
    
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (i == j) {
          sb.append("-");
        }
        else {
          sb.append(idx[i][j]);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}