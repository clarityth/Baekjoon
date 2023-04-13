import java.io.*;
import java.util.*;

public class B11660 {
  static int N, M, DP[][];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    DP = new int[N + 1][N + 1];
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; ++j) {
        int num = Integer.parseInt(st.nextToken());
        if (i == 1 && j == 1)
          DP[i][j] = num;
        else if (i == 1)
          DP[i][j] = num + DP[i][j - 1];
        else if (j == 1)
          DP[i][j] = num + DP[i - 1][j];
        else
          DP[i][j] = num + DP[i - 1][j] + DP[i][j - 1] - DP[i - 1][j - 1];
      }
    }
    for (int i = 1; i <= M; ++i) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      sb.append(DP[x2][y2] - DP[x1 - 1][y2] - DP[x2][y1 - 1] + DP[x1 - 1][y1 - 1] + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
