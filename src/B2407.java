import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class B2407 {
  static BigInteger DP[][];
  static void combi(int n, int m){
    for (int i = 1; i <= n; ++i){
      for (int j = 0; j <= i; ++j){
        if (j == 0 || i == j)
          DP[i][j] = new BigInteger("1");
        else
          // nCm = n-1Cm-1 + n-1Cm
          DP[i][j] = DP[i - 1][j - 1].add(DP[i - 1][j]);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    DP = new BigInteger[n + 1][n + 1];
    combi(n, m);
    bw.write(DP[n][m].toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
