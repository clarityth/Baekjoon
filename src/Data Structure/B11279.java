// 최대 힙
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11279 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue <Integer> q = new PriorityQueue<>();

    for (int i = 0; i < n; ++i){
      int x = sc.nextInt();
      if (x == 0) {
        if (q.size() == 0) {
          System.out.println("0");
        }
        else {
          System.out.println(-q.poll()); // -를 붙여서 출력 (본래 값으로 출력)
        }
      }
      else if (x > 0) {
        q.offer(-x); // -를 붙여서 힙에 우선순위 큐에 저장 (가장 큰 값이 가장 작은 값이 됨)
      }
    }
  }
}
