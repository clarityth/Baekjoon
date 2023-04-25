// 스타트와 링크
import java.io.*;
import java.util.*;

public class Main {
  static int N, minDiff = 987654321, status[][];
  static boolean visited[];

  static void getMinStatusDiff(int depth, int idx){
    if (depth == N / 2) {
      int start_stat = 0;
      int link_stat = 0;
      for (int i = 0; i < N - 1; ++i) {
        for (int j = i + 1; j < N; ++j) {
          // 두 순서쌍을 전부 방문했을 경우, start팀 능력치에 합산
          if (visited[i] && visited[j]) {
            start_stat += status[i][j] + status[j][i];
          }
          // 두 순서쌍을 전부 방문하지 않았을 경우, link팀 능력치에 합산
          else if (!visited[i] && !visited[j]) {
            link_stat += status[i][j] + status[j][i];
          }
        }
      }
      // 두 팀의 능력치 합계가 0이라면, 나올 수 있는 능력치 차이의 최솟값이므로 출력하고 즉시 종료
      int diff = Math.abs(start_stat - link_stat);
      minDiff = Math.min(minDiff, diff);
      if (minDiff == 0) {
        System.out.println(minDiff);
        System.exit(0);
      }
      return;
    }
    for (int i = idx; i < N; ++i) {
      // 방문 처리를 통해 depth == N/2가 되었을 때, 팀이 절반으로 나누어지게 됨 (방문처리 유무)
      if (!visited[i]) {
        visited[i] = true;
        getMinStatusDiff(depth + 1, i + 1);
        visited[i] = false;
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    status = new int[N][N];
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        status[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited = new boolean[N];
    getMinStatusDiff(0, 0);
    bw.flush();
    bw.write(String.valueOf(minDiff));
    bw.close();
    br.close();
  }
}