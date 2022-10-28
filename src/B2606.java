import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B2606{
  public static int [][] network;
  public static boolean [] visit;
  public static int N;
  public static int cnt = 0;
  
  public static void dfs(int start){
    visit[start] = true;
    for(int i=1; i<=N; i++){
      if (network[start][i] == 1 && visit[i] == false){
        cnt++;
        dfs(i);
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int pair = Integer.parseInt(br.readLine());
    network = new int[N+1][N+1];
    visit = new boolean[N+1];
    Arrays.fill(visit, false);
    for(int i=0; i<pair; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int comA = Integer.parseInt(st.nextToken());
      int comB = Integer.parseInt(st.nextToken());
      network[comA][comB] = 1;
      network[comB][comA] = 1;
    }
    dfs(1);
    System.out.println(cnt);
  }
}
