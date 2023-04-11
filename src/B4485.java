import java.io.*;
import java.util.*;
import java.awt.Point;

public class B4485 {
  static class pos{
    int x;
    int y;
    int rupee;
    public pos (int x, int y, int rupee) {
      this.x = x;
      this.y = y;
      this.rupee = rupee;
    }
  }
  static void djikstra(int startX, int startY) {
    PriorityQueue<pos> q = new PriorityQueue<pos>((o1, o2) -> o1.rupee - o2.rupee);
    blackRupee[startY][startX] = cave[startY][startX];
    q.offer(new pos(startX, startY, cave[startY][startX]));
    while (!q.isEmpty()) {
      pos now = q.poll();
      int nowX = now.x;
      int nowY = now.y;
      int nowRupee = now.rupee;
      if (nowRupee > blackRupee[nowY][nowX])
        continue;
      for (int i = 0; i < 4; ++i) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0)
          continue;
        if (blackRupee[nextY][nextX] > nowRupee + cave[nextY][nextX]) {
          blackRupee[nextY][nextX] = nowRupee + cave[nextY][nextX];
          q.offer(new pos(nextX, nextY, nowRupee + cave[nextY][nextX]));
        }
      }
    }
  }
  static final int INF = 987654321;
  static final int dx[] = {0, 0, -1, 1};
  static final int dy[] = {1, -1, 0, 0};
  static int N;
  static int cave[][];
  static int blackRupee[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;
      ++idx;
      cave = new int[N][N];
      blackRupee = new int[N][N];
      for (int i = 0; i < N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; ++j) {
          cave[i][j] = Integer.parseInt(st.nextToken());
          blackRupee[i][j] = INF;
        }
      }
      djikstra(0, 0);
      sb.append("Problem " + idx + ": " + blackRupee[N-1][N-1] + "\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}