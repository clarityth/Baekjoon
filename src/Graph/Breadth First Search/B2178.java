// 미로 탐색
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;
  
public class B2178 {
  public static int N, M;
  public static int maze[][];
  public static int route[][];
  public static boolean visit[][];
  public static int dx[] = {0, 0, -1, 1};
  public static int dy[] = {1, -1, 0, 0};

  public static void bfs(int startX, int startY){
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(new int[]{startX, startY});
    visit[startY][startX] = true;
    
    while(!q.isEmpty()){
      int current[] = q.poll();
      int currentX = current[0];
      int currentY = current[1];
      for (int i = 0; i < 4; ++i){
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];
        if (nextX >= M || nextY >= N || nextX < 0 || nextY < 0 || maze[nextY][nextX] == 0 || visit[nextY][nextX])
          continue;
        else {
          q.offer(new int[]{nextX, nextY});
          visit[nextY][nextX] = true;
          route[nextY][nextX] = route[currentY][currentX] + 1;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    maze = new int[101][101];
    visit = new boolean[101][101];
    route = new int[101][101];
    for(int i = 0; i < N; i++){
      String input = br.readLine();
      for(int j = 0; j < M; j++){
        maze[i][j] = input.charAt(j) - '0';
      }
    }
    bfs(0, 0);
    System.out.print(route[N - 1][M - 1] + 1);
  }
}