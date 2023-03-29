import java.io.*;
import java.util.*;

public class B2864 {
  static int minN = 0, maxN = 0;
  static void getNewN(int n){
    minN = maxN = 0;
    int i = 0;
    while (n > 0) {
      int temp = n % 10;
      int digit = (int) Math.pow(10, i++);
      if (temp == 5) {
        maxN += 6 * digit;
        minN += temp * digit;
      } else if (temp == 6) {
        minN += 5 * digit;
        maxN += temp * digit;
      }
      else {
        maxN += temp * digit;
        minN += temp * digit;
      }
      n /= 10;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    getNewN(A);
    int maxA = maxN;
    int minA = minN;
    getNewN(B);
    int maxB = maxN;
    int minB = minN;
    bw.write(String.valueOf(minA + minB) + " " + String.valueOf(maxA + maxB));
    bw.flush();
    bw.close();
    br.close();
  }
}