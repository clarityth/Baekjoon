import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B7569 {
  public static int box[][][], ripeDay[][][];
  public static boolean visit[][][];
  public static int M, N, H;
  public static int[] dx = {0, 0, -1, 1, 0, 0};
  public static int[] dy = {0, 0, 0, 0, 1, -1};
  public static int[] dz = {1, -1, 0, 0, 0, 0};
  
  public static void bfs(){
    Queue<int[]> q = new LinkedList<int[]>();
    for(int i=0; i<H; ++i){
      for(int j=0; j<N; ++j){
        for(int k=0; k<M; ++k){
          if (box[i][j][k] == 1)
            q.offer(new int [] {k, j, i}); // 큐에 익은 토마토의 x,y,z 좌표 삽입
        }
      }
    }
    while(!q.isEmpty()){
      int[] current = q.poll();
      int curX = current[0];
      int curY = current[1];
      int curZ = current[2];
      for(int i=0; i<6; i++){
        int nextX = curX + dx[i];
        int nextY = curY + dy[i];
        int nextZ = curZ + dz[i];
        if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= M || nextY >= N || nextZ >= H)
          continue;
        if (!visit[nextZ][nextY][nextX] && box[nextZ][nextY][nextX] == 0){
          // 처음 방문하는 경우, 익지 않은 토마토의 좌표를 큐에 삽입, 방문처리
          q.offer(new int[] {nextX, nextY, nextZ});
          visit[nextZ][nextY][nextX] = true;
          ripeDay[nextZ][nextY][nextX] += ripeDay[curZ][curY][curX] + 1;
        }
        else if (visit[nextZ][nextY][nextX] && box[nextZ][nextY][nextX] == 0){
          // 이미 방문했던 경우, 익는 날짜가 이전에 방문했을 때의 익는 날짜보다 작다면 갱신
          if (ripeDay[nextZ][nextY][nextX] > ripeDay[curZ][curY][curX] + 1){
            q.offer(new int[] {nextX, nextY, nextZ});
            ripeDay[nextZ][nextY][nextX] = ripeDay[curZ][curY][curX] + 1;
          }
        }
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    M = Integer.parseInt(st.nextToken()); // 가로
    N = Integer.parseInt(st.nextToken()); // 세로
    H = Integer.parseInt(st.nextToken()); // 높이
    box = new int[H][N][M];
    ripeDay = new int[H][N][M];
    visit = new boolean[H][N][M];
    boolean isAllRiped = true;
    for(int i=0; i<H; ++i){
      for(int j=0; j<N; ++j){
        st = new StringTokenizer(br.readLine());
        for(int k=0; k<M; ++k){
          box[i][j][k] = Integer.parseInt(st.nextToken());
          if (box[i][j][k] == 0)
            isAllRiped = false;
        }
      }
    }
    if (isAllRiped){
    // 입력으로 모두 익은 토마토만 들어온 경우 0 출력
      bw.write("0");
    } 
    else {
      bfs();
      int maxRipeDay = 0;
      for(int i=0; i<H; ++i){
        for(int j=0; j<N; ++j){
          for(int k=0; k<M; ++k){
            if (box[i][j][k] == 0 && ripeDay[i][j][k] == 0) {
            // 박스에 익지 않은 토마토가 있었음에도 bfs 수행 결과 익지 못한다면 -1 출력
              bw.write("-1");
              bw.flush();
              bw.close();
              br.close();
              System.exit(0);
            }
            else if (maxRipeDay < ripeDay[i][j][k])
              maxRipeDay = ripeDay[i][j][k];
          }
        }
      }
      bw.write(String.valueOf(maxRipeDay));
    }
    bw.flush();
    bw.close();
    br.close();
  }
}