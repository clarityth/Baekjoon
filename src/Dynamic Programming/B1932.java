import java.io.*;
import java.util.*;

public class B1932 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int DP[][] = new int[n + 1][n + 1];

    for (int i = 1; i <= n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= i; j++) {
        DP[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int max = 0;
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        if (j == 1) {
          DP[i][j] = DP[i][j] + DP[i - 1][j];
        } else if (j == i) {
          DP[i][j] = DP[i][j] + DP[i - 1][j - 1];
        } else {
          DP[i][j] = DP[i][j] + Math.max(DP[i - 1][j - 1], DP[i - 1][j]);
        }
        if (DP[i][j] > max)
          max = DP[i][j];
      }
    }
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }
}
