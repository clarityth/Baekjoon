import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1629 {
  public static long power(long n, long exp, long mod){
    if (exp == 1)
      return n % mod;

    else {
      long x = power(n, exp/2, mod);
      if (exp % 2 == 1){
        return (x * x % mod) * n % mod;
      }
      else {
        return x * x % mod;
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    bw.write(String.valueOf(power(a, b, c)));
    bw.flush();
    bw.close();
    br.close();
  }
}