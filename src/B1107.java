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
      // 고장난 버튼의 개수가 0보다 클때만 고장난 버튼을 입력받음
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; ++i) {
        brokenBtn[Integer.parseInt(st.nextToken())] = true;
      }
    }
    if (N == 100) {
      System.out.println("0");
      System.exit(0);
    }
    // res의 초깃값 = 처음 채널인 100에서부터 +, - 버튼을 눌러야하는 횟수
    int res = Math.abs(N - 100);
    int pressCnt = 0, channelLen = 0;

    for (int i = 0; i < 1000001; ++i) {
      int c = i;
      channelLen = 0;
      boolean isCanPress = true;
      // 0일때 예외처리
      if (c == 0) {
        if (brokenBtn[0]) {
          // 0 버튼이 고장난 경우
          isCanPress = false;
        } else {
          // 0 버튼이 고장나지 않은 경우
          channelLen = 1;
        }
      } else {
        // 각 자릿수의 버튼들을 전부 누를 수 있는지 체크
        while (c > 0) {
          if (brokenBtn[c % 10]) {
            // 버튼이 고장난 경우
            isCanPress = false;
            break;
          }
          c /= 10;
          ++channelLen;
        }
      }
      if (isCanPress && channelLen > 0) {
        // pressCnt = 인접한 수에서 시작해서 +, - 버튼을 눌러야 하는 횟수
        pressCnt = Math.abs(i - N);
        if (res > pressCnt + channelLen) {
          // 처음 채널(100)과 인접한 수에서 시작한 횟수 비교
          res = pressCnt + channelLen;
        }
      }
    }
    System.out.println(res);
  }
}