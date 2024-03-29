// 중복 제거
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B13701 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int idx, shift, n;
    int arr[] = new int[(1 << 20) + 2];
    // 33554432(2^25)/32(2^5) = 1048576(2^20)
    // arr[0] = 0~31 검사 arr[1] 32 ~ 63 ... 검사
    while (st.hasMoreTokens()) {
      n = Integer.parseInt(st.nextToken());
      idx = n / 32;
      shift = n % 32;
      if ((arr[idx] & (1 << shift)) == 0) {
        sb.append(n + " ");
        arr[idx] += (1 << shift);
      }
    }
    System.out.print(sb);
  }
}