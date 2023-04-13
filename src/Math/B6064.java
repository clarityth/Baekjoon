import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B6064 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      x -= 1;
      y -= 1;
      boolean isFoundYear = false;
      for (int j = x; j <= N * M; j += M) {
        if (j % N == y) {
          System.out.println(j + 1);
          isFoundYear = true;
          break;
        }
      }
      if (!isFoundYear)
        System.out.println("-1");
    }
  }
}