import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B26594 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    int[] cnt = new int[26];
    boolean isBroken = false;
    for(int i=1; i<str.length(); ++i){
      if (str.charAt(i) == str.charAt(i-1)){
        cnt[str.charAt(i) - 'A']++;
        isBroken = true;
      }
    }
    if (isBroken == false) {
      bw.write("1");
    }
    else {
      Arrays.sort(cnt);
      for(int i=0; i<26; i++){
        if (cnt[i] > 0) {
          bw.write(String.valueOf(cnt[i]+1));
          break;
        }
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}