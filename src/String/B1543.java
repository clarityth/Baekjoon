// 문서 검색
import java.io.*;
import java.util.*;

public class B1543 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String doc = br.readLine();
    int docLen = doc.length();
    String word = br.readLine();
    int wordLen = word.length();
    int i, j, cnt = 0;
    for (i = 0; i < docLen; ++i) {
      if (word.charAt(0) == doc.charAt(i)) {
        boolean isSame = true;
        for (j = 1; j < wordLen; ++j) {
          if (i + j >= docLen) {
            isSame = false;
            break;
          }
          if (word.charAt(j) != doc.charAt(i + j)) {
            isSame = false;
            break;
          }
        }
        if (isSame) {
          ++cnt;
          i = i + j - 1;
        }
      }
    }
    bw.flush();
    bw.write(String.valueOf(cnt));
    bw.close();
    br.close();
  }
}