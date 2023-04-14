// N과 M (12)
import java.io.*;
import java.util.*;

public class B15666 {
  static int N, M, input[], output[];
  static boolean visit[];
  static StringBuilder sb;
  static LinkedHashSet<String> set;

  static void sequence(int depth) {
    if (depth == M) {
      sb = new StringBuilder();
      for (int i = 0; i < M; ++i){
        sb.append(output[i] + " ");
      }
      set.add(sb.toString());
      return;
    }
    for (int i = 0; i < N; ++i){
      if (depth > 0 && output[depth - 1] > input[i])
        continue;
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
    output = new int[M];
    set = new LinkedHashSet<String>();
    sequence(0);
    for(String str : set){
      bw.write(str + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
