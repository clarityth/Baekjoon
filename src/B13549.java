import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B13549 {
  public static boolean[] visit;
  public static int[] route;
  public static int[] time = { 0, 1, 1 };

  public static void bfs(int start, int end) {
    if (start == end || start * 2 == end) {
      System.out.println("0");
      return;
    } else {
      route[start] = 0;
    }
    Queue<Integer> q = new LinkedList<Integer>();
    visit[start] = true;
    q.offer(start);

    while (!q.isEmpty()) {
      int currentPos = q.poll();
      // 탐색 순서가 중요, 해당 순서가 아닐 경우 최단 경로임이 보장되지 않아 오답 -> 0-1 BFS, 다익스트라 알고리즘으로도 풀이 가능
      int[] next = { currentPos * 2, currentPos - 1, currentPos + 1 };
      for (int i = 0; i < 3; i++) {
        int nextPos = next[i];
        if (nextPos < 0 || nextPos > 100000)
          continue;
        if (!visit[nextPos]) {
          route[nextPos] = route[currentPos] + time[i];
          q.offer(nextPos);
          visit[nextPos] = true;
        }
        if (nextPos == end) {
          System.out.println(route[end]);
          return;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    visit = new boolean[100001];
    route = new int[1000001];
    bfs(N, K);
    br.close();
  }
}
