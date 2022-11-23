import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
  public static HashMap<Integer, Integer> map = new HashMap<>();

  static int delete(PriorityQueue<Integer> q) {
    int res = 0;
    while (true) {
      res = q.poll();
      int cnt = map.getOrDefault(res, 0);
      if (cnt == 0)
        continue;
      if (cnt == 1)
        map.remove(res);
      else
        map.put(res, cnt - 1);
      break;
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> minPq = new PriorityQueue<>();
      PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
      map = new HashMap<>();
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
              // key = maxPq.poll();
              delete(maxPq);
            } else if (opCode == -1) {
              // 최솟값 삭제
              // key = minPq.poll();
              delete(minPq);
            }
            // // 삭제 연산에서 값이 둘 이상인 경우, 하나만 삭제됨
            // int numOfVal = map.getOrDefault(key, 0);
            // if (numOfVal > 1)
            // map.replace(key, numOfVal - 1);
            // else if (numOfVal == 1)
            // map.remove(key);
            // else
            // continue;
          }
        }
      }
      if (map.isEmpty())
        sb.append("EMPTY\n");
      else {
        // 큐에 값이 하나 밖에 없는 경우, 최댓값과 최솟값이 같아야함
        int res = delete(maxPq);
        sb.append(res + " ");
        if (!map.isEmpty()) {
          res = delete(minPq);
        }
        sb.append(res + "\n");
      }
    }
    System.out.println(sb);
  }
}
