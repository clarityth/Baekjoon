import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B17499 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int[] progression = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      progression[i] = Integer.parseInt(st.nextToken());
    }
    int offset = 0;
    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int opCode = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      if (st.hasMoreTokens()) {
        // 더하기 연산
        int b = Integer.parseInt(st.nextToken());
        progression[(offset + a - 1) % N] += b;
      } else {
        // 시프트 연산
        if (opCode == 2) {
          // 오른쪽 시프트
          offset = (offset + N - a) % N;
        } else if (opCode == 3) {
          // 왼쪽 시프트
          offset = (offset + a) % N;
        }
      }
    }
    for (int j = offset; j < offset + N; j++) {
      bw.write(String.valueOf(progression[j % N]));
      bw.write(" ");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}