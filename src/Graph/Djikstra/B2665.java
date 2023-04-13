import java.io.*;
import java.util.*;
import java.awt.Point;

public class B2665 {
  static class pos{
    int x;
    int y;
    int cnt;
    public pos (int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
  static void djikstra(int startX, int startY) {
    // 최소 힙 우선순위 큐
    PriorityQueue<pos> q = new PriorityQueue<pos>((o1, o2) -> o1.cnt - o2.cnt);
    // 시작 지점이 검은 방인 경우
    if (board[startY][startX] == '0')
      cnts[startY][startX] = 1;
    // 시작 지점이 흰 방인 경우
    else
      cnts[startY][startX] = 0;
    q.offer(new pos(startX, startY, cnts[startY][startX]));
    
    while (!q.isEmpty()) {
      pos now = q.poll();
      int nowX = now.x;
      int nowY = now.y;
      // 최소 힙을 유지하고 있으므로, 끝 방에 처음 도달한 값이 최솟값
      if (nowX == N-1 && nowY == N-1)
        break;
      int nowCnt = now.cnt;
      for (int i = 0; i < 4; ++i) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0)
          continue;
        if (!visited[nextY][nextX]) {
          // 다음 가야 하는 위치가 검은 방인 경우
          if (board[nextY][nextX] == '0') {
            cnts[nextY][nextX] = nowCnt + 1;
            q.offer(new pos(nextX, nextY, nowCnt + 1));
          }
          else {
            // 다음 가야하는 위치가 흰 방인 경우
            cnts[nextY][nextX] = nowCnt;
            q.offer(new pos(nextX, nextY, nowCnt));
          }
          visited[nextY][nextX] = true;
        }
      }
    }
  }
  static final int INF = 987654321;
  static final int dx[] = {0, 0, -1, 1};
  static final int dy[] = {1, -1, 0, 0};
  static int N;
  static char board[][];
  static int cnts[][];
  static boolean visited[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    cnts = new int[N][N];
    visited = new boolean[N][N];
    for (int i = 0; i < N; ++i) {
      String str = br.readLine();
      board[i] = str.toCharArray();
    }
    djikstra(0, 0);
    bw.flush();
    bw.write(String.valueOf(cnts[N-1][N-1]));
    bw.close();
    br.close();
  }
}