import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B7576 {
  public static int M, N, minRipeDay = -1;
  public static int[][] box;
  public static boolean[][] visit;
  public static int[][] ripeDay;
  public static int[] dx = {0, 0, -1, 1};
  public static int[] dy = {1, -1, 0, 0};
  
  public static void bfs(){
    Queue<int[]> q = new LinkedList<int[]>();
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if (box[i][j] == 1){
          // 익은 토마토의 좌표를 큐에 삽입
          q.offer(new int[]{j, i});
        }
      }
    }
    
    while (!q.isEmpty()){
      int[] current = q.poll();
      int currentX = current[0];
      int currentY = current[1];
      visit[currentY][currentX] = true;
      
      for(int i=0; i<4; i++){
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];
        if (nextY >= N || nextY < 0 || nextX >= M || nextX < 0 || box[nextY][nextX] == -1)
          continue;
        if (ripeDay[nextY][nextX] == 0){
          // 익지 않은 토마토의 좌표를 큐에 삽입
          q.offer(new int[]{nextX, nextY});
          ripeDay[nextY][nextX] = ripeDay[currentY][currentX]+1;
        }
        if (ripeDay[nextY][nextX] > minRipeDay)
          // 배열 내의 최댓값(토마토가 전부 익을때까지의 최솟값) 갱신
          minRipeDay = ripeDay[nextY][nextX];
      }
    }
  }
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    box = new int[N][M];
    visit = new boolean[N][M];
    ripeDay = new int[N][M];
    int isAllRipe = 1;
    int isEmpty = 1;
    
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++){
        int status = Integer.parseInt(st.nextToken());
        if (status == 0){ // 익지 않은 토마토
          isAllRipe = 0;
          isEmpty = 0;
        }
        else if (status == 1){ // 익은 토마토
          ripeDay[i][j] = 1;
          isEmpty = 0;
        }
        box[i][j] = status;
      }
    }
    if (isEmpty == 1){
      // 상자에 토마토가 없는 경우 -1 출력
      System.out.println("-1");
      System.exit(0);
    }
    if (isAllRipe == 1){
      // 저장될 때부터 모든 토마토가 익어있는 경우 0 출력
      System.out.println("0");
      System.exit(0);
    }
    bfs();
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if((box[i][j] == 0 || box[i][j] == 1) && ripeDay[i][j] == 0){
          // 토마토가 있음에도 전부 익지 못한 경우 -1 출력
          System.out.println("-1");
          System.exit(0);
        }
      }
    }
    // bfs 수행시 ripeDay 배열의 익어있는 토마토의 초기값이 1이 되므로 -1을 해줌
    System.out.println(minRipeDay-1);
  }
}

