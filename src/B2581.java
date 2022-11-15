import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2581 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    boolean prime[] = new boolean[N + 1];
    Arrays.fill(prime, true);

    // 에라토스테네스의 체
    prime[0] = prime[1] = false;
    for (int i = 2; i * i <= N; i++) {
      if (prime[i]) {
        for (int j = i * i; j <= N; j += i)
          prime[j] = false;
      }
    }

    int primeSum = 0, minPrime = 0, primeFlag = 0;
    for (int i = M; i <= N; i++) {
      if (prime[i]) {
        primeSum += i;
        if (primeFlag == 0) {
          minPrime = i;
          primeFlag = 1;
        }
      }
    }

    if (primeFlag == 0) {
      System.out.println("-1");
    } else {
      System.out.println(primeSum);
      System.out.println(minPrime);
    }
  }
}