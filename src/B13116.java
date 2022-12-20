import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      // BST이므로, h = log2(n)
      int height_A = (int) (Math.log10(A) / Math.log10(2));
      int height_B = (int) (Math.log10(B) / Math.log10(2));
      while (A != B){
        if (height_A > height_B) {
          A/=2;
          height_A -= 1;
        }
        else if (height_A < height_B){
          B/=2;
          height_B -= 1;
        }
        else {
          A/=2;
          B/=2;
        }
      }
      sb.append(10*A + "\n");
    }
    System.out.println(sb);
  }
}
