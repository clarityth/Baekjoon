import java.io.*;
import java.util.*;
import java.math.*;

public class B13305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    long distances[] = new long[N+1];
    long oilPrices[] = new long[N+1];
    long totalPrice = 0l;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<N; ++i){
      distances[i] = Long.parseLong(st.nextToken());
    }
    
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i){
      oilPrices[i] = Long.parseLong(st.nextToken());
    }
    totalPrice = oilPrices[0] * distances[1];
    long minPrice = oilPrices[0];
    for(int i=1; i<N; ++i){
      if (minPrice < oilPrices[i]){
        totalPrice += minPrice * distances[i+1];
      }
      else {
        minPrice = oilPrices[i];
        totalPrice += minPrice * distances[i+1];
      }
    }
    bw.write(String.valueOf(totalPrice));
    bw.flush();
    bw.close();
    br.close();
  }
}