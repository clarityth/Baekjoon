
// 골드바흐의 추측
import java.util.*;
import java.io.*;

public class B9020 {
  static void erato(int n) {
    Arrays.fill(prime, true);
    prime[0] = false;
    prime[1] = false;
    for (int i = 2; i <= Math.sqrt(n); ++i) {
      if (prime[i]) {
        for (int j = i * i; j <= n; j += i) {
          prime[j] = false;
        }
      }
    }
  }

  static boolean prime[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int[] inputs = new int[n];
    int maxInput = 0;
    for (int i = 0; i < n; ++i) {
      inputs[i] = Integer.parseInt(br.readLine());
      if (inputs[i] > maxInput)
        maxInput = inputs[i];
    }
    prime = new boolean[maxInput + 1];
    erato(maxInput);
    for (int i = 0; i < n; ++i) {
      int p1 = 0, p2 = 0;
      for (int j = 2; j <= inputs[i] / 2; ++j) {
        if (prime[j] && prime[inputs[i] - j]) {
          p1 = j;
          p2 = inputs[i] - j;
        }
      }
      sb.append(p1 + " " + p2 + "\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}
