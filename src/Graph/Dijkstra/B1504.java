// 특정한 최단 경로
import java.io.*;
import java.util.*;

public class B1504 {
  static class Edge {
    int end;
    long cost;
    public Edge (int end, long cost) {
      this.end = end;
      this.cost = cost;
    }
  }

  static void dijkstra (int start) {
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> Long.compare(o1.cost, o2.cost));
    Arrays.fill(dist, INF);
    dist[start] = 0;
    pq.offer(new Edge(start, 0));
    while (!pq.isEmpty()) {
      Edge now = pq.poll();
      long nowCost = now.cost;
      int nowDest = now.end;
      if (nowCost > dist[nowDest])
        continue;
      for (Edge next : graph[nowDest]) {
        long nextCost = next.cost + nowCost;
        int nextDest = next.end;
        if (dist[nextDest] > nextCost) {
          dist[nextDest] = nextCost;
          pq.offer(new Edge(nextDest, nextCost));
        }
      }
    }
  }

  static final long INF = 2000000l;
  static int N, E, v1, v2;
  static long dist[];
  static ArrayList<Edge> graph[];
  static boolean visited[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];
    dist = new long[N + 1];
    for (int i = 1; i <= N; ++i) {
      graph[i] = new ArrayList<Edge>();
    }
    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      // 무방향 그래프
      graph[a].add(new Edge(b, c));
      graph[b].add(new Edge(a, c));
    }
    st = new StringTokenizer(br.readLine());
    v1 = Integer.parseInt(st.nextToken());
    v2 = Integer.parseInt(st.nextToken());
    
    // start에서 v1과 v2를 거쳐가는 경로는 start(1)->v1->v2->end(N), start(1)->v2->v1->end(N) 두가지가 존재
    dijkstra(1);
    long startToV1 = dist[v1];
    long startToV2 = dist[v2];
    dijkstra(v1);
    long v1ToV2 = dist[v2];
    long v1ToEnd = dist[N];
    dijkstra(v2);
    long v2ToEnd = dist[N];
    long route1 = INF;
    long route2 = INF;
    
    // !주의: 해당 경로를 선택하기 위해서는 도중에 가는 경로가 없어서는 안됨
    if (startToV1 != INF && v1ToV2 != INF && v2ToEnd != INF) 
      route1 = startToV1 + v1ToV2 + v2ToEnd;
    
    if (startToV2 != INF && v1ToV2 != INF && v1ToEnd != INF) 
      route2 = startToV2 + v1ToV2 + v1ToEnd;
    
    long minDist = Math.min(route1, route2);
    bw.flush();
    if (minDist == INF)
      bw.write("-1");
    else
      bw.write(String.valueOf(minDist));
    bw.close();
    br.close();
  }
}