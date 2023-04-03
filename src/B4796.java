import java.io.*;
import java.util.*;

public class Main {

  public static void B4796(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    int caseIdx = 1;
    while (!str.equals("0 0 0")) {
      StringTokenizer st = new StringTokenizer(str);
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      // V % P가 L보다 작을 경우가 존재
      int res = (V / P * L) + Math.min(V % P, L);
      sb.append("Case " + caseIdx++ + ": " + res + "\n");
      str = br.readLine();
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}