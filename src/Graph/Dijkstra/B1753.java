// 최단경로
import java.io.*;
import java.util.*;

class Node {
  int dest;
  int cost;

  Node(int dest, int cost) {
    this.dest = dest;
    this.cost = cost;
  }
}

public class B1753 {
  static final int INF = 987654321;
  static ArrayList<Node> graph[];
  static boolean visit[];
  static int distance[];

  static void dijkstra(int start) {
    // 힙 구조인 우선순위 큐를 사용(시간 복잡도: ElogV), 최소 힙을 유지하도록 함.
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Node(start, 0));
    distance[start] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      visit[now.dest] = true;

      for (Node next : graph[now.dest]) {
        if (!visit[next.dest] && distance[next.dest] > now.cost + next.cost) {
          distance[next.dest] = now.cost + next.cost;
          pq.offer(new Node(next.dest, now.cost + next.cost));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken()); // 정점의 개수
    int E = Integer.parseInt(st.nextToken()); // 간선의 개수
    int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
    graph = new ArrayList[V + 1];
    visit = new boolean[V + 1];
    distance = new int[V + 1];

    for (int i = 1; i <= V; ++i) {
      graph[i] = new ArrayList<Node>();
      distance[i] = INF;
    }

    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph[start].add(new Node(end, weight));
    }

    dijkstra(K);

    for (int i = 1; i <= V; ++i) {
      if (distance[i] == INF)
        bw.write("INF\n");
      else
        bw.write(String.valueOf(distance[i])+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}