import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B1697 {
  public static boolean[] visit;
  public static int[] route;

  public static void bfs(int start, int end) {
    if (start == end) {
      System.out.println("0");
      return;
    }
    Queue<Integer> q = new LinkedList<Integer>();
    visit[start] = true;
    q.offer(start);

    while (!q.isEmpty()) {
      int currentPos = q.poll();
      int[] next = { currentPos - 1, currentPos + 1, currentPos * 2 };
      for (int i = 0; i < 3; i++) {
        int nextPos = next[i];
        if (nextPos < 0 || nextPos > 100000)
          continue;
        if (nextPos == end) {
          System.out.println(route[currentPos] + 1);
          return;
        }
        if (!visit[nextPos]) {
          route[nextPos] = route[currentPos] + 1;
          visit[nextPos] = true;
          q.offer(nextPos);
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
  }
}
