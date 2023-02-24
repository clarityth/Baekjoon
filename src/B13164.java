import java.io.*;
import java.util.*;
import java.awt.Point;

public class B13164 {
  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    int heights[] = new int[N];
    int diff[] = new int[N - 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      heights[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < N - 1; ++i) {
      diff[i] = Math.abs(heights[i] - heights[i + 1]);
    }
    // 두 원생의 키 차이를 오름차순 정리
    Arrays.sort(diff);
    int sum = 0;
    int idx = 0;
    // 1. K개의 조에 한명씩 포함시킴 = 비용 0
    // 2. N-K번(꼭 조에 포함시켜야 하는 경우) 반복하며 키 차이를 sum에 누적
    for (int i = 0; i < N - K; ++i) {
      sum += diff[idx++];
    }
    bw.write(String.valueOf(sum));
    bw.flush();
    bw.close();
    br.close();
  }
}