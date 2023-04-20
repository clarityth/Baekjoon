// 최소 힙
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1927 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> q = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      if (x == 0) {
        if (q.size() == 0) {
          System.out.println("0");
        }
        else {
          System.out.println(q.poll());
        }
      }
      else if (x > 0) {
        q.offer(x);
      }
    }
  }
}
