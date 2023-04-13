import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747 {
  public static boolean isPrime(int N){
    for(int i=2; i<N; i++){
      if (N%i == 0)
        return false;
    }
    return true;
  }
  public static boolean isPalindrome(String s){
    StringBuffer sb = new StringBuffer(s);
    String prime = s;
    String revPrime = sb.reverse().toString();
    if (prime.equals(revPrime))
      return true;
    else
      return false;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if (N == 1){
      System.out.println("2");
      System.exit(0);
    }
    for(int i=N; i<1003002; i++){
      if (isPalindrome(Integer.toString(i))){
        if (isPrime(i)){
          System.out.println(i);
          break;
        }
      }
    }
  }
}