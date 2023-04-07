import java.io.*;
import java.util.*;

public class B11657 {
  static class Edge{
    int end;
    int cost;
    public Edge (int end, int cost) {
      this.end = end;
      this.cost = cost;
    } 
  }
  
  static boolean bellmanFord(int n) {
    dist[1] = 0l;
    for (int i = 1; i <= n + 1; ++i) {
      for (int j = 1; j <= n; ++j) {
        for (Edge e : graph[j]) {
          // 시작 지점과 이어지지 않은 정점은 음수 사이클이 있더라도 연산하지 않음
          if (dist[j] != INF && dist[e.end] > e.cost + dist[j]) {
            dist[e.end] = e.cost + dist[j];
            // 음수 사이클 판별법: 한번의 루프를 더 돌려 갱신이 일어나는 경우
            if (i == n + 1)
              return false;
          }
        }
      }
    }
    return true;
  }
  
  static ArrayList<Edge> graph[];
  static final long INF = 9876543210l;
  static int N, M;
  static long dist[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 도시의 개수
    M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i) 
      graph[i] = new ArrayList<Edge>();
    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      graph[A].add(new Edge(B, C));
    }
    dist = new long[N+1];
    Arrays.fill(dist, INF);
    StringBuilder sb = new StringBuilder();
    if (!bellmanFord(N)) 
      bw.write("-1");
    else {
      for (int i = 2; i <= N; ++i) {
        if (dist[i] == INF)
          sb.append("-1\n");
        else
          sb.append(dist[i] + "\n");
      }
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}