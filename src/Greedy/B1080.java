import java.io.*;
import java.util.*;

public class B1080 {
  static int N, M;
  static boolean matrixA[][], matrixB[][];

  static boolean isSameMatrix() {
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        if (matrixA[i][j] != matrixB[i][j])
          return false;
      }
    }
    return true;
  }

  static void operation(int x, int y) {
    for (int i = y; i < y + 3; ++i) {
      for (int j = x; j < x + 3; ++j) {
        if (matrixA[i][j])
          matrixA[i][j] = false;
        else
          matrixA[i][j] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    matrixA = new boolean[N][M];
    matrixB = new boolean[N][M];
    for (int i = 0; i < N; ++i) {
      String str = br.readLine();
      for (int j = 0; j < M; ++j) {
        if (str.charAt(j) == '1') {
          matrixA[i][j] = true;
        }
      }
    }
    for (int i = 0; i < N; ++i) {
      String str = br.readLine();
      for (int j = 0; j < M; ++j) {
        if (str.charAt(j) == '1') {
          matrixB[i][j] = true;
        }
      }
    }
    if (N < 3 || M < 3) {
      if (isSameMatrix())
        bw.write("0");
      else
        bw.write("-1");
      bw.flush();
      bw.close();
      br.close();
      System.exit(0);
    }
    int opCnt = 0;
    for (int i = 0; i < N - 2; ++i) {
      for (int j = 0; j < M - 2; ++j) {
        if (matrixA[i][j] != matrixB[i][j]) {
          operation(j, i);
          ++opCnt;
        }
      }
    }
    if (!isSameMatrix())
      bw.write("-1");
    else
      bw.write(String.valueOf(opCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}