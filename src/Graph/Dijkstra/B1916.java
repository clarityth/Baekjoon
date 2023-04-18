// 최소비용 구하기
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

public class Main {
  static ArrayList<Node> graph[];
  static final int INF = 987654321;
  static int dist[];
  static boolean visit[];

  static void dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
    pq.offer(new Node(start, 0));
    dist[start] = 0;
    while (!pq.isEmpty()){
      Node now = pq.poll();
      // !시간 초과 : 먼저 삽입된 더 먼 경로의 정점은 (가중치가 더 클 경우) 탐색하지 않음
      if (dist[now.dest] < now.cost)
        continue;
      visit[now.dest] = true;
      for(Node next : graph[now.dest]){
        if (!visit[next.dest] && dist[next.dest] > now.cost + next.cost){
          dist[next.dest] = now.cost + next.cost;
          pq.offer(new Node(next.dest, now.cost + next.cost)); 
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine()); // 도시의 개수
    int M = Integer.parseInt(br.readLine()); // 버스의 개수
    graph = new ArrayList[N + 1];
    visit = new boolean[N + 1];
    dist = new int[N + 1];
    
    for(int i = 1; i <= N; ++i){
      graph[i] = new ArrayList<Node>();
      dist[i] = INF;
    }
    
    for(int i = 0; i < M; ++i){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph[start].add(new Node(end, cost));
    }
    
    st = new StringTokenizer(br.readLine());
    int departures = Integer.parseInt(st.nextToken());
    int arrivals = Integer.parseInt(st.nextToken());
    dijkstra(departures);
    bw.write(String.valueOf(dist[arrivals]));
    bw.flush();
    bw.close();
    br.close();
  }
}
