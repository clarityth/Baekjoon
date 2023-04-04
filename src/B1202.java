import java.io.*;
import java.util.*;

public class B1202 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Integer jewels[][] = new Integer[N][3]; // [0]:무게, [1]:가격
    Vector<Integer> C = new Vector<Integer>(); // 각 가방에 담을 수 있는 최대 무게
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
      jewels[i][1] = Integer.parseInt(st.nextToken()); // 가격
    }
    // 보석의 무게를 기준으로 내림차순 정렬
    Arrays.sort(jewels, (o1, o2) -> o1[0] - o2[0]);
    for (int i = 0; i < K; ++i) {
      C.add(Integer.parseInt(br.readLine()));
    }
    // 가방의 최대 무게를 오름차순 정렬
    Collections.sort(C);
    long res = 0l;
    int idx = 0;
    for (int i = 0; i < K; ++i) {
      // 현재 가방의 무게보다 무게가 적은 모든 보석들을 우선순위 큐에 push
      while (idx < N && C.get(i) >= jewels[idx][0]) 
        pq.offer(jewels[idx++][1].intValue());
      // 현재 가방에 들어갈 수 있는 보석들 중 가장 가치가 비싼 보석을 하나 꺼내 결과에 더함
      if (!pq.isEmpty())
        res += pq.poll();
    }
    bw.write(String.valueOf(res));
    bw.flush();
    bw.close();
    br.close();
  }
}