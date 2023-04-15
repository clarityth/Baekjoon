// 행렬 제곱
import java.io.*;
import java.util.*;

public class B10830 {
  // a^n = a^n/2 * a^n/2을 이용해 분할 정복
  static long[][] matPow(long[][] a, long exp) {
    if (exp == 1l)
      return a;
    // 행렬의 지수를 절반씩 줄여가며 재귀 호출
    long[][] res = matPow(a, exp/2);
    res = matMul(res, res);
    // 지수가 홀수라면 원래 행렬을 한번 더 곱해줌
    if (exp % 2 == 1)
      res = matMul(res, input);
    return res;
  }
  
  static long[][] matMul(long[][] a, long[][] b) {
    long res[][] = new long[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j){
        for (int k = 0; k < N; ++k) {
          res[i][j] += a[i][k] * b[k][j];
          res[i][j] %= 1000l;
        }
      }
    }
    return res;
  }
  
  static StringBuilder sb;
  static int N; 
  static long B;
  static long[][] input;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    B = Long.parseLong(st.nextToken());
    input = new long[N][N];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        input[i][j] = Long.parseLong(st.nextToken()) % 1000l;
      }
    }
    long res[][] = matPow(input, B);
    sb = new StringBuilder();
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        sb.append(res[i][j] + " ");
      }
      sb.append("\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}