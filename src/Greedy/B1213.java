// 팰린드롬 만들기
import java.io.*;
import java.util.*;

public class B1213 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String engName = br.readLine();
    int engNameLen = engName.length();
    int cnt = engNameLen;
    int alpha[] = new int[26];
    int minIdx = engNameLen, maxIdx = 0;
    for (int i = 0; i < engNameLen; ++i) {
      int idx = engName.charAt(i) - 'A';
      alpha[idx]++;
      minIdx = Math.min(minIdx, idx);
      maxIdx = Math.max(maxIdx, idx);
    }
    
    char palinStr[] = new char[engNameLen];
    boolean isEven = engNameLen % 2 == 0 ? true : false;
    boolean isOddCame = false, isImpossible = false;
    int s = 0, e = engNameLen - 1;
    while (cnt > 0) {
      if (isImpossible)
        break;
      for (int i = minIdx; i <= maxIdx; ++i) {
        if (alpha[i] == 0) {
          minIdx = i;
          continue;
        }
        // 현재 알파벳이 홀수번 등장했다면
        if (alpha[i] % 2 == 1) {
          // 문자열의 길이가 짝수이거나 이전에 홀수번 등장한 알파벳이 있었다면 팰린드롬 생성 불가능 -> 종료
          if (isEven || isOddCame) {
            isImpossible = true;
            break;
          }
          isOddCame = true;
          // 팰린드롬 문자열의 가운데 자리에 홀수번 등장한 알파벳을 삽입
          palinStr[engNameLen / 2] = (char) ((int) 'A' + i);
          alpha[i]--;
          --cnt;
          break;
        }
        // 현재 알파벳이 짝수번 등장했다면
        else {
          // 현재 알파벳의 등장 갯수만큼 팰린드롬의 양쪽 끝을 채움
          while (alpha[i] > 0) {
            palinStr[s++] = (char) ((int) 'A' + i);
            palinStr[e--] = (char) ((int) 'A' + i);
            alpha[i] -= 2;
            cnt -= 2;
          }
          break;
        }
      }
    }
    bw.flush();
    if (isImpossible)
      bw.write("I'm Sorry Hansoo");
    else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < engNameLen; ++i) 
        sb.append(palinStr[i]);
      bw.write(sb.toString());
    }
    bw.close();
    br.close();
  }
}