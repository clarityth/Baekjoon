import java.io.*;
import java.util.*;

public class B14500 {
  static int N, M;
  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };
  static int maxVal = 0;
  static int graph[][];
  static boolean visit[][];

  static void dfs(int x, int y, int depth, int sum) {
    if (depth == 4) {
      maxVal = Math.max(maxVal, sum);
      return;
    }
    for (int i = 0; i < 4; ++i) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if (nextX >= M || nextX < 0 || nextY >= N || nextY < 0)
        continue;
      if (!visit[nextY][nextX]) {
        // backtracking
        visit[nextY][nextX] = true;
        dfs(nextX, nextY, depth + 1, sum + graph[nextY][nextX]);
        visit[nextY][nextX] = false;
      }
    }
  }

  static void tetro1(int x, int y) {
    // ㅜ
    if (x + 2 >= M || x < 0 || y + 1 >= N || y < 0)
      return;
    int answer = 0;
    answer += graph[y][x] + graph[y][x + 1] + graph[y][x + 2] + graph[y + 1][x + 1];
    maxVal = Math.max(maxVal, answer);
  }

  static void tetro2(int x, int y) {
    // ㅗ
    if (x + 2 >= M || x < 0 || y - 1 < 0 || y >= N)
      return;
    int answer = 0;
    answer += graph[y][x] + graph[y][x + 1] + graph[y - 1][x + 1] + graph[y][x + 2];
    maxVal = Math.max(maxVal, answer);
  }

  static void tetro3(int x, int y) {
    // ㅓ
    if (x < 0 || x + 1 >= M || y - 1 < 0 || y + 1 >= N)
      return;
    int answer = 0;
    answer += graph[y][x] + graph[y][x + 1] + graph[y + 1][x + 1] + graph[y - 1][x + 1];
    maxVal = Math.max(maxVal, answer);
  }

  static void tetro4(int x, int y) {
    // ㅏ
    if (x < 0 || x + 1 >= M || y - 1 < 0 || y + 1 >= N)
      return;
    int answer = 0;
    answer += graph[y][x] + graph[y + 1][x] + graph[y - 1][x] + graph[y][x + 1];
    maxVal = Math.max(maxVal, answer);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N][M];
    visit = new boolean[N][M];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; ++j) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        // ㅗ 모양을 제외하고, 이 외의 모양들은 depth=4의 dfs의 탐색 순서와 동일함
        // backtracking을 사용해야하므로, bfs는 사용불가
        dfs(j, i, 0, 0);

        // ㅗ 모양 테트로미노를 회전시키며 최댓값 갱신
        tetro1(j, i);
        tetro2(j, i);
        tetro3(j, i);
        tetro4(j, i);
      }
    }
    bw.write(String.valueOf(maxVal));
    bw.flush();
    bw.close();
    br.close();
  }
}