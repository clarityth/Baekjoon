import java.io.*;
import java.util.*;

class pos {
  long n;
  long cnt;

  pos(long n, long cnt) {
    this.n = n;
    this.cnt = cnt;
  }
}

public class B16953 {
  static final long INF = Long.MAX_VALUE;
  static long A, B;

  static long bfs() {
    Queue<pos> q = new LinkedList<pos>();
    q.offer(new pos(A, 0l));
    long minCnt = INF;

    while (!q.isEmpty()) {
      pos now = q.poll();
      long nowNum = now.n;
      long nowCnt = now.cnt;
      if (nowNum == B)
        minCnt = Math.min(minCnt, nowCnt);
      long nextMul = nowNum * 2l;
      long nextAdd = nowNum * 10l + 1l;
      if (nextMul <= B) {
        q.offer(new pos(nextMul, nowCnt + 1l));
      }
      if (nextAdd <= B) {
        q.offer(new pos(nextAdd, nowCnt + 1l));
      }
    }
    return minCnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    long res = bfs();
    if (res == INF)
      bw.write("-1");
    else
      bw.write(String.valueOf(res + 1));
    bw.flush();
    bw.close();
    br.close();
  }
}