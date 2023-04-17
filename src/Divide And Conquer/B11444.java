// 피보나치 수 6
import java.io.*;
import java.util.*;

public class B11444 {
  // a^n = a^n/2 * a^n/2을 이용해 분할 정복
  static long[][] matPow(long[][] a, long exp) {
    if (exp == 1l)
      return a;
    // 행렬의 지수를 절반씩 줄여가며 재귀 호출
    long[][] res = matPow(a, exp / 2);
    res = matMul(res, res);
    // 지수가 홀수라면 원래 행렬을 한번 더 곱해줌
    if (exp % 2 == 1)
      res = matMul(res, f1);
    return res;
  }
  
  static long[][] matMul(long[][] a, long[][] b) {
    long res[][] = new long[2][2];
    for (int i = 0; i < 2; ++i) {
      for (int j = 0; j < 2; ++j){
        for (int k = 0; k < 2; ++k) {
          res[i][j] += a[i][k] * b[k][j];
          res[i][j] %= 1000000007l;
        }
      }
    }
    return res;
  }
  
  static long N;
  static long[][] f1 = {{1l, 1l}, {1l, 0l}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Long.parseLong(br.readLine());
    // 피보나치 수를 행렬로 표현하면 다음과 같이 나타낼 수 있음 
    // (fn+1 fn) = (1 1)^n
    // (fn fn-1)   (1 0)
    // -> 따라서 초기 행렬의 n승을 하는 것으로 n번째 피보나치 수를 구하는 것이 가능
    long[][] res = matPow(f1, N);
    bw.flush();
    bw.write(String.valueOf(res[1][0]));
    bw.close();
    br.close();
  }
}