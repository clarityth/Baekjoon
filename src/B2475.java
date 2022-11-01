import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringTokenizer;

public class B2475 {
    // 검증수
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int res = 0;
    for (int i=0; i<5; i++) {
      int a = Integer.parseInt(st.nextToken());
      res += a*a;
    }
    System.out.println(res%10);
  }
}
