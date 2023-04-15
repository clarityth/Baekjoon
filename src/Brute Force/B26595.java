// 전투의 신
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B26595 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Integer.parseInt(st.nextToken());
    long PA = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());
    long PB = Integer.parseInt(st.nextToken());
    long maxStatus = 0, maxACnt = 0, maxBCnt = 0;

    for (int i = 0; i <= N; ++i) {
      long ACnt = (N-i) / PA;
      long BCnt = i / PB;
      long pay = PA * ACnt + PB * BCnt;
      if (pay > N)
        continue;
      long status = A * ACnt + B * BCnt;
      if (status > maxStatus) {
        maxStatus = status;
        maxACnt = ACnt;
        maxBCnt = BCnt;
      }
    }
    bw.write(String.valueOf(maxACnt) + " " + String.valueOf(maxBCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}