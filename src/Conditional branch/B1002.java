// 터렛
import java.io.*;
import java.util.*;

public class B1002 {
  static void getPosCnt() {
    // 무한대: 두 원의 좌표, 반지름이 모두 일치할 때
    if (x1 == x2 && y1 == y2 && r1 == r2) {
      sb.append("-1\n");
      return;
    }
    int deltaPow = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    // 1: 두 원이 내접하는 경우
    if (deltaPow == (int) Math.pow(r1 - r2, 2)) {
      sb.append("1\n");
      return;
    }
    // 1: 두 원이 외접하는 경우
    if (deltaPow == (int) Math.pow(r1 + r2, 2)) {
      sb.append("1\n");
      return;
    }
    // 0: 두 원의 거리 차이가 두 원의 중점의 합보다 멀리 떨어져 있는 경우
    if (deltaPow > (int) Math.pow(r1 + r2, 2)) {
      sb.append("0\n");
      return;
    }
    // 0: 한 원이 다른 원 안에 위치하지만 내접하지 않는 경우
    if (deltaPow < (int) Math.pow(r1 - r2, 2)) {
      sb.append("0\n");
      return;
    }
    // 2: 이외의 경우 (두 원이 두 점에서 만나는 경우)
    sb.append("2\n");
    return;
  }
  static int T, x1, y1, r1, x2, y2, r2;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    T = Integer.parseInt(br.readLine());
    sb = new StringBuilder();
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      r1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());
      r2 = Integer.parseInt(st.nextToken());
      getPosCnt();
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}