import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class B1074 {
  public static int N, r, c, visitCnt = 0;
  public static void Z (int x, int y, int size){
    if (x == c && y == r){
      System.out.println(visitCnt);
      return;
    }
    else {
      if (r < y+size && r >= y && c < x+size && c >= x){
        // 현재 사분면 위에 존재
        Z(x, y, size/2);
        // 1사분면 탐색
        Z(x+size/2, y, size/2);
        // 2사분면 탐색
        Z(x, y+size/2, size/2);
        // 3사분면 탐색
        Z(x+size/2, y+size/2, size/2);
        // 4사분면 탐색
      }  
      else {
        // 현재 사분면 위에 존재하지 않음
        visitCnt += Math.pow(size, 2);
      }
    }
  }
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    Z(0, 0, (int) Math.pow(2, N));
  }
}

