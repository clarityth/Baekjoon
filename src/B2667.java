import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Character;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
  public static int N, idx = 0;
  public static int[][] complex;
  public static ArrayList<Integer> complexCnt;
  public static boolean[][] visit;
  public static int[] dx = { 0, 0, -1, 1 };
  public static int[] dy = { 1, -1, 0, 0 };
  public static StringBuilder sb = new StringBuilder();

  public static void numbering(int x, int y) {
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(new int[] { x, y });
    visit[y][x] = true;
    int cnt = 1;
    while (!q.isEmpty()) {
      int[] currentPos = q.poll();
      int currentX = currentPos[0];
      int currentY = currentPos[1];
      for (int i = 0; i < 4; i++) {
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];
        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
          continue;
        if (!visit[nextY][nextX] && complex[nextY][nextX] == 1) {
          q.offer(new int[] { nextX, nextY });
          visit[nextY][nextX] = true;
          cnt++;
        }
      }
    }
    complexCnt.add(cnt);
  }

  public static void getConnectedComponent() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j] && complex[i][j] == 1) {
          numbering(j, i);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    complex = new int[N + 1][N + 1];
    visit = new boolean[N + 1][N + 1];
    complexCnt = new ArrayList<>();
    sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        complex[i][j] = Character.getNumericValue(str.charAt(j));
      }
    }
    getConnectedComponent();
    Collections.sort(complexCnt);
    sb.append(complexCnt.size() + "\n");
    for (int cnt : complexCnt)
      sb.append(cnt + "\n");
    System.out.println(sb);
  }
}
