// 동전 1
import java.io.*;
import java.util.*;

public class B2293 {
  static int n, k;

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
  
    DP[0] = 1;
    for (int i = 0; i < n; ++i) {
      for (int j = 1; j <= k; ++j) {
        if (coins[i] > j)
          continue;
        DP[j] += DP[j - coins[i]];
      }
    }
    bw.write(String.valueOf(DP[k]));
    bw.flush();
    bw.close();
    br.close();
  }
}