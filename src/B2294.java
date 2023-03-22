import java.io.*;
import java.util.*;

public class B2294 {
  static int n, k;
  static final int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int coins[] = new int[n];
    int DP[] = new int[k + 1];
    for (int i = 0; i < n; ++i) 
      coins[i] = Integer.parseInt(br.readLine());
    
    for (int i = 0; i <= k; ++i)
      DP[i] = INF;
    
    for (int i = 0; i < n; ++i) {
      for (int j = 1; j <= k; ++j) {
        if (coins[i] > j)
          continue;
        if (j % coins[i] == 0)
          DP[j] = Math.min(DP[j], j / coins[i]);
        DP[j] = Math.min(DP[j], DP[j - coins[i]] + 1);
      }
    }
    if (DP[k] == INF)
      bw.write("-1");
    else
      bw.write(String.valueOf(DP[k]));
    bw.flush();
    bw.close();
    br.close();
  }
}