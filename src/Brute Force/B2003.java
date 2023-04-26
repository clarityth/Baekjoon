// 수들의 합 2
import java.io.*;
import java.util.*;

public class B2003 {
  static int N, M, A[];
  static long cnt = 0l;
  static void getNumOfCases(int M){
    for (int i = 0; i < N - 1; ++i) {
      if (A[i] == M) {
        ++cnt;
        continue;
      }
      int temp = A[i];
      for (int j = i + 1; j < N; ++j) {
        if (temp + A[j] > M)
          break;
        else if (temp + A[j] == M) {
          ++cnt;
          break;
        }
        else {
          temp += A[j];
        }
      }
    }
    // 포인터 두 개로 비교시 마지막 원소가 M인 경우를 검사하지 못하기에 추가적으로 검사
    if (A[N - 1] == M)
      ++cnt;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    getNumOfCases(M);
    bw.flush();
    bw.write(String.valueOf(cnt));
    bw.close();
    br.close();
  }
}