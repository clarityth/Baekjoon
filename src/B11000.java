import java.io.*;
import java.util.*;

public class B11000 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int timeTable[][] = new int[N][2];
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startTime = Integer.parseInt(st.nextToken());
      int endTime = Integer.parseInt(st.nextToken());
      timeTable[i][0] = startTime;
      timeTable[i][1] = endTime;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    // 수업의 시작 시간 기준 오름차순 정렬
    Arrays.sort(timeTable, new Comparator<int[]>(){
      @Override 
      public int compare(int[] o1, int[] o2){
        // 시작 시간이 같다면, 종료 시간 기준 오름차순 정렬
        if (o1[0] == o2[0])
          return o1[1] - o2[1];
        else
          return o1[0] - o2[0];
      }
    });
    pq.offer(timeTable[0][1]);
    for (int i = 1; i < N; ++i) {
      // 이전 수업의 종료 시간이 다음 수업의 시작 시간보다 늦다면, 새로운 강의실 배정 필요
      if (pq.peek() > timeTable[i][0]){
        pq.offer(timeTable[i][1]);
      }
      else {
      // 이전 수업의 종료 시간이 다음 수업의 시작 시간 보다 빠르다면, 같은 강의실에서 진행 가능 -> 우선순위 큐 갱신
        pq.poll();
        pq.offer(timeTable[i][1]);
      }
    }
    // 필요한 강의실의 수 = 우선순위 큐의 size 
    bw.write(String.valueOf(pq.size()));
    bw.flush();
    bw.close();
    br.close();
  }
}