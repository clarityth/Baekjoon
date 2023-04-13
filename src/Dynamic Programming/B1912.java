import java.io.*;
import java.util.*;

public class B1912 {
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    int seq[] = new int[n];
    int dp[] = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      seq[i] = Integer.parseInt(st.nextToken());
    }
    int max = dp[0] = seq[0];
    for (int i = 1; i < n; ++i) {
      dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]); 
      max = Math.max(dp[i], max);
    }
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }
}