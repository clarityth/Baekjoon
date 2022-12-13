import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

public class B17626 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] square = new int[4];
    int cnt = 4;
    for (int a = 1; a * a <= n; ++a) {
      if (a * a == n) {
        cnt = Math.min(cnt, 1);
      }
      for (int b = 1; a * a + b * b <= n; ++b) {
        if (a * a + b * b == n) {
          cnt = Math.min(cnt, 2);
        }
        for (int c = 1; a * a + b * b + c * c <= n; ++c) {
          if (a * a + b * b + c * c == n) {
            cnt = Math.min(cnt, 3);
          }
        }
      }
    }
    // for (int i = 0; i < 4; i++) {
    // System.out.print(square[i] + " ");
    // }
    System.out.println(cnt);
  }
}
