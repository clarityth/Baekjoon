import java.io.*;
import java.util.*;

public class B15656 {
  static int N, M, input[], output[];
  static boolean visit[];
  static StringBuilder sb;
  static LinkedHashSet<String> set;

  static void sequence(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; ++i) {
        sb.append(output[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < N; ++i) {
      output[depth] = input[i];
      sequence(depth + 1);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    input = new int[N];
    for (int i = 0; i < N; ++i) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(input);
    sb = new StringBuilder();
    output = new int[M];
    sequence(0);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
