import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

public class B3933 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = -1;
    while (n != 0) {
      n = Integer.parseInt(br.readLine());
      if (n == 0)
        break;
      int cnt = 0;
      for (int a = 1; a * a <= n; ++a) {
        if (a * a == n) {
          cnt++;
          continue;
        }
        for (int b = a; a * a + b * b <= n; ++b) {
          if (a * a + b * b == n) {
            cnt++;
            break;
          }
          else if (a * a + b * b > n)
            break;
          for (int c = b; a * a + b * b + c * c <= n; ++c) {
            if (a * a + b * b + c * c == n) {
              cnt++;
              break;
            }
            else if (a * a + b * b + c * c> n)
              break;
            for (int d = c; a * a + b * b + c * c + d * d <= n; ++d) {
              if (a * a + b * b + c * c + d * d == n) {
                cnt++;
                break;
              }
              else if (a * a + b * b + c * c + d * d > n)
                break;
            }
          }
        }
      }
      sb.append(cnt + "\n");
    }
    System.out.println(sb);
  }
}