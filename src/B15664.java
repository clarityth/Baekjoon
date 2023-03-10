import java.io.*;
import java.util.*;

public class B15664 {
  static int N, M, input[], output[];
  static boolean visit[];
  static StringBuilder sb;
  static LinkedHashSet<String> set;

  static void sequence(int depth, int r) {
    if (r == 0) {
      sb = new StringBuilder();
      for (int i = 0; i < N; ++i) {
        if (visit[i])
          sb.append(input[i] + " ");
      }
      sb.append("\n");
      set.add(sb.toString());
      return;
    }
    if (depth == N)
      return;
    
    visit[depth] = true;
    sequence(depth + 1, r - 1);
    visit[depth] = false;
    sequence(depth + 1, r);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    input = new int[N];
    for (int i = 0; i < N; ++i)
      input[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(input);
    set = new LinkedHashSet<String>();
    visit = new boolean[N];
    sequence(0, M);
    for (String ans : set)
      bw.write(ans);
    bw.flush();
    bw.close();
    br.close();
  }
}
