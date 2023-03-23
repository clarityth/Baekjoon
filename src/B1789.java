import java.io.*;
import java.util.*;

public class B1789 {
  static long s;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    s = Long.parseLong(br.readLine());
    long sum = 0l, n = 0l, i = 0l;
    // 1부터 더해가다가 sum이 s를 넘는 순간 이전에 더해준 숫자를 적절한 값으로 바꿔주면 s를 만들 수 있음
    while (true) {
      sum += i++;
      if (sum > s) {
        --n;
        break;
      }
      ++n;
    }
    bw.write(String.valueOf(n));
    bw.flush();
    bw.close();
    br.close();
  }
}