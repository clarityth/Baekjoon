import java.io.*;
import java.util.*;

public class B21314 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String MK = br.readLine();
    StringBuilder min = new StringBuilder();
    StringBuilder max = new StringBuilder();
    int mCnt = 0;
    for (int i = 0; i < MK.length(); ++i) {
      if (MK.charAt(i) == 'K') {
        // max: 먼저 5를 append한 후, mCnt 숫자 만큼 0을 append
        max.append(5);
        for (int j = 0; j < mCnt; ++j) {
          max.append(0);
        }
        
        // min: 5를 append
        min.append(5);
        mCnt = 0;
      } 
      else {
        if (mCnt == 0)
        // min: mCnt가 없다면(K가 이전에 나와서 append가 이미 되었다면) 1을, 있다면 0을 append
          min.append(1);
        else
          min.append(0);
        mCnt++;
      }
    }
    // 마지막 문자가 M일 경우, max 문자열 작성이 끝까지 되지 않음 -> 남아 있는 mCnt만큼 max에 1을 append
    if (mCnt > 0) {
      for (int i = 0; i < mCnt; ++i) {
        max.append(1);
      }
    }
    bw.write(max.toString() + "\n" + min.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}