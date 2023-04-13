import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Character;

public class B10610 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // N의 범위 10^5
    String N = br.readLine();
    int sum = 0;
    // 30의 배수 판정법: 마지막 자릿수가 0 이고, 각 자릿 수의 합이 3의 배수이어야 함
    if (!N.contains("0") || N.equals("0")) {
      System.out.println("-1");
    } else {
      for (int i = 0; i < N.length(); i++) {
        sum += Character.getNumericValue(N.charAt(i));
      }
      if (sum % 3 != 0 || sum == 0) {
        System.out.println("-1");
        System.exit(0);
      }
      // 입력받은 N이 30의 배수라면, 각 자릿수를 내림차순으로 정렬
      char[] c = N.toCharArray();
      Arrays.sort(c);
      StringBuilder sb = new StringBuilder(new String(c));
      sb.reverse().toString();
      System.out.println(sb);
    }
  }
}
