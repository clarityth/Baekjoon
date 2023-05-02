// 종이의 개수
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1780 {
  public static int[][] paper;
  public static int one = 0, zero = 0, minus = 0;

  public static void cut(int x, int y, int size) {
    if (size == 1) {
      if (paper[y][x] == 0)
        zero++;
      else if (paper[y][x] == 1)
        one++;
      else if (paper[y][x] == -1)
        minus++;
      return;
    }

    boolean containMinus = false, containOne = false, containZero = false, allSame = true;
    for (int i = y; i < y + size; i++) {
      for (int j = x; j < x + size; j++) {
        if (paper[i][j] == -1)
          containMinus = true;
        else if (paper[i][j] == 0)
          containZero = true;
        else if (paper[i][j] == 1)
          containOne = true;
        if ((containMinus && containZero) || (containMinus && containOne) || (containZero && containOne)) {
          allSame = false;
          break;
        }
      }
      if (!allSame)
        break;
    }
    if (!allSame) {
      int newSize = size / 3;
      cut(x, y, newSize);
      cut(x + newSize, y, newSize);
      cut(x + 2 * newSize, y, newSize);
      cut(x, y + newSize, newSize);
      cut(x + newSize, y + newSize, newSize);
      cut(x + 2 * newSize, y + newSize, newSize);
      cut(x, y + 2 * newSize, newSize);
      cut(x + newSize, y + 2 * newSize, newSize);
      cut(x + 2 * newSize, y + 2 * newSize, newSize);
    } else {
      if (containMinus)
        minus++;
      else if (containZero)
        zero++;
      else if (containOne)
        one++;
    }
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
    System.out.println(minus);
    System.out.println(zero);
    System.out.println(one);
  }
}
