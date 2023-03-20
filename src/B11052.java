import java.io.*;
import java.util.*;

public class B11052 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    int prices[] = new int[N + 1];
    int DP[] = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; ++i) {
      prices[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= i; ++j){
        DP[i] = Math.max(prices[j] + DP[i-j], DP[i]);
      }
    }
    bw.write(String.valueOf(DP[N]));
    bw.flush();
    bw.close();
    br.close();
  }
}