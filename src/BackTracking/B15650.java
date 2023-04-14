// N과 M (2)
import java.io.*;
import java.util.*;

public class B15650 {
  static int N, M;
  static StringBuilder sb;

  static void combi(int num[], int depth, boolean visit[], int idx, int r) {
    if (r == 0) {
      for (int i = 0; i < N; ++i) {
        if (visit[i])
          sb.append(num[i] + " ");
      }
      sb.append("\n");
      return;
    }
    if (depth == N)
      return;
    visit[depth] = true;
    // backtracking
    // 해당 인덱스의 원소를 골랐을 때
    combi(num, depth + 1, visit, idx, r - 1);
    visit[depth] = false;
    // 해당 인덱스의 원소를 고르지 않았을 때
    combi(num, depth + 1, visit, idx, r);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int num[] = new int[N];
    boolean visit[] = new boolean[N];
    for (int i = 0; i < N; ++i) {
      num[i] = i + 1;
    }
    combi(num, 0, visit, N, M);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
