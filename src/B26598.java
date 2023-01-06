import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

public class B26598 {
  public static final int[] dx = {0, 0, -1, 1};
  public static final int[] dy = {1, -1, 0, 0};
  public static int N, M;
  public static char[][] paper;
  public static boolean[][] visit;
  
  public static boolean bfs(int x, int y, char compareChar) {
    int cnt = 1, maxX = x, maxY = y;
    Queue<Point> q = new LinkedList<Point>();
    q.offer(new Point(x, y));
    visit[y][x] = true;

    while (!q.isEmpty()){
      Point curP = q.poll();
      int curX = curP.x;
      int curY = curP.y;
      for (int i = 0; i < 4; ++i){
        int nextX = curX + dx[i];
        int nextY = curY + dy[i];
        if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
          continue;
        if (paper[nextY][nextX] == compareChar && !visit[nextY][nextX]) {
          ++cnt;
          q.offer(new Point(nextX, nextY));
          visit[nextY][nextX] = true;
          maxX = Math.max(nextX, maxX);
          maxY = Math.max(nextY, maxY);
        }
      }
    }
    // 직사각형의 넓이 = 가로*세로임을 이용해, 구한 색종이가 직사각형 모양인지를 반환
    return cnt == ((maxX-x+1) * (maxY-y+1)); 
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    paper = new char[N][M];
    visit = new boolean[N][M];
    for (int i = 0; i < N; ++i){
      String str = br.readLine();
      for (int j = 0; j < M; ++j){
        paper[i][j] = str.charAt(j);
      }
    }
    boolean isBreaked = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; ++i){
      for (int j = 0; j < M; ++j){
        if (!visit[i][j] && !bfs(j, i, paper[i][j])) {
          sb.append("BaboBabo");
          isBreaked = true;
          break;
        }
      }
      if (isBreaked)
        break;
    }
    if (sb.length() == 0)
      sb.append("dd");
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}