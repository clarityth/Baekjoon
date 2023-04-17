// 카드 정렬하기
import java.io.*;
import java.util.*;

public class B1715 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i=0; i<N; ++i){
      pq.offer(Integer.parseInt(br.readLine()));
    }
    int cnt = 0;
    // 우선순위 큐에 원소가 하나 남은 경우 종료
    while (pq.size() > 1) {
      int tempCnt = pq.poll() + pq.poll();
      pq.offer(tempCnt);
      cnt += tempCnt;
    }
    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    br.close();
  }
}