import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] paper;
  public static int blue = 0, white = 0;

  public static void cut(int x, int y, int size) {
    int allBlue = 1, allWhite = 1;
    for (int i = y; i < y + size; i++) {
      for (int j = x; j < x + size; j++) {
        if (paper[i][j] == 0)
          allBlue = 0;
        else
          allWhite = 0;
      }
    }
    if (allBlue == 1) {
      blue++;
      return;
    } else if (allWhite == 1) {
      white++;
      return;
    }
    cut(x, y, size / 2); // 1사분면 탐색
    cut(x + size / 2, y, size / 2); // 2사분면 탐색
    cut(x, y + size / 2, size / 2); // 3사분면 탐색
    cut(x + size / 2, y + size / 2, size / 2); // 4사분면 탐색
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cut(0, 0, N);
    System.out.println(white);
    System.out.println(blue);
  }
}