import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class B1343 {
  public static final int MAXSIZE = 51;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String board = br.readLine();
    int len = board.length(), idx = 0;
    int[] cnts = new int[MAXSIZE];
    StringBuilder sb = new StringBuilder();
    // (!) 실수했었던 반례: X가 아예 존재하지 않는 . 같은 케이스의 경우 -> . 그대로 출력해야함
    for (int i = 0; i < len; ++i){
      char c = board.charAt(i);
      if (c == 'X'){
        // X가 나온 경우 배열에 저장된 값을 1 증가시킴
        ++cnts[idx];
      }
      else {
        // .이 나온 경우에는 2가지 케이스로 나뉨
        if (i > 0 && board.charAt(i-1) == 'X'){
          // X 이후에 .이 나온 경우 -> 인덱스를 먼저 증가시키고, 배열에 -1을 넣은 뒤, 인덱스를 증가시킴.
          cnts[++idx] = -1;
          ++idx;  
        }
        else if (i == 0 || board.charAt(i-1) == '.'){
          // 처음 .이 나오는 경우와 연속해서 .이 나오는 경우 -> 배열에 -1을 넣고, 인덱스를 증가시킴.
          cnts[idx++] = -1;
        }
      }
    }
    for (int cnt : cnts){
      if (cnt == -1){
        sb.append(".");
        continue;
      }
      if (cnt == 0)
      // 마지막 인덱스를 의미
        break;
      if (cnt >= 4){
        while (cnt >= 4){
          cnt -= 4;
          sb.append("AAAA");
        }
      }
      if (cnt >= 2){
        while (cnt >= 2){
          cnt -= 2;
          sb.append("BB");
        }
      }
      if (cnt != 0){
        bw.write("-1");
        bw.flush();
        bw.close();
        br.close();
        return;
      }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}