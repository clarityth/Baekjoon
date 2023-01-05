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
    boolean isAppended = false, isFinalized = false;
    int criticalQNum = 1;
    for (int i = 1; i <= Q; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      String special = st.nextToken();
      if (special.equals("^")) 
        min = Math.max(x, min);
      
      else if (special.equals("v")) 
        max = Math.min(x, max);
      
      long diff = max - min;
      if (diff == 2 && !isAppended) {
        criticalQNum = i;
        isAppended = true;
      }
      else if ((diff < 2)){
        bw.write("Paradox!\n" + String.valueOf(i));
        isFinalized = true;
        break;
      }
    }
    if (!isAppended && !isFinalized)
      bw.write("Hmm...");
    else if (isAppended && !isFinalized)
      bw.write("I got it!\n" + String.valueOf(criticalQNum));
    bw.flush();
    bw.close();
    br.close();
  }
}