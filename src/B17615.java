import java.io.*;
import java.util.*;

public class B17615 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    String str = br.readLine();
    boolean isBlueAppeared = false;
    boolean isRedAppeared = false;
    int redLeftCnt = 0, redRightCnt = 0, blueLeftCnt = 0, blueRightCnt = 0;
    for (int i = 0; i < N; ++i) {
      char color = str.charAt(i);
      // 빨간공을 왼쪽으로 이동시키는 경우
      if (color == 'R'){
        isRedAppeared = true;
        if (isBlueAppeared) {
          redLeftCnt++;
        }
      // 파란공을 왼쪽으로 이동시키는 경우
      } else {
        isBlueAppeared = true;
        if (isRedAppeared){
          blueLeftCnt++;
        }
      }
    }
    isBlueAppeared = false;
    isRedAppeared = false;
    for (int i = N-1; i >= 0; --i) {
      char color = str.charAt(i);
      // 빨간공을 오른쪽으로 이동시키는 경우
      if (color == 'R'){
        isRedAppeared = true;
        if (isBlueAppeared) {
          redRightCnt++;
        }
      // 파란공을 오른쪽으로 이동시키는 경우
      } else {
        isBlueAppeared = true;
        if (isRedAppeared){
          blueRightCnt++;
        }
      }
    }
    int minCnt = Math.min(blueRightCnt, Math.min(blueLeftCnt, Math.min(redRightCnt, redLeftCnt)));
    bw.write(String.valueOf(minCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}