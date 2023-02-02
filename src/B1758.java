import java.io.*;
import java.util.*;

public class B1758 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Integer tips[] = new Integer[N];
    for(int i=0; i<N; ++i){
      tips[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(tips, Comparator.reverseOrder());
    long maxTip = 0l;
    for(int i = 0; i < N; ++i){
      if (tips[i]-i > 0)
        maxTip += tips[i]-i;
    }
    bw.write(String.valueOf(maxTip));
    bw.flush();
    bw.close();
    br.close();
  }
}