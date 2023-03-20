import java.io.*;
import java.util.*;

public class B11052 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    int prices[] = new int[N + 1];
    int DP[] = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; ++i) {
      prices[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 1; i <= N; ++i) {
      // i = 사야하는 카드의 갯수
      for (int j = 1; j <= i; ++j){
        // j = 사려고 하는 카드팩의 번호
        // 현재 i개의 카드를 사기 위해 1~i번 카드팩을 사고, 남은 금액을 채워 넣을 때(이전에 구했던 DP 값)의 기댓값과 기존 값을 비교
        DP[i] = Math.max(prices[j] + DP[i-j], DP[i]);
      }
    }
    bw.write(String.valueOf(DP[N]));
    bw.flush();
    bw.close();
    br.close();
  }
}