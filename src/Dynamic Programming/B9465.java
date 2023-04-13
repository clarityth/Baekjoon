import java.io.*;
import java.util.*;

public class B9465 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<T; ++i){
      int N = Integer.parseInt(br.readLine());
      int sticker[][] = new int[2][100001];
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 2칸 뒤 대각선에서 오는 경우도 존재할 수 있으므로, 0번째 값은 0으로 비워둠
      for(int j=1; j<=N; ++j)
        sticker[0][j] = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=N; ++j)
        sticker[1][j] = Integer.parseInt(st.nextToken());
      int dp[][] = new int[2][100001];
      // dp[0][x] = 위부터 시작
      dp[0][0] = 0; dp[0][1] = sticker[0][1];
      // dp[1][x] = 아래부터 시작
      dp[1][0] = 0; dp[1][1] = sticker[1][1];
      
      for(int j=2; j<=N; ++j){
        // 1칸 뒤 대각선의 값, 2칸 뒤 대각선의 값 비교 + 현재 스티커의 값
        dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
        dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
      }
      sb.append(Math.max(dp[0][N], dp[1][N]) + "\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}