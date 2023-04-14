// N-Queen
import java.io.*;
import java.util.*;

public class B9663 {
  static int N, cnt = 0;
  static int board[];

  static void nQueen(int depth) {
    if (depth == N) {
      ++cnt;
      return;
    }
    for (int i = 0; i < N; ++i) {
      board[depth] = i;
      if (promising(depth)) {
        nQueen(depth + 1);
      }
    }
  }

  static boolean promising(int col) {
    for (int i = 0; i < col; ++i) {
      if (board[i] == board[col])
        return false;
      if (Math.abs(i - col) == Math.abs(board[i] - board[col]))
        return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    board = new int[N];
    nQueen(0);
    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    br.close();
  }
}
