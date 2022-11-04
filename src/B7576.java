import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B7576 {
  public static int M, N, ripeDay = -1;
  public static int[][] box;
  public static boolean[][] visit;
  public static int[][] day;
  public static int[] dx = {0, 0, -1, 1};
  public static int[] dy = {1, -1, 0, 0};
  
  public static void bfs(){
    Queue<int[]> q = new LinkedList<int[]>();
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if (box[i][j] == 1){
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
        q.offer(new int[]{nextX, nextY});
        visit[nextY][nextX] = true;
        day[nextY][nextX] = day[currentY][currentX]+1;
        if (day[nextY][nextX] > ripeDay)
          ripeDay = day[nextY][nextX];
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
    day = new int[N][M];
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
          day[i][j] = 1;
          isEmpty = 0;
        }
        box[i][j] = status;
      }
    }
    if (isEmpty == 1){
      System.out.println("-1");
      System.exit(0);
    }
    if (isAllRipe == 1){
      System.out.println("0");
      System.exit(0);
    }
    bfs();
    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        if((box[i][j] == 0 || box[i][j] == 1) && day[i][j] == 0){
          System.out.println("-1");
          System.exit(0);
        }
      }
    }
    System.out.println(ripeDay-1);
  }
}

