// N과 M (9)
import java.io.*;
import java.util.*;

public class B15663 {
  static int N, M, input[], output[];
  static boolean visit[];
  static StringBuilder sb;
  static LinkedHashSet<String> set;

  static void sequence(int depth) {
    if (depth == M) {
      sb = new StringBuilder();
      for (int num : output) {
        sb.append(num + " ");
      }
      set.add(sb.toString());
      return;
    }
    for (int i = 0; i < N; ++i) {
      if (visit[i])
        continue;
      visit[i] = true;
      output[depth] = input[i];
      sequence(depth + 1);
      visit[i] = false;
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
    visit = new boolean[N];
    set = new LinkedHashSet<String>();
    // 오름차순 유지를 위해 그냥 HashSet이 아닌 LinkedHashSet을 사용
    sequence(0);
    set.forEach(System.out::println);
    bw.flush();
    bw.close();
    br.close();
  }
}
