import java.io.*;
import java.util.*;

public class B1446 {
  static final int INF = 987654321;
  static int N, D;
  static class Node{
    int d;
    int len;

    public Node(int d, int len){
      this.d = d;
      this.len = len;
    }
  }

  static ArrayList<Node>[] graph;
  static int[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    graph = new ArrayList[10001];
    distance = new int[10001];
    // dp 배열

    // initialize
    for(int i = 0; i < graph.length; ++i){
      graph[i] = new ArrayList<>();
      distance[i] = i;
    }
    
    for(int i = 0; i < N; ++i){
      st = new StringTokenizer(br.readLine());
      int startPos = Integer.parseInt(st.nextToken());
      int endPos = Integer.parseInt(st.nextToken());
      int shortcutLen = Integer.parseInt(st.nextToken());
      graph[startPos].add(new Node(endPos, shortcutLen));
    }
    
    for(int i = 0; i <= D; ++i){
      if (i != 0)
        distance[i] = Math.min(distance[i-1] + 1, distance[i]);
      if (graph[i].size() > 0){
        for (Node n : graph[i]){
          // 더 짧은 지름길이라면 갱신
          if (distance[n.d] > distance[i] + n.len)
            distance[n.d] = distance[i] + n.len;
        }
      }
    }
    bw.write(String.valueOf(distance[D]));
    bw.flush();
    bw.close();
    br.close();
  }
}