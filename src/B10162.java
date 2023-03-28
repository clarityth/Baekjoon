import java.io.*;
import java.util.*;

public class B10162 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int times[] = {300, 60, 10};
    int cnts[] = new int[3];
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < times.length; ++i){
      while (T >= times[i]) {
        ++cnts[i];
        T -= times[i];
      }
    }
    if (T > 0)
      bw.write("-1");
    else {
      for(int i = 0; i < 3; ++i)
        bw.write(String.valueOf(cnts[i] + " "));
    }
    bw.flush();
    bw.close();
    br.close();
  }
}