import java.io.*;
import java.util.*;

class num {
  int cnt;
  int before;

  num(int cnt, int before) {
    this.cnt = cnt;
    this.before = before;
  }
}

public class B12852 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    if (N == 1) {
      bw.write("0\n1");
      bw.flush();
      bw.close();
      br.close();
      System.exit(0);
    }
    num dp[] = new num[N + 1];
    for (int i = 0; i < N + 1; ++i) {
      dp[i] = new num(0, 0);
    }

    for (int i = 2; i <= N; ++i) {
      dp[i].cnt = dp[i - 1].cnt + 1;
      dp[i].before = i - 1;
      if (i % 2 == 0) {
        if (dp[i].cnt > dp[i / 2].cnt + 1) {
          dp[i].cnt = dp[i / 2].cnt + 1;
          dp[i].before = i / 2;
        }
      }
      if (i % 3 == 0) {
        if (dp[i].cnt > dp[i / 3].cnt + 1) {
          dp[i].cnt = dp[i / 3].cnt + 1;
          dp[i].before = i / 3;
        }
      }
    }
    bw.write(dp[N].cnt + "\n");
    int idx = N;
    bw.write(String.valueOf(N) + " ");
    while (dp[idx].before != 1) {
      bw.write(dp[idx].before + " ");
      idx = dp[idx].before;
    }
    bw.write(String.valueOf(1));
    bw.flush();
    bw.close();
    br.close();
  }
}