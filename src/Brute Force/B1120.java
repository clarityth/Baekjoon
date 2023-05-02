// 문자열
import java.io.*;
import java.util.*;

public class B1120 {
  static String A, B;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = st.nextToken();
    B = st.nextToken();
    int ALen = A.length();
    int BLen = B.length();
    int diff = 0;
    // 두 문자열의 길이가 같다면 연산을 진행할 수 없으므로, 바로 차이를 계산
    if (ALen == BLen) {
      for (int i = 0; i < ALen; ++i) {
        if (A.charAt(i) != B.charAt(i))
          ++diff;
      }
    }
    else {
      int maxSameCnt = 0;
      // prefix
      for (int i = 0; i <= BLen - ALen; ++i) {
        int sameCnt = 0;
        for (int j = 0; j < ALen; ++j) {
          // B의 문자열 범위 내에서 A를 움직여가며 해당 배치에서 같은 문자가 최대 몇개 존재할 수 있는지 검사
          // ex) aababbc
          //     adaabc
          //      adaabc
          if (A.charAt(j) == B.charAt(i + j))
            sameCnt++;
        }
        maxSameCnt = Math.max(maxSameCnt, sameCnt);
      }
      // 최소 차이 = A의 길이 - 같은 문자의 갯수의 최댓값
      diff = ALen - maxSameCnt;
    }
    bw.flush();
    bw.write(String.valueOf(diff));
    bw.close();
    br.close();
  }
}