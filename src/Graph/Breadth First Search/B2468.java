// 안전 영역
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.awt.Point;
import java.util.Queue;

public class B2468 {
  public static int N;
  public static int[][] areaHeights;
  public static Queue<Point> q;
  public static boolean[][] isNotSinkedArea;
  public static boolean[][] visit;
  public static final int[] dx = {0, 0, -1, 1};
  public static final int[] dy = {1, -1, 0, 0};

  public static int getSafeAreaCnt(int rain){
    q = new LinkedList<Point>();
    isNotSinkedArea = new boolean[N][N];
    visit = new boolean[N][N];
    for(int i = 0; i < N; ++i){
      for(int j = 0; j < N; ++j){
        if (rain < areaHeights[i][j]) {
          isNotSinkedArea[i][j] = true;
        }
      }
    }
    int cnt = 0;
    for(int i = 0; i < N; ++i){
      for(int j = 0; j < N; ++j){
        if(!visit[i][j] && isNotSinkedArea[i][j]) {
          bfs(j, i);
          ++cnt;
        }
      }
    }
    return cnt;
  }
  
  public static void bfs(int x, int y) {
    visit[y][x] = true;
    q.offer(new Point(x, y));
    
    while(!q.isEmpty()){
      Point currentPos = q.poll();
      int curX = currentPos.x;
      int curY = currentPos.y;
      for(int k = 0; k < 4; ++k){
        int adjX = curX + dx[k];
        int adjY = curY + dy[k];
        if (adjX >= N || adjX < 0 || adjY >= N || adjY < 0) {
          continue;
        }
        if (!visit[adjY][adjX] && isNotSinkedArea[adjY][adjX]){
          visit[adjY][adjX] = true;
          q.offer(new Point(adjX, adjY));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    areaHeights = new int[N][N];
    int maxHeight = 0, maxSafeAreaCnt = 1;
    // 모든 지역이 잠기지 않을 수 있으므로, maxSafeAreaCnt의 초깃값을 1로 설정
    for(int i = 0; i < N; ++i){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; ++j){
        areaHeights[i][j] = Integer.parseInt(st.nextToken());
        if (areaHeights[i][j] > maxHeight)
          maxHeight = areaHeights[i][j];
      }
    }
    for(int i = 0; i <= maxHeight; ++i){
      int safeCnt = getSafeAreaCnt(i);
      if (safeCnt > maxSafeAreaCnt)
        maxSafeAreaCnt = safeCnt;
    }
    bw.write(String.valueOf(maxSafeAreaCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}