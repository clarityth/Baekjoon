// 거짓말
import java.io.*;
import java.util.*;

public class B1043 {
  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    boolean[] party_checked = new boolean[M];
    boolean[] visited = new boolean[N + 1];
    // 큐에 진실을 아는 사람들을 전부 삽입
    for (int knowPerson : truth) {
      q.offer(knowPerson);
      visited[knowPerson] = true;
    }
    
    while (!q.isEmpty()) {
      int now = q.poll();
      for (int i = 0; i < M; ++i) {
        // 체크하지 않은 파티이면서, 현재 파티에 진실을 알고 있는 사람을 포함하고 있는 경우
        if (!party_checked[i] && visitors[i+1].contains(Integer.valueOf(now))) {
          // 현재 파티에 속하면서 진실을 모르고 있었던 사람들을 큐에 추가, 방문 처리
          for (int next : visitors[i+1]) {
            if (!visited[next]) {
              q.offer(next);
              visited[next] = true;
            }
          }
          // 거짓말을 할 수 있는 파티를 감소
          --res;
          party_checked[i] = true;
        }
      }
    }
  }
  
  static int N, M, tCnt, vCnt, res;
  static ArrayList<Integer> truth;
  static ArrayList<Integer> visitors[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 사람의 수
    M = Integer.parseInt(st.nextToken()); // 파티의 수
    
    truth = new ArrayList<Integer>();
    st = new StringTokenizer(br.readLine());
    tCnt = Integer.parseInt(st.nextToken());
    while (tCnt-- > 0) {
      truth.add(Integer.parseInt(st.nextToken()));
    }
    
    visitors = new ArrayList[M+1];
    for (int i = 1; i <= M; ++i)
      visitors[i] = new ArrayList<Integer>();
    
    for (int i = 1; i <= M; ++i) {
      st = new StringTokenizer(br.readLine());
      vCnt = Integer.parseInt(st.nextToken());
      while (vCnt-- > 0) {
        visitors[i].add(Integer.parseInt(st.nextToken()));
      }
    }
    res = M;
    bfs();
    bw.flush();
    bw.write(String.valueOf(res));
    bw.close();
    br.close();
  }
}