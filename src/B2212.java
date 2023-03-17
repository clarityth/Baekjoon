import java.io.*;
import java.util.*;

public class B2212 {
  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());
    Integer sensorPos[] = new Integer[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      sensorPos[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(sensorPos);
    Integer diff[] = new Integer[N - 1];
    // 센서 간의 거리 차이를 저장
    for (int i = 1; i < N; ++i) {
      diff[i - 1] = sensorPos[i] - sensorPos[i - 1];
    }
    Arrays.sort(diff, Collections.reverseOrder());
    int res = 0;
    // 거리 차이를 내림차순으로 정렬 후, K-1번째부터 끝까지 더해줌 (K-1개 만큼 diff 배열의 원소를 제외시킬 수 있음) 
    // -> diff 배열을 내림차순으로 정렬했으므로, 앞에서 부터 K-1만큼 건너뛰면 최소값을 구할 수 있음
    for (int i = K - 1; i < N - 1; ++i) {
      res += diff[i];
    }
    bw.write(String.valueOf(res));
    bw.flush();
    bw.close();
    br.close();
  }
}