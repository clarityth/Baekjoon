// 가장 긴 바이토닉 부분 수열
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

public class B11054 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N + 1];
    int[] rightDp = new int[N + 1];
    int[] leftDp = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    rightDp[0] = leftDp[0] = 1;

    for (int i = 1; i <= N; ++i) 
      sequence[i] = Integer.parseInt(st.nextToken());
    
    for (int i = 1; i <= N; ++i){
      leftDp[i] = 1;
      for (int j = 1; j < i; ++j){
        if (sequence[i] > sequence[j]){
          leftDp[i] = Math.max(leftDp[i], leftDp[j] + 1);
        }
      }
    }
    for (int i = N; i >= 1; --i){
      rightDp[i] = 1;
      for (int j = N; j > i; --j){
        if (sequence[i] > sequence[j]){
          rightDp[i] = Math.max(rightDp[i], rightDp[j] + 1);
        }
      }
    }

    int max = -1;
    for (int i = 1; i <= N; ++i)
      max = Math.max(max, leftDp[i] + rightDp[i]);
    
    bw.write(String.valueOf(max - 1) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}