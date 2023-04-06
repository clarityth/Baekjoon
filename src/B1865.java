import java.io.*;
import java.util.*;

public class B1865 {
  static class Edge{
    int e;
    int t;
    public Edge (int e, int t) {
      this.e = e;
      this.t = t;
    } 
  }
  static boolean bellmanFord(int n) {
    long[] dist = new long[n + 1];
    boolean isUpdated = false;
    Arrays.fill(dist, INF);
    dist[1] = 0l;
    
    // 모든 정점을 순회
    for (int i = 1; i < n; ++i) {
      isUpdated = false;
      // 모든 간선을 순회
      for (int j = 1; j <= n; ++j) {
        for (Edge edge : graph[j]) {
          // !: dist[j] != INF 조건을 넣으면 음수 간선을 발견하지 못함
          if (dist[edge.e] > dist[j] + edge.t) {
            dist[edge.e] = dist[j] + edge.t;
            isUpdated = true;
          }
        }
      }
      // 모든 간선을 순회하였음에도 업데이트가 되지 않은 경우 -> 음수 간선으로 인해 cycle이 발생
      if (!isUpdated)
        break;
    }
    if (isUpdated)
      return true;
    else
      return false;
  }
  
  static ArrayList<Edge> graph[];
  static final long INF = 9876543210l;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int TC = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    while (TC-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 지점의 수 
      int M = Integer.parseInt(st.nextToken()); // 도로의 개수
      int W = Integer.parseInt(st.nextToken()); // 웜홀의 개수
      graph = new ArrayList[N + 1];
      for (int i = 1; i <= N; ++i) 
        graph[i] = new ArrayList<>();
      for (int i = 0; i < M; ++i) {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 시작 지점
        int E = Integer.parseInt(st.nextToken()); // 도착 지점
        int T = Integer.parseInt(st.nextToken()); // 걸리는 시간
        // 도로는 방향이 없으므로, 양쪽 다 넣어줌
        graph[S].add(new Edge(E, T));
        graph[E].add(new Edge(S, T));
      }
      for (int i = 0; i < W; ++i) {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        // 웜홀은 방향이 있고, 시간이 역행함
        graph[S].add(new Edge(E, -T));       
      }
      if (bellmanFord(N))
        sb.append("YES\n");
      else
        sb.append("NO\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}