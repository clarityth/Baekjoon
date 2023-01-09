import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B1149 {
  public static final int R = 0, G = 1, B = 2;
  public static int[][] minCostSum;
  public static int[][] coloringCosts;
  public static int coloring(int n, int color){
    if (n == 0)
      return coloringCosts[0][color];

    // 중복 탐색 방지
    if (minCostSum[n][color] == 0){
      if (color == R){
        minCostSum[n][R] = coloringCosts[n][R] + Math.min(coloring(n-1, G), coloring(n-1, B));
      }
      else if (color == G){
        minCostSum[n][G] = coloringCosts[n][G] + Math.min(coloring(n-1, R), coloring(n-1, B));
      }
      else if (color == B){
        minCostSum[n][B] = coloringCosts[n][B] + Math.min(coloring(n-1, R), coloring(n-1, G));
      }
    }
    return minCostSum[n][color];
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    // 입력받을 배열
    coloringCosts = new int[N][3];
    // DP 배열
    minCostSum = new int[N][3];
    for(int i=0; i<N; ++i){
      StringTokenizer st = new StringTokenizer(br.readLine());
      coloringCosts[i][R] = Integer.parseInt(st.nextToken());
      coloringCosts[i][G] = Integer.parseInt(st.nextToken());
      coloringCosts[i][B] = Integer.parseInt(st.nextToken());
    }
    bw.write(String.valueOf(Math.min(coloring(N-1, R), Math.min(coloring(N-1, G), coloring(N-1, B)))));
    bw.flush();
    bw.close();
    br.close();
  }
}