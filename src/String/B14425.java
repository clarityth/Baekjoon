// 문자열 집합
import java.io.*;
import java.util.*;

public class B14425 {
  static int N, M;
  static HashSet<String> S;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    S = new HashSet<String>();
    for (int i = 0; i < N; ++i) {
      String str = br.readLine();
      S.add(str);
    }
    int cnt = 0;
    for (int i = 0; i < M; ++i) {
      String input = br.readLine();
      if (S.contains(input)) {
        ++cnt;
      }
    }
    bw.flush();
    bw.write(String.valueOf(cnt));
    bw.close();
    br.close();
  }
}