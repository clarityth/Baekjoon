import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class B1107 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] brokenBtn = new boolean[10];
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    if (M > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; ++i) {
        brokenBtn[Integer.parseInt(st.nextToken())] = true;
      }
    }
    if (N == 100) {
      System.out.println("0");
      System.exit(0);
    }
    int res = Math.abs(N - 100), pressCnt = 0, channelLen = 0;

    for (int i = 0; i < 1000001; ++i) {
      int c = i;
      channelLen = 0;
      boolean isCanPress = true;
      // 0일때 예외처리
      if (c == 0) {
        if (brokenBtn[0]) {
          channelLen = 0;
        } else {
          channelLen = 1;
        }
      }
      while (c > 0) {
        if (brokenBtn[c % 10])
          isCanPress = false;
        c /= 10;
        ++channelLen;
      }
      if (isCanPress) {
        pressCnt = Math.abs(i - N);
        if (res > pressCnt + channelLen) {
          res = pressCnt + channelLen;
        }
      }
    }
    System.out.println(res);
  }
}