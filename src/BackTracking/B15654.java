// N과 M (5)
import java.io.*;
import java.util.*;

public class B15654 {
  static int N, M;
  static StringBuilder sb;
  static void sequence(int[] input, int[] output, boolean visit[], int depth) {
    if (depth == M) {
      for (int i = 0; i < M; ++i) {
        sb.append(output[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < N; ++i) {
      if (!visit[i]) {
        visit[i] = true;
        output[depth] = input[i];
        sequence(input, output, visit, depth + 1);
        visit[i] = false;
      }
    }
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
    int output[] = new int[M];
    boolean visit[] = new boolean[N];
    sb = new StringBuilder();
    sequence(num, output, visit, 0);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
