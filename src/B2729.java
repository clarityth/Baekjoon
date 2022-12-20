import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class B2729 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();
      BigInteger bin_A = new BigInteger(A, 2);
      BigInteger bin_B = new BigInteger(B, 2);
      BigInteger res = bin_A.add(bin_B);
      String bin_res = res.toString(2);
      sb.append(bin_res + "\n");
    }
    System.out.println(sb);
  }
}