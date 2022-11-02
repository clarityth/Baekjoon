import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B11724 {
  public static int N, M;
  public static int[][] graph;
  public static boolean[] visited;

  public static void dfs(int start){
    visited[start] = true;
    for(int i=1; i<=N; i++){
      if(graph[start][i] == 1 && !visited[i]){
        dfs(i);
      }
    }
  }
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int conCompo = 0;
    graph = new int[N+1][N+1];
    visited = new boolean[N+1];
    
    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[u][v] = 1;
      graph[v][u] = 1;
    }
    
    for(int i=1; i<=N; i++){
      if(!visited[i]){
        dfs(i);
        conCompo++;
      }
    }
    System.out.println(conCompo);
  }
}

