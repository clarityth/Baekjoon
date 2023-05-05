// 영역 구하기
import java.io.*;
import java.util.*;
import java.awt.Point;

public class B2583 {
  static int M, N, K;
  static LinkedList<Integer> cnts;
  static boolean visit[][];
  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };

  public static int bfs(int startX, int startY) {
    int cnt = 1;
    Queue<Point> q = new LinkedList<Point>();
    q.offer(new Point(startX, startY));
    visit[startY][startX] = true;

    while (!q.isEmpty()) {
      Point currentPos = q.poll();
      int currentX = currentPos.x;
      int currentY = currentPos.y;
      for (int i = 0; i < 4; ++i) {
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];
        if (nextY >= M || nextY < 0 || nextX >= N || nextX < 0)
          continue;
        if (!visit[nextY][nextX]) {
          visit[nextY][nextX] = true;
          ++cnt;
          q.offer(new Point(nextX, nextY));
        }
      }
    }
    return cnt;
  }

  public static int getIndependentAreaCnt() {
    int independentAreaCnt = 0;
    for (int i = 0; i < M; ++i) {
      for (int j = 0; j < N; ++j) {
        if (!visit[i][j]) {
          cnts.add(bfs(j, i));
          ++independentAreaCnt;
        }
      }
    }
    return independentAreaCnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    // 세로
    N = Integer.parseInt(st.nextToken());
    // 가로
    K = Integer.parseInt(st.nextToken());
    visit = new boolean[M][N];
    cnts = new LinkedList<Integer>();
    for (int i = 0; i < K; ++i) {
      st = new StringTokenizer(br.readLine());
      int leftBottomX = Integer.parseInt(st.nextToken());
      int leftBottomY = Integer.parseInt(st.nextToken());
      int rightTopX = Integer.parseInt(st.nextToken());
      int rightTopY = Integer.parseInt(st.nextToken());
      for (int j = leftBottomY; j < rightTopY; ++j) {
        for (int k = leftBottomX; k < rightTopX; ++k) {
          // 좌표계가 1사분면이므로 (좌측 하단이 0,0), 배열의 형태에 맞게 변환하여 직사각형 영역 방문 처리
          visit[M - 1 - j][k] = true;
        }
      }
    }
    bw.write(String.valueOf(getIndependentAreaCnt()) + "\n");
    Collections.sort(cnts);
    for (Integer cnt : cnts) {
      bw.write(String.valueOf(cnt) + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}