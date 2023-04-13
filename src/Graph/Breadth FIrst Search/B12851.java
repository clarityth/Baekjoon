import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B12851 {
  public static boolean[] visit;
  public static int[] route;
  public static int cnt = 1;

  public static void bfs(int start, int end) {
    if (start == end) {
      System.out.println("0");
      System.out.println("1");
      return;
    }
    Queue<Integer> q = new LinkedList<Integer>();
    visit[start] = true;
    q.offer(start);
    int printFlag = 0;

    while (!q.isEmpty()) {
      int currentPos = q.poll();
      int[] next = { currentPos - 1, currentPos + 1, currentPos * 2 };
      for (int i = 0; i < 3; i++) {
        int nextPos = next[i];
        if (nextPos < 0 || nextPos > 100000)
          continue;
        if (nextPos == end) {
          if (visit[end]){
            // 이전 방문한 결과값과 같은 경우 cnt값 증가
            if (route[nextPos] == route[currentPos] + 1)
              cnt++;
            // 이전 방문한 결과값보다 작은 경우 cnt값 초기화
            else if (route[nextPos] > route[currentPos] + 1)
              cnt = 1;
          }
          if (printFlag == 0) {
            System.out.println(route[currentPos] + 1);
            printFlag = 1;
          }
        }
        if (!visit[nextPos]) {
          route[nextPos] = route[currentPos] + 1;
          q.offer(nextPos);
          visit[nextPos] = true;
        } else {
          // 이미 방문한 경우 다음 칸까지의 경로가 이전 방문한 것보다 작거나 같은 경우에만 갱신
          if (route[nextPos] >= route[currentPos] + 1) {
            route[nextPos] = route[currentPos] + 1;
            q.offer(nextPos);
          }
        }
      }
    }
    System.out.println(cnt);
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
