import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class B9251 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str1 = br.readLine();
    String str2 = br.readLine();
    int[][] table = new int[str1.length()+1][str2.length()+1];
    for(int i=1; i<=str1.length(); ++i){
      for(int j=1; j<=str2.length(); ++j){
        if (str1.charAt(i-1) == str2.charAt(j-1))
          table[i][j] = table[i-1][j-1] + 1;
        else 
          table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
      }
    }
    bw.write(String.valueOf(table[str1.length()][str2.length()]));
    bw.flush();
    br.close();
    bw.close();
  }
}