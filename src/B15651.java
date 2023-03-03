import java.io.*;
import java.util.*;

public class B15651 {
  static int N, M;
  static StringBuilder sb;
  static void permutation(int[] num, int[] output, boolean visited[], int depth, int idx, int r){
    if (depth == r){
      for (int i = 0; i < r; ++i){
        sb.append(output[i] + " ");
      }
      sb.append("\n");
      return;
    }
    
    for (int i = 0; i < N; ++i) {
      output[depth] = num[i];
      permutation(num, output, visited, depth + 1, i, r);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sb = new StringBuilder();
    int num[] = new int[N];
    int output[] = new int[N];
    for (int i = 0; i < N; ++i){
      num[i] = i + 1;
    }
    permutation(num, output, visited, 0, 0, M);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
