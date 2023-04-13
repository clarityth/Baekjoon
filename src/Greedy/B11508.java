import java.io.*;
import java.util.*;

public class B11508 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Integer prices[] = new Integer[N];
    // Comparator.reverseOrder() 사용을 위해 wrapper class로 boxing
    for(int i=0; i<N; ++i){
      prices[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(prices, Comparator.reverseOrder());
    int minPay = 0;
    for(int i = 0; i < N; ++i){
      if (i % 3 == 2)
        continue;
      minPay += prices[i];
    }
    bw.write(String.valueOf(minPay));
    bw.flush();
    bw.close();
    br.close();
  }
}