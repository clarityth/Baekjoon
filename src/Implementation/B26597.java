import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B26597 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int Q = Integer.parseInt(br.readLine());
    long min = -1 * (long) Math.pow(10, 18) - 1;
    long max = (long) Math.pow(10, 18) + 1;
    boolean isAppended = false, isParadox = false;
    int criticalQNum = 1;
    for (int i = 1; i <= Q; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      String special = st.nextToken();
      
      // 최댓값, 최솟값들의 범위를 줄여감
      if (special.equals("^")) 
        min = Math.max(x, min);
      else if (special.equals("v")) 
        max = Math.min(x, max);
      
      long diff = max - min;
      /* 질문에 나온 수는 정답이 아니므로, 차이가 2인 정수가 정답 
       -> 정답을 구한 이후에도 모순이 발생할 수 있으므로 break 하지 않음 */
      if (diff == 2 && !isAppended) {
        criticalQNum = i;
        isAppended = true;
      }
      else if ((diff < 2)){
      // 모순이 발생하지 않는다면, diff는 항상 2 이상이어야 함.
        bw.write("Paradox!\n" + String.valueOf(i));
        isParadox = true;
        break;
      }
    }
    if (!isAppended && !isParadox)
      bw.write("Hmm...");
    else if (isAppended && !isParadox)
      bw.write("I got it!\n" + String.valueOf(criticalQNum));
    bw.flush();
    bw.close();
    br.close();
  }
}