import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B3460 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for(int i = 0; i < T; ++i){
      int N = Integer.parseInt(br.readLine());
      int power = 1;
      for(int j = 0; j < N; ++j){
        if (power > N)
          break;
        if ((N & power) == power)
          sb.append(j + " ");
        power *= 2;
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}