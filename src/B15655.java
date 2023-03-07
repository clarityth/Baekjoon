import java.io.*;
import java.util.*;

public class B15655 {
  static int N, M;
  static StringBuilder sb;
  static void sequence(int[] input, boolean visit[], int depth, int r) {
    if (r == 0) {
      for (int i = 0; i < N; ++i) {
        if (visit[i]) {
          sb.append(input[i] + " ");
        }
      }
      sb.append("\n");
      return;
    }
    if (depth == N) {
      return;
    }
    
    visit[depth] = true;
    sequence(input, visit, depth + 1, r - 1);
    visit[depth] = false;
    sequence(input, visit, depth + 1, r);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int num[] = new int[N];
    for (int i = 0; i < N; ++i) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(num);
    boolean visit[] = new boolean[N];
    sb = new StringBuilder();
    sequence(num, visit, 0, M);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
