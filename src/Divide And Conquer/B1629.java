// 곱셈
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
      // 지수를 절반으로 줄여가며 재귀 호출
      long x = power(n, exp / 2, mod);
      // 지수가 홀수일 경우 n을 한번 더 곱해주고, 모듈러 연산 수행
      if (exp % 2 == 1){
        // 모듈러 성질: (a*b)%c = (a%c * b%c)%c
        return (x * x % mod) * n % mod;
      }
      // 지수가 짝수일 경우
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