import java.io.*;
import java.util.*;
import java.awt.Point;

public class B10026 {
  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };
  static int N;
  static char drawing[][];
  static boolean visit[][];
  static Queue<Point> q;

  static int getAreaCnt(boolean isColorWeakness) {
    visit = new boolean[N][N];
    int cnt = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (!visit[i][j]) {
          if (isColorWeakness)
            bfs(j, i, true);
          else
            bfs(j, i, false);
          ++cnt;
        }
      }
    }
    return cnt;
  }

  static void bfs(int startX, int startY, boolean isColorWeakness) {
    q.offer(new Point(startX, startY));
    visit[startY][startX] = true;

    while (!q.isEmpty()) {
      Point now = q.poll();
      int nowX = now.x;
      int nowY = now.y;
      char nowColor = drawing[nowY][nowX];
      for (int i = 0; i < 4; ++i) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
          continue;
        char nextColor = drawing[nextY][nextX];
        if (!visit[nextY][nextX]) {
          if (isColorWeakness) {
            if ((nowColor == nextColor) || (nowColor == 'R' && nextColor == 'G')
                || (nowColor == 'G' && nextColor == 'R')) {
              visit[nextY][nextX] = true;
              q.offer(new Point(nextX, nextY));
            }
          } else {
            if (nowColor == nextColor) {
              visit[nextY][nextX] = true;
              q.offer(new Point(nextX, nextY));
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    drawing = new char[N][N];
    q = new LinkedList<Point>();
    for (int i = 0; i < N; ++i) {
      String str = br.readLine();
      for (int j = 0; j < N; ++j) {
        char c = str.charAt(j);
        drawing[i][j] = c;
      }
    }
    int normalCnt = getAreaCnt(false);
    int colorWeaknessCnt = getAreaCnt(true);
    bw.write(String.valueOf(normalCnt) + " " + String.valueOf(colorWeaknessCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}