import java.io.*;
import java.util.*;
import java.awt.Point;

class garden {
  Point p;
  int price;

  garden(Point p, int price) {
    this.p = p;
    this.price = price;
  }
}

public class Main {
  static int checkAndGetPrice(Point a, Point b, Point c) {
    visit = new boolean[N][N];
    int totalPrice = prices[a.y][a.x] + prices[b.y][b.x] + prices[c.y][c.x];
    // 꽃을 심는 장소 체크
    visit[a.y][a.x] = true;
    if (!visit[b.y][b.x])
      visit[b.y][b.x] = true;
    else
      return -1;
    if (!visit[c.y][c.x])
      visit[c.y][c.x] = true;
    else
      return -1;

    // 꽃잎 체크
    for (int i = 0; i < 4; ++i) {
      if (!visit[a.y + dy[i]][a.x + dx[i]])
        visit[a.y + dy[i]][a.x + dx[i]] = true;
      else
        return -1;
      if (!visit[b.y + dy[i]][b.x + dx[i]])
        visit[b.y + dy[i]][b.x + dx[i]] = true;
      else
        return -1;
      if (!visit[c.y + dy[i]][c.x + dx[i]])
        visit[c.y + dy[i]][c.x + dx[i]] = true;
      else
        return -1;

      // 가격 계산
      totalPrice += prices[a.y + dy[i]][a.x + dx[i]] + prices[b.y + dy[i]][b.x + dx[i]]
          + prices[c.y + dy[i]][c.x + dx[i]];
    }
    return totalPrice;
  }

  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };
  static int N, minPrice = 987654321;
  static int prices[][];
  static boolean visit[][];
  static garden gardens[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    prices = new int[N][N];
    gardens = new garden[N * N];
    for (int i = 0; i < N * N; ++i) {
      gardens[i] = new garden(new Point(0, 0), 0);
    }
    int idx = 0;
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        prices[i][j] = Integer.parseInt(st.nextToken());
        // 꽃잎이 화단 밖으로 나가면 시드므로, 꽃을 심을 수 있는 범위 = (1,1) ~ (N-2,N-2)
        if (i >= 1 && i <= N - 2 && j >= 1 && j <= N - 2) {
          gardens[idx].price = prices[i][j];
          gardens[idx].p = new Point(j, i);
          ++idx;
        }
      }
    }
    // 임의의 세 좌표를 골라 브루트포스 시행
    for (int i = 0; i < idx - 2; ++i) {
      for (int j = i + 1; j < idx - 1; ++j) {
        for (int k = j + 1; k < idx; ++k) {
          int res = checkAndGetPrice(gardens[i].p, gardens[j].p, gardens[k].p);
          if (res != -1) {
            minPrice = Math.min(minPrice, res);
          }
        }
      }
    }
    bw.write(String.valueOf(minPrice));
    bw.flush();
    bw.close();
    br.close();
  }
}