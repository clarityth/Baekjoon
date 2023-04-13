import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class B9252 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str1 = br.readLine();
    String str2 = br.readLine();
    int len1 = str1.length();
    int len2 = str2.length();
    int[][] lcs = new int[len1 + 1][len2 + 1];
    
    for (int i = 1; i <= len1; ++i) {
      for (int j = 1; j <= len2; ++j) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }
      }
    }
    int lcsLen = lcs[len1][len2];
    if (lcsLen == 0) {
      bw.write("0");
    } else {
      Stack<Integer> st = new Stack<>();
      int i = len1, j = len2;

      while (lcs[i][j] != 0) {
        if (lcs[i][j] == lcs[i - 1][j])
          --i;
        else if (lcs[i][j] == lcs[i][j - 1])
          --j;
        else if (lcs[i][j] - 1 == lcs[i - 1][j - 1]) {
          st.push(i);
          --i;
          --j;
        }
      }
      bw.write(String.valueOf(lcsLen));
      bw.write("\n");
      while (!st.isEmpty()) {
        bw.write(str1.charAt(st.pop() - 1));
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}