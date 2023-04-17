// N-Queen
import java.io.*;
import java.util.*;

public class B3344 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Vector<Integer> odd = new Vector<Integer>();
    Vector<Integer> even = new Vector<Integer>();
    if ((N % 6 != 2) && (N % 6 != 3)) {
      // 짝수 - 홀수 순으로 배치
      for (int i = 1; i <= N; ++i) {
        if (i % 2 == 0) {
          even.add(i);
        } else {
          odd.add(i);
        }
      }
    } else {
      if (N % 6 == 2) {
        // 홀수 리스트 1과 3을 바꾸고, 5를 끝으로 이동
        odd.add(3);
        odd.add(1);
        for (int i = 1; i <= N; ++i) {
          if (i == 1 || i == 3 || i == 5) {
            continue;
          } else {
            if (i % 2 == 0) {
              even.add(i);
            } else {
              odd.add(i);
            }
          }
        }
        odd.add(5);
      } else if (N % 6 == 3) {
        // 2를 짝수 리스트의 끝으로, 1,3을 홀수 리스트의 끝으로 이동
        for (int i = 1; i <= N; ++i) {
          if (i == 1 || i == 2 || i == 3)
            continue;
          if (i % 2 == 0) {
            even.add(i);
          } else {
            odd.add(i);
          }
        }
        even.add(2);
        odd.add(1);
        odd.add(3);
      }
    }
    for (int ePos : even)
      bw.write(ePos + "\n");
    for (int oPos : odd)
      bw.write(oPos + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
