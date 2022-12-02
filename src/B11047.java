import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A[] = new int[N + 1];
    int coinCnt = 0;
    for (int i = N - 1; i >= 0; i--) {
      A[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < N; i++) {
      if (K >= A[i]) {
        int j = 1;
        while (K - j * A[i] >= 0) {
          j++;
          coinCnt++;
        }
        K -= (j - 1) * A[i];
      }
    }
    System.out.println(coinCnt);
  }
}
