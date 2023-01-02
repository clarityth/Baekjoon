import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B17216 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N];
    int[] dp = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < N; ++i) {
      sequence[i] = Integer.parseInt(st.nextToken());
      dp[i] = sequence[i];
    }

    int maxSum = 0;
    for (int i = 1; i < N; ++i) {
      for (int j = 0; j < i; ++j){
        if (sequence[i] < sequence[j]){
          dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
        }
      }
      maxSum = Math.max(maxSum, dp[i]);
    }
    bw.write(String.valueOf(maxSum));
    bw.flush();
    bw.close();
    br.close();
  }
}