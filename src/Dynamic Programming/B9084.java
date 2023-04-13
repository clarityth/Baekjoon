import java.io.*;
import java.util.*;

public class B9084 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int coin[] = new int[N + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; ++i) {
        coin[i] = Integer.parseInt(st.nextToken());
      }
      int M = Integer.parseInt(br.readLine());
      int DP[] = new int[M + 1];
      DP[0] = 1;
      for (int i = 0; i < N; ++i) {
        for (int j = 1; j <= M; ++j) {
          if (coin[i] <= j) {
            DP[j] += DP[j - coin[i]];
          }
        }
      }
      sb.append(DP[M] + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}