import java.io.*;
import java.util.*;

public class B12865 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int W[] = new int[101];
    int V[] = new int[101];
    int knapsack[][] = new int[101][100001];
    for (int i = 1; i <= N; ++i){
      st = new StringTokenizer(br.readLine());
      W[i] = Integer.parseInt(st.nextToken());
      V[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 1; i <= N; ++i){
      for (int j = 1; j <= K; ++j){
        if (W[i] > j){
          knapsack[i][j] = knapsack[i-1][j];
        } else {
          knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-W[i]] + V[i]);
        }
      }
    }
    bw.write(String.valueOf(knapsack[N][K]));
    bw.flush();
    bw.close();
    br.close();
  }
}