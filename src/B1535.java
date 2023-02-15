import java.io.*;
import java.util.*;

public class B1535 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    // 소모 체력
    int L[] = new int[N + 1];
    // 획득 행복
    int J[] = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; ++i) {
      L[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; ++i) {
      J[i] = Integer.parseInt(st.nextToken());
    }
    int happiness[][] = new int[N+1][101];
    for (int i = 1; i <= N; ++i) {
      // i번째 사람
      for (int l = 1; l <= 100; ++l){
        // 현재 체력
        if (L[i] >= l) {
          // 현재 체력 >= 소모 체력이라면, 인사하지 않음
          happiness[i][l] = happiness[i-1][l];
        } else {
          // i번째 사람에게 인사를 하지 않았을 때의 행복값과
          // i번째 사람에게 인사를 하기 위해 체력을 채우고, 인사를 했을 때의 행복값 중 최댓값을 선택
          happiness[i][l] = Math.max(happiness[i-1][l], happiness[i-1][l-L[i]] + J[i]);
        }
      }
    }
    bw.write(String.valueOf(happiness[N][100]));
    bw.flush();
    bw.close();
    br.close();
  }
}