import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class B5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<T; ++i){
      String function = br.readLine();
      int n = Integer.parseInt(br.readLine());
      String arrayStr = br.readLine();
      // [] 특수문자 삭제
      arrayStr = arrayStr.substring(1, arrayStr.length()-1);
      String[] element = arrayStr.split(",");
      boolean isReversed = false, isBreaked = false;
      int firstIdx = 0, lastIdx = n-1;
      for(int j=0; j<function.length(); ++j){
        if (function.charAt(j) == 'R'){
          if (isReversed){
            isReversed = false;
          }
          else {
            isReversed = true;
          }
        }
        else if (function.charAt(j) == 'D'){
          if (n <= 0) {
            sb.append("error\n");
            isBreaked = true;
            break;
          } 
          else {
            if (isReversed){
              --lastIdx;
            }
            else {
              ++firstIdx;
            }
            --n;
          }
        }
      }
      if (isBreaked)
        continue;
      sb.append("[");
      if (isReversed) {
        for(int j = lastIdx; j >= firstIdx; --j){
          sb.append(element[j]);
          if (j != firstIdx){
            sb.append(",");
          }
        }
      }
      else {
        for(int j = firstIdx; j <= lastIdx; ++j){
          sb.append(element[j]);
          if (j != lastIdx) {
            sb.append(",");
          }
        }
      }
      sb.append("]\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}