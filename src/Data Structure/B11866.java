// 요세푸스 문제 0
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    Queue <Integer> q = new LinkedList<>();
    int n = sc.nextInt();
    int k = sc.nextInt();
    for (int i = 1; i <= n; ++i) {
      q.offer(i);
    }

    sb.append("<");
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < k - 1; ++j) {
        q.offer(q.poll()); // k-1번 큐의 맨앞 원소를 뽑아서 뒤에 붙힘
      }
      sb.append(q.poll()); // k번째 원소 제거

      if (q.size() == 0) { // 큐가 비워진 경우, ">" 출력
        sb.append(">");
      }
      else {
        sb.append(", ");
      }
    }
    System.out.println(sb);
  }
}