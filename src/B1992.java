import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Character;

public class B1992 {
  public static int[][] video;
  public static int N;
  public static StringBuilder sb;

  public static void quadTree(int x, int y, int size) {
    int allOneFlag = 1, allZeroFlag = 1, breakFlag = 0;
    for (int i = y; i < y + size; i++) {
      for (int j = x; j < x + size; j++) {
        if (video[i][j] == 1)
          allZeroFlag = 0;
        else if (video[i][j] == 0)
          allOneFlag = 0;
        if (allZeroFlag == 0 && allOneFlag == 0) {
          breakFlag = 1;
          break;
        }
      }
      if (breakFlag == 1)
        break;
    }
    if (allZeroFlag == 1 && allOneFlag == 0) {
      sb.append("0");
    } else if (allOneFlag == 1 && allZeroFlag == 0) {
      sb.append("1");
    } else {
      sb.append("(");
      int newSize = size / 2;
      quadTree(x, y, newSize);
      quadTree(x + newSize, y, newSize);
      quadTree(x, y + newSize, newSize);
      quadTree(x + newSize, y + newSize, newSize);
      sb.append(")");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    video = new int[N + 1][N + 1];
    int allOneFlag = 1, allZeroFlag = 1, breakFlag = 0;
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        video[i][j] = Character.getNumericValue(str.charAt(j));      if (video[i][j] == 0)
          allOneFlag = 0;
        else
          allZeroFlag = 0;
      }
    }
    if (allOneFlag == 1 && allZeroFlag == 0) {
      System.out.println("1");
      System.exit(0);
    } else if (allZeroFlag == 1 && allOneFlag == 0) {
      System.out.println("0");
      System.exit(0);
    }
      
    sb = new StringBuilder();
    sb.append("(");
    quadTree(0, 0, N / 2);
    quadTree(N/2, 0, N/2);
    quadTree(0, N/2, N/2);
    quadTree(N/2, N/2, N/2);
    sb.append(")");
    System.out.println(sb);
  }
}
