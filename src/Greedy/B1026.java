import java.io.*;
import java.util.*;

public class B1026 {
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    Integer a[] = new Integer[n];
    Integer b[] = new Integer[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; ++i)
      a[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; ++i)
      b[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(a);
    Arrays.sort(b, Collections.reverseOrder());
    int s = 0;
    for (int i = 0; i < n; ++i) 
      s += a[i] * b[i];
    bw.write(String.valueOf(s));
    bw.flush();
    bw.close();
    br.close();
  }
}