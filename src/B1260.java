import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class B1260 {
  public static int N;
  public static int M;
  public static int V;
  public static int branch[][];
  public static boolean visit[];
  public static Queue<Integer> q;
  
  public static void dfs(int start){
    visit[start] = true;
    System.out.print(start + " ");
    for(int i=1; i<N+1; i++){
      if(branch[start][i] == 1 && visit[i] == false)
        dfs(i);
    }
  }

  public static void bfs(int start){
    q = new LinkedList<Integer>();
    q.offer(start);
    visit[start] = true;
    while(!q.isEmpty()){
      int visitedVertex = q.poll();
      System.out.print(visitedVertex + " ");
      for(int i=1; i<N+1; i++){
        if (branch[visitedVertex][i] == 1 && visit[i] == false){
          q.offer(i);
          visit[i] = true;
        }
      }
    }
  }
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    V = sc.nextInt();
    branch = new int[1001][1001];
    visit = new boolean[1001];

    for(int i=0; i<M; i++){
      int firstVertex = sc.nextInt();
      int secondVertex = sc.nextInt();
      branch[firstVertex][secondVertex] = branch[secondVertex][firstVertex] = 1;
  }
    dfs(V);
    System.out.println();
    // visit 배열 초기화
    Arrays.fill(visit, false);
    bfs(V);
  }
  
}