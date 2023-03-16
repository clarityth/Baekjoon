import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static final int R = 0, G = 1, B = 2;
  public static int[][] input, DP;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    // 입력받을 배열
    input = new int[N + 1][3];
    // DP 배열
    DP = new int[N + 1][3];
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      input[i][R] = Integer.parseInt(st.nextToken());
      input[i][G] = Integer.parseInt(st.nextToken());
      input[i][B] = Integer.parseInt(st.nextToken());
    }
    DP[0][R] = input[0][R];
    DP[0][G] = input[0][G];
    DP[0][B] = input[0][B];
    for (int i = 1; i <= N; ++i) {
      DP[i][R] = input[i][R] + Math.min(DP[i - 1][G], DP[i - 1][B]);
      DP[i][G] = input[i][G] + Math.min(DP[i - 1][R], DP[i - 1][B]);
      DP[i][B] = input[i][B] + Math.min(DP[i - 1][R], DP[i - 1][G]);
    }
    bw.write(String.valueOf(Math.min(DP[N][R], Math.min(DP[N][G], DP[N][B]))));
    bw.flush();
    bw.close();
    br.close();
  }
}