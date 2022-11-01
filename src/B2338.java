import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B2338 {
    //긴자리 계산
    public static void main (String[] args){
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      BigInteger a = new BigInteger(br.readLine());
      BigInteger b = new BigINteger(br.readLine());
      System.out.println(a.add(b));
      System.out.println(a.subtract(b));
      System.out.println(a.multiply(b));
    }
}
