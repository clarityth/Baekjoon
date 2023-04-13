import java.io.*;
import java.util.*;
import java.awt.Point;

public class B16928 {
  static final int[] dx = {1, 2, 3, 4, 5, 6};
  static int N, M;
  static int map[];
  static HashMap<Integer, Integer> ladderAndSnake;
  static boolean visit[];
  
  static void bfs(int start){
    Queue<Integer> q = new LinkedList<Integer>();
    visit[start] = true;
    q.offer(start);
    while (!q.isEmpty()){
      int now = q.poll();
      if (now == 100)
        break;
      int newNext = ladderAndSnake.getOrDefault(now, -1);
      if (newNext == -1){
        // 해당 칸에 사다리와 뱀 모두 없는 경우 -> 순회
        for(int i=0; i<6; ++i){
          int next = now + dx[i];
          if (next < 0 || next > 100)
            continue;
          if (!visit[next]) {
            map[next] = map[now] + 1;
            q.offer(next);
            visit[next] = true;
          }
          else if (visit[next] && map[next] > map[now] + 1) {
            map[next] = map[now] + 1;
            q.offer(next);
          }
        }
      }
      // 해당 칸에 사다리나 뱀이 있는 경우 -> 이동
      else {
        if (!visit[newNext]) {
          map[newNext] = map[now];
          q.offer(newNext);
          visit[newNext] = true;
        } 
        else if (visit[newNext] && map[newNext] > map[now]){
          map[newNext] = map[now];
          q.offer(newNext);
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ladderAndSnake = new HashMap<Integer, Integer>();
    map = new int[101];
    visit = new boolean[101];
    for(int i=0; i<N+M; ++i){
      st = new StringTokenizer(br.readLine());
      ladderAndSnake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    bfs(1);
    bw.write(String.valueOf(map[100]));
    bw.flush();
    bw.close();
    br.close();
  }
}