// 벽 부수고 이동하기
import java.io.*;
import java.util.*;

public class B2206 {
  static class pos {
    int x;
    int y;
    int dist;
    boolean breakChance;
    pos (int x, int y, int dist, boolean breakChance) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.breakChance = breakChance;
    }
  }
  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };
  static void bfs(int startX, int startY) {
    Queue<pos> q = new LinkedList<>();
    q.offer(new pos(startX, startY, 1, true));
    visited[startY][startX][0] = true;
    while (!q.isEmpty()) {
      pos nowPos = q.poll();
      int nowX = nowPos.x;
      int nowY = nowPos.y;
      int nowDist = nowPos.dist;
      // 끝나는 칸에 도착했다면 종료
      if (nowX == M - 1 && nowY == N - 1) {
        minDist = nowDist;
        break;
      }
      boolean nowChance = nowPos.breakChance;
      for (int i = 0; i < 4; ++i) {
        int nextX = nowX + dx[i];
        int nextY = nowY + dy[i];
        if (nextX >= M || nextX < 0 || nextY >= N || nextY < 0) 
          continue;
        // 벽이 없는 경우
        if (map[nextY][nextX] == 0) {
          // 이전에 벽을 뚫지 않았던 경우
          if (nowChance && !visited[nextY][nextX][0]) {
            visited[nextY][nextX][0] = true;
            q.offer(new pos(nextX, nextY, nowDist + 1, true));
          }
          // 이전에 벽을 뚫었던 경우
          else if (!nowChance && !visited[nextY][nextX][1]) {
            visited[nextY][nextX][1] = true;
            q.offer(new pos(nextX, nextY, nowDist + 1, false));
          }
        }
        // 벽이 있는 경우
        else {
          // 이전에 벽을 뚫지 않았던 경우, 벽을 뚫을 수 있는 기회가 있다면 뚫고 지나감
          if (nowChance && !visited[nextY][nextX][0]) {
            visited[nextY][nextX][1] = true;
            q.offer(new pos(nextX, nextY, nowDist + 1, false));
          }
        }
      }
    }
  }
  
  static int N, M, map[][], minDist = -1;
  static boolean visited[][][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    // visited 배열을 선언할 때 [맵의 세로][맵의 가로][벽을 뚫었는지 여부]를 저장하는 3차원 배열로 선언하여
    // 벽을 허물고 방문한 경우와 벽을 허물지 않고 방문한 두 가지 경우를 분리해주어야 함
    // 그렇지 않을 경우, 벽을 허물지 않고 방문할 수 있는 지점에 
    // 벽을 허물고 방문 체크가 되어, 추가적으로 벽을 부수고 진행할 수 없게 되어 오답이 됨
    visited = new boolean[N][M][2];
    for (int i = 0; i < N; ++i) {
      String mapStr = br.readLine();
      for (int j = 0; j < M; ++j) {
        map[i][j] = mapStr.charAt(j) - '0';
      }
    }
    bfs(0, 0);
    bw.write(String.valueOf(minDist));
    bw.close();
    br.close();
  }
}