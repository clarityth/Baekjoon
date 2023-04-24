// 막대기
import java.util.Scanner;

public class B1094 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int cnt = 0;
    while (x != 0) { // 비트마스킹
      if (x % 2 != 0) {
        cnt++;
      }
      x /= 2;
    }
    System.out.println(cnt);
  }
}
