import java.io.*;
import java.util.*;

public class B1339단어 수학 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Integer alpha[] = new Integer[26];
    for (int i = 0; i < 26; ++i) 
      alpha[i] = 0;
    
    for (int i = 0; i < N; ++i) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); ++j) {
        alpha[input.charAt(j) - 'A'] += (int) Math.pow(10, input.length() - j - 1);
      }
    }
    Arrays.sort(alpha, Collections.reverseOrder());
    int max = 0, targetVal = 9;
    for (int num : alpha) {
      if (num == 0)
        break;
      max += num * targetVal--; 
    }
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }
}