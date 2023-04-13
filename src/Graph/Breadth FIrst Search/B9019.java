import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class B9019 {
  public static int A, B;
  public static String[] cmdList;
  public static boolean[] visit;
  public static Queue<Integer> q;
  public static void bfs(){
    q.offer(A);
    visit[A] = true;
    
    while (!q.isEmpty() && !visit[B]){
      int current = q.poll();
      int d = (2 * current) % 10000;
      int s = 0;
      if (current == 0)
        s = 9999;
      else 
        s = current - 1;
      int l = (current % 1000) * 10 + current / 1000;
      int r = (current % 10) * 1000 + current / 10;
      if (!visit[d]){
        q.offer(d);
        visit[d] = true;
        cmdList[d] = cmdList[current] + "D";
      }
      if (!visit[s]){
        q.offer(s);
        visit[s] = true;
        cmdList[s] = cmdList[current] + "S";
      }
      if (!visit[l]){
        q.offer(l);
        visit[l] = true;
        cmdList[l] = cmdList[current] + "L";
      }
      if (!visit[r]){
        q.offer(r);
        visit[r] = true;
        cmdList[r] = cmdList[current] + "R";
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < T; ++i){
      StringTokenizer st = new StringTokenizer(br.readLine());
      cmdList = new String[10000];
      Arrays.fill(cmdList, "");
      visit = new boolean[10000];
      q = new LinkedList<Integer>();
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      bfs();
      sb.append(cmdList[B]+"\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}