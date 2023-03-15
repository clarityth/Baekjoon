import java.io.*;
import java.util.*;

public class B11404 {
  static final int INF = 987654321;
  static int N, M, busFare[][];

  static void floyd() {
    for (int k = 1; k <= N; ++k) {
      for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
          if (i == j)
            continue;
          if (busFare[i][j] > busFare[i][k] + busFare[k][j]) {
            busFare[i][j] = busFare[i][k] + busFare[k][j];
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    busFare = new int[N + 1][N + 1];
    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        if (i == j)
          continue;
        busFare[i][j] = INF;
      }
    }
    for (int i = 0; i < M; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      if (busFare[start][end] < cost) {
        continue;
      }
      busFare[start][end] = cost;
    }
    floyd();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        if (busFare[i][j] == INF) {
          sb.append("0");
        } else {
          sb.append(busFare[i][j]);
        }
        sb.append(" ");
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
