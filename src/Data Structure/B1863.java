import java.io.*;
import java.util.*;
import java.awt.Point;

public class B1863 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Stack<Point> s = new Stack<Point>();
    int cnt = 0;
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      while (!s.isEmpty() && s.peek().y > y) {
        // !건물의 확정 조건: 이전에 나왔던 고도보다 낮은 고도가 입력으로 들어와야 함
        ++cnt;
        s.pop();
      }
      // 이전에 나왔던 건물과 고도가 같다면 같은 건물이므로, 스택에 push하지 않음
      if (s.isEmpty() || s.peek().y != y)
        s.push(new Point(x, y));
    }
    // 스택에 남아있는 고도들에 대해 높이가 0일 경우를 제외하고, cnt에 추가
    while (!s.isEmpty()) {
      if (s.peek().y != 0) {
        ++cnt;
      }
      s.pop();
    }
    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    br.close();
  }
}