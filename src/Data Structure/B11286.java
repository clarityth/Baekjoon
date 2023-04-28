// 절댓값 힙
import java.util.PriorityQueue;
import java.util.Scanner;

public class B11286 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
      int abs1 = Math.abs(o1);
      int abs2 = Math.abs(o2);
      if (abs1 > abs2){ // 절댓값으로 비교
        return 1;
      }
      else if (abs1 == abs2){ // 절댓값이 같은 경우, 작은 수 우선
        return o1 - o2;
      }
      else {
        return -1;
      }
    });
    int n = sc.nextInt();

    for (int i = 0; i < n; ++i){
      int num = sc.nextInt();
      if (num == 0){
        if (pq.isEmpty()){
          System.out.println("0");
        }
        else {
          System.out.println(pq.poll());
        }
      }
      else {
        pq.offer(num);
      }
    }
  }
}
