import java.io.*;
import java.util.*;

public class B19941 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String str = br.readLine();
    boolean visit[] = new boolean[N];
    int maxPersonCnt = 0;
    for (int i = 0; i < N; ++i) {
      if (str.charAt(i) == 'P') {
        // 사람(P)을 발견했다면 사람의 인덱스 i 기준 i-K ~ i+K까지 순회하며 햄버거(H)를 탐색
        for (int chkIdx = i - K; chkIdx <= i + K; ++chkIdx) {
          if (chkIdx >= 0 && chkIdx < N) {
            if (str.charAt(chkIdx) == 'H' && !visit[chkIdx]) {
              maxPersonCnt++;
              visit[chkIdx] = true;
              break;
            }
          }
        }
      }
    }
    bw.write(String.valueOf(maxPersonCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}