import java.io.*;
import java.util.*;
import java.awt.Point;

class shark {
  Point point;
  int cnt;

  shark(Point point, int cnt) {
    this.point = point;
    this.cnt = cnt;
  }
}

public class B16236 {
  // 상좌우하 순으로 이동
  static final int[] dx = { 0, -1, 1, 0 };
  static final int[] dy = { 1, 0, 0, -1 };
  static int N, sharkSize = 2, eatingCnt = 0, totalTime = 0;
  static int sizes[][];
  static Point sharkPos;
  static Queue<shark> q;
  static boolean visit[][], stop, eat;

  static void bfs(int startX, int startY) {
    q.offer(new shark(new Point(startX, startY), 0));
    visit[startY][startX] = true;
    int temp = 0;
    while (!q.isEmpty()) {
      shark now = q.poll();
      Point nowPos = now.point;
      int nowX = nowPos.x;
      int nowY = nowPos.y;
      int cnt = now.cnt;
      if (sizes[nowY][nowX] > 0 && sharkSize > sizes[nowY][nowX] && cnt == temp) {
        if (sharkPos.y > nowY || (sharkPos.y == sharkPos.y && sharkPos.x > nowX)) {
          // 위쪽 다음 왼쪽 순으로 먹기 위해 물고기를 먹은 상어의 좌표 저장
          sharkPos.y = nowY;
          sharkPos.x = nowX;
          continue;
        }
      }
      // 좌표 이동
      for (int i = 0; i < 4; ++i) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
          continue;
        if (!visit[nextY][nextX]) {
          // 지나가는 것이 가능한 경우
          if (sharkSize >= sizes[nextY][nextX]) {
            // 물고기를 먹을 수 있는 경우
            if (!eat && sizes[nextY][nextX] > 0 && sharkSize > sizes[nextY][nextX]) {
              eat = true;
              temp = cnt + 1;
              totalTime += temp;
              sharkPos.x = nextX;
              sharkPos.y = nextY;
            }
            // 물고기를 못 먹은 경우이거나 먹으러 가는 경우
            else {
              q.offer(new shark(new Point(nextX, nextY), cnt + 1));
              visit[nextY][nextX] = true;
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
    sizes = new int[N][N];
    sharkPos = new Point(0, 0);
    q = new LinkedList<shark>();
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        sizes[i][j] = Integer.parseInt(st.nextToken());
        if (sizes[i][j] == 9) {
          sharkPos.x = j;
          sharkPos.y = i;
          sizes[i][j] = 0;
        }
      }
    }
    while (!stop) {
      visit = new boolean[N][N];
      bfs(sharkPos.x, sharkPos.y);
      if (eat) {
        sizes[sharkPos.y][sharkPos.x] = 0;
        eat = false;
        ++eatingCnt;
        if (eatingCnt == sharkSize) {
          ++sharkSize;
          eatingCnt = 0;
        }
      } else {
        stop = true;
      }
    }
    bw.write(String.valueOf(totalTime));
    bw.flush();
    bw.close();
    br.close();
  }
}