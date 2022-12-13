import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1389 {
  public static final int INF = 987654321;
  public static int[][] connection;
  public static int N, M;

  public static void floyd() {
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (i == j)
            continue;
          else if (connection[i][j] > connection[i][k] + connection[k][j])
            connection[i][j] = connection[i][k] + connection[k][j];
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    connection = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j)
          continue;
        connection[i][j] = INF;
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      connection[A][B] = connection[B][A] = 1;
    }

    floyd();

    int min = INF;
    int personNum = 0;
    for (int i = 1; i <= N; i++) {
      int sum = 0;
      for (int j = 1; j <= N; j++) {
        sum += connection[i][j];
      }
      if (sum < min) {
        min = sum;
        personNum = i;
      }
    }
    System.out.println(personNum);
  }
}
