// 괄호의 값 비교
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class B22343 {
  public static int maxSize;
  public static void getBinaryValue(String s, int[] v) {
    int idx = 0;
    for (int i = 0; i < s.length(); ++i) {
      char bracket = s.charAt(i);
      if (bracket == '(') {
        ++idx;
      } else {
        --idx;
        if (s.charAt(i - 1) == '(') {
          ++v[idx];
        }
      }
    }
    for (int i = 0; i < v.length - 1; ++i) {
    // 역순으로 저장되어 있으므로 인덱스 0부터 이진법에 맞게 변환
      if (v[i] < 2)
        continue;
      v[i + 1] += (v[i] >> 1);
      v[i] %= 2;
    }
  }

  public static int compareValues(int[] v1, int[] v2) {
    for (int i = maxSize - 1; i >= 0; --i) {
      if (v1[i] > v2[i])
        return 1;
      else if (v1[i] < v2[i])
        return -1;
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      String inputStr1 = br.readLine();
      String inputStr2 = br.readLine();
      maxSize = Math.max(inputStr1.length(), inputStr2.length());
      // 서브 테스크 3부터는 수의 범위가 long을 초과 -> 이진법으로 작은 자리수부터 배열에 역순으로 저장
      int[] value1 = new int[maxSize];
      int[] value2 = new int[maxSize];
      getBinaryValue(inputStr1, value1);
      getBinaryValue(inputStr2, value2);
      // 괄호의 값 확인
      // boolean flag = false;
      // for(int j=maxSize-1; j>=0; --j){
      // if (value1[j] != 0)
      // flag = true;
      // if (flag)
      // System.out.print(value1[j]);
      // }
      // System.out.println();
      // flag = false;
      // for(int j=maxSize-1; j>=0; --j){
      // if (value2[j] != 0)
      // flag = true;
      // if (flag)
      // System.out.print(value2[j]);
      // }
      // System.out.println();
      int compareRes = compareValues(value1, value2);
      if (compareRes == 1)
        sb.append(">\n");
      else if (compareRes == -1)
        sb.append("<\n");
      else
        sb.append("=\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}