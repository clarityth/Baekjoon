import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.ArrayList;

public class B1197 {
  // Kruskal 알고리즘 사용
  public static

  class Edge {
    int start, end, weight;

    Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }
  }

  public static void union(int[] parent, int a, int b) {
    int a_parent = find(parent, a);
    int b_parent = find(parent, b);
    if (a_parent != b_parent)
      parent[b_parent] = a_parent;
  }

  public static int find(int[] parent, int i) {
    if (parent[i] == i)
      return i;
    else
      return parent[i] = find(parent, parent[i]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    ArrayList<Edge> edges = new ArrayList<>();
    int[] parent = new int[V + 1];
    for (int i = 0; i < E; ++i) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      edges.add(new Edge(start, end, weight));
    }
    // 간선들의 가중치를 오름차순으로 정렬
    edges.sort(new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.weight, o2.weight);
      }
    });

    for (int i = 1; i <= V; ++i) {
      parent[i] = i;
    }

    int cost = 0;
    for (int i = 0; i < E; ++i) {
      Edge edge = edges.get(i);
      // 싸이클이 생기지 않는다면 (부모가 같지 않다면) union 연산
      if (find(parent, edge.start) != find(parent, edge.end)) {
        union(parent, edge.start, edge.end);
        cost += edge.weight;
      }
    }
    bw.write(String.valueOf(cost));
    bw.flush();
    bw.close();
    br.close();
  }
}