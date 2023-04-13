import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;

public class B7662 {
  static int delete(HashMap<Integer, Integer> map, PriorityQueue<Integer> q) {
    int value = 0;
    while (true) {
      value = q.poll();
      int numOfVal = map.getOrDefault(value, 0);
      if (numOfVal == 0)
        continue;
      if (numOfVal == 1)
        map.remove(value);
      else
        map.replace(value, numOfVal - 1);
      break;
    }
    return value;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      // 최소큐, 최대큐 생성
      PriorityQueue<Integer> minPq = new PriorityQueue<>();
      PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
      HashMap<Integer, Integer> map = new HashMap<>();
      // hashmap에 <값, 해당 값의 갯수> 형태로 저장
      for (int j = 0; j < k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String op = st.nextToken();
        if (op.equals("I")) {
          // 삽입
          int val = Integer.parseInt(st.nextToken());
          minPq.offer(val);
          maxPq.offer(val);
          map.put(val, map.getOrDefault(val, 0) + 1);
        } else if (op.equals("D")) {
          // 삭제
          int opCode = Integer.parseInt(st.nextToken());
          if (!map.isEmpty()) {
            if (opCode == 1) {
              // 최댓값 삭제
              delete(map, maxPq);
            } else if (opCode == -1) {
              // 최솟값 삭제
              delete(map, minPq);
            }
          }
        }
      }
      if (map.isEmpty())
        sb.append("EMPTY\n");
      else {
        int max = delete(map, maxPq);
        sb.append(max + " ");
        // 큐에 원소가 하나만 있을 경우 고려(최댓값과 최솟값이 같음)
        if (!map.isEmpty()) {
          int min = delete(map, minPq);
          sb.append(min + "\n");
        } 
        else
          sb.append(max + "\n");
      }
    }
    System.out.println(sb);
  }
}
