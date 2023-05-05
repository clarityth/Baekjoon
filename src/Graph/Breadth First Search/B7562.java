// 나이트의 이동
import java.io.*;
import java.util.*;
import java.awt.Point;

public class B7562 {
  static final int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
  static final int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
  static int t, l;
  static int board[][];
  static boolean visit[][];
  static Queue<Point> q;

  static void bfs(int startX, int startY, int targetX, int targetY) {
    q.offer(new Point(startX, startY));
    visit[startY][startX] = true;

    while (!q.isEmpty()) {
      Point currentPos = q.poll();
      int currentX = currentPos.x;
      int currentY = currentPos.y;
      if (currentX == targetX && currentY == targetY)
        break;

      for (int i = 0; i < 8; ++i) {
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];
        if (nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) {
          continue;
        }
        if (!visit[nextY][nextX]) {
          visit[nextY][nextX] = true;
          board[nextY][nextX] = board[currentY][currentX] + 1;
          q.offer(new Point(nextX, nextY));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; ++i) {
      l = Integer.parseInt(br.readLine());
      board = new int[l][l];
      visit = new boolean[l][l];
      q = new LinkedList<Point>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int currentX = Integer.parseInt(st.nextToken());
      int currentY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int targetX = Integer.parseInt(st.nextToken());
      int targetY = Integer.parseInt(st.nextToken());

      bfs(currentX, currentY, targetX, targetY);
      sb.append(board[targetY][targetX] + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}