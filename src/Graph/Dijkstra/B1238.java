// 파티
import java.io.*;
import java.util.*;

public class B1238 {
  static class Edge{
    int end;
    int cost;
    public Edge (int end, int cost) {
      this.end = end;
      this.cost = cost;
    } 
  }
  
  static void dijkstra(int start) {
    Arrays.fill(dist, INF);
    dist[start] = 0;
    // 최소 힙
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Edge(start, 0));
    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      int nowTown = now.end;
      int nowDist = now.cost;
      // 저장된 비용보다 현재 우선순위 큐의 최소 비용이 더 크다면 패스
      if (nowDist > dist[nowTown])
        continue;
      // 현재 마을에서 이어진 모든 도로들에 대해
      for (Edge e : graph[nowTown]) {
        int nextTown = e.end;
        int nextDist = nowDist + e.cost;
        // 다른 마을을 거쳐서 가는 비용이 저장된 비용보다 작다면 우선순위 큐에 삽입
        if (nextDist < dist[nextTown]) {
          dist[nextTown] = nextDist;
          pq.offer(new Edge(nextTown, nextDist));
        }
      }      
    }
  }
  
  static ArrayList<Edge> graph[];
  static final int INF = 987654321;
  static int N, M, X;
  static int dist[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 학생의 수
    M = Integer.parseInt(st.nextToken()); // 도로의 개수
    X = Integer.parseInt(st.nextToken()); // 모여야 하는 마을
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i) 
      graph[i] = new ArrayList<Edge>();
    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph[start].add(new Edge(end, cost));
    }
    dist = new int[N + 1];
    // X에서 부터 각 마을로 돌아가는 비용을 저장
    dijkstra(X);
    int[] wayBackDist = dist.clone();

    // 각 마을에서 X까지 가는 비용 + X에서 마을에서 돌아가는 비용의 최댓값을 저장
    int maxCost = 0;
    for (int i = 1; i <= N; ++i) {
      if (i == X)
        continue;
      dijkstra(i);
      maxCost = Math.max(maxCost, wayBackDist[i] + dist[X]);
    }
    bw.flush();
    bw.write(String.valueOf(maxCost));
    bw.close();
    br.close();
  }
}