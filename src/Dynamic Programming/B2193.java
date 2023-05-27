// 이친수
import java.io.*;
import java.util.*;

public class B2193 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    if (N < 3){
      // N이 1, 2인 경우 조건에 의해 각각 1, 10으로 고정됨
      bw.write("1");
      bw.flush();
      bw.close();
      br.close();
      return;
    }
    long[] DP = new long[N];
    DP[0] = 0l;
    DP[1] = 1l; 
    for(int i = 2; i <= N; ++i){
      DP[i] = DP[i-2] + DP[i-1];
    }
    bw.write(String.valueOf(DP[N])); 
    bw.flush();
    bw.close();
    br.close();
  }
}