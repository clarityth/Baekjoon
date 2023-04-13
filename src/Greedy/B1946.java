import java.io.*;
import java.util.*;

public class B1946 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int arr[][] = new int[N][2];
      for (int i = 0; i < N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[i][0] = Integer.parseInt(st.nextToken());
        arr[i][1] = Integer.parseInt(st.nextToken());
      }
      // 서류 심사 성적 기준 오름차순 정렬
      Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
      int lowestRank = arr[0][1];
      int cnt = 1;
      for (int i = 1; i < N; ++i) {
        // 이전까지의 최저 면접 등수보다 낮으면 채용 불가
        if (lowestRank < arr[i][1])
          continue;
        // 최저 면접 등수 갱신
        if (lowestRank > arr[i][1])
          lowestRank = arr[i][1];
        ++cnt;
      }
      bw.write(cnt + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}