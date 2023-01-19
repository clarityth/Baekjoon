import java.io.*;
import java.util.*;

public class B2644 {
  public static final int INF = 987654321;
  public static int[][] relation;
  public static int n, m;

  public static void floyd() {
    for (int k = 1; k <= n; ++k) {
      for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
          if (relation[i][j] > relation[i][k] + relation[k][j])
            relation[i][j] = relation[i][k] + relation[k][j];
        }
      }
    }
  }

  public static void Main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    relation = new int[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (i == j)
          continue;
        relation[i][j] = INF;
      }
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    int targetPerson_a = Integer.parseInt(st.nextToken());
    int targetPerson_b = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());
      relation[parent][child] = relation[child][parent] = 1;
    }
    floyd();
    if (relation[targetPerson_a][targetPerson_b] == INF)
      bw.write("-1");
    else
      bw.write(String.valueOf(relation[targetPerson_a][targetPerson_b]));
    bw.flush();
    bw.close();
    br.close();
  }
}