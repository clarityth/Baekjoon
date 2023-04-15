// 약수 구하기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

public class B2501 {
  public static int getDivisor(int N, int K) {
    // 효율적으로 약수 찾는 법 -> 제곱근까지 약수를 찾은 뒤, 해당 제곱근으로 수를 나누어줌
    Vector<Integer> divisors = new Vector<Integer>();
    for (int i = 1; i <= Math.sqrt(N); ++i) {
      if (N % i == 0) {
        divisors.add(i);
        // 중복 제거
        if (i != N / i)
          divisors.add(N / i);
      }
    }
    // 정렬
    Collections.sort(divisors);
    if (divisors.size() < K)
      return 0;
    else
      return divisors.get(K - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    bw.write(String.valueOf(getDivisor(N, K)));
    bw.flush();
    bw.close();
    br.close();
  }
}