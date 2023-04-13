import java.io.*;
import java.util.*;

public class B2217 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Integer[] maxWeights = new Integer[N];
    for (int i = 0; i < N; ++i) {
      maxWeights[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(maxWeights, Collections.reverseOrder());
    int maxWeight = 0;
    for (int i = 0; i < N; ++i) {
      int w = (i + 1) * maxWeights[i];
      if (w > maxWeight)
        maxWeight = w;
    }
    bw.write(String.valueOf(maxWeight));
    bw.flush();
    bw.close();
    br.close();
  }
}