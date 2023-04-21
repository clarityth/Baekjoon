 // 베르트랑 공준
import java.util.*;
import java.io.*;

public class B4948 {
  static void erato (int n) {
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
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    Vector<Integer> inputs = new Vector<>();
    int maxInput = 0;
    while (true) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0)
        break;
      if (input > maxInput)
        maxInput = input;
      inputs.add(input);
    }
    prime = new boolean[2 * maxInput + 1];
    erato(2 * maxInput);
    for (int i = 0; i < inputs.size(); ++i) {
      int cnt = 0;
      int n = inputs.get(i);
      // n보다 크고, 2n보다 작거나 같은 소수의 개수
      for (int j = n + 1; j <= 2 * n; ++j) {
        if (prime[j])
          ++cnt;
      }
      sb.append(cnt + "\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}
