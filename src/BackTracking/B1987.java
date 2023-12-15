
// 알파벳
import java.io.*;
import java.util.*;

public class B1987 {
  static final int dx[] = { 0, 0, -1, 1 };
  static final int dy[] = { 1, -1, 0, 0 };
  static boolean visited[][], alpha[];
  static char board[][];
  static int maxCnt = 1, C, R;

  static void getMaxCnt(int x, int y, int cnt) {
    for (int i = 0; i < 4; ++i) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || nx >= C || ny < 0 || ny >= R)
        continue;
      if (!visited[ny][nx] && !alpha[board[ny][nx] - 'A']) {
        visited[ny][nx] = true;
        alpha[board[ny][nx] - 'A'] = true;
        getMaxCnt(nx, ny, cnt + 1);
        visited[ny][nx] = false;
        alpha[board[ny][nx] - 'A'] = false;
      }
      if (cnt > maxCnt)
        maxCnt = cnt;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken()); // 세로
    C = Integer.parseInt(st.nextToken()); // 가로
    board = new char[R][C];
    alpha = new boolean[26];
    visited = new boolean[R][C];
    for (int i = 0; i < R; ++i) {
      String str = br.readLine();
      board[i] = str.toCharArray();
    }
    visited[0][0] = true;
    alpha[board[0][0] - 'A'] = true;
    getMaxCnt(0, 0, 1);
    bw.flush();
    bw.write(String.valueOf(maxCnt));
    bw.close();
    br.close();
  }
}