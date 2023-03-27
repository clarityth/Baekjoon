import java.io.*;
import java.util.*;

public class B5585 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int coins[] = {500, 100, 50, 10, 5, 1};
    int amount = Integer.parseInt(br.readLine());
    int change = 1000 - amount;
    int cnt = 0;
    for (int i = 0; i < coins.length; ++i){
      while (change >= coins[i]) {
        ++cnt;
        change -= coins[i];
      }
    }
    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    br.close();
  }
}