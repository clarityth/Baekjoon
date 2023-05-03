// 서로 다른 부분 문자열의 개수
import java.io.*;
import java.util.*;

public class B11478 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String S = br.readLine();
    int SLen = S.length();
    HashSet<String> hs = new HashSet<String>();
    // start index
    for (int i = 0; i < SLen; ++i) {
      String subString = "";
      // start index에서 한 글자씩 붙혀 부분 문자열을 만들고 set에 삽입 (이전에 만든 문자열을 재사용하므로 시간초과 되지 않음)
      for (int j = i; j < SLen; ++j) {
        subString += S.substring(j, j + 1);
        hs.add(subString);
      }
    }
    bw.flush();
    bw.write(String.valueOf(hs.size()));
    bw.close();
    br.close();
  }
}