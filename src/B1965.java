import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

public class B1965 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] boxSizes = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; ++i)
      boxSizes[i] = Integer.parseInt(st.nextToken());

    // 이분 탐색 알고리즘 -> O(NlogN)
    Vector<Integer> v = new Vector<Integer>();
    for (int i = 0; i < N; ++i) {
      int num = boxSizes[i];
      if (v.isEmpty()) {
        v.add(num);
      } else if (v.lastElement() < num) {
        v.add(num);
      } else {
        int idx = Collections.binarySearch(v, num);
        if (idx < 0) {
          idx = (-1 * idx) - 1;
        }
        v.set(idx, num);
      }
    }
    bw.write(String.valueOf(v.size()));

    // DP 알고리즘 -> O(N^2)
    // int[] lis = new int[N];
    // lis[0] = 1;

    // int maxBoxCnt = 0;
    // for (int i = 1; i < N; ++i) {
    //   lis[i] = 1;
    //   for (int j = 0; j < i; ++j) {
    //     if (boxSizes[i] > boxSizes[j]) {
    //       lis[i] = Math.max(lis[i], lis[j] + 1);
    //     }
    //   }
    //   maxBoxCnt = Math.max(lis[i], maxBoxCnt);
    // }
    // bw.write(String.valueOf(maxBoxCnt));
    bw.flush();
    bw.close();
    br.close();
  }
}