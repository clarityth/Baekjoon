// 카드2
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B2164 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Deque<Integer> deque = new LinkedList<>();
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++){
      deque.offerLast(i);
    }

    while (deque.size() > 1){ // 카드가 한 장 남을 때까지 반복
      deque.pollFirst(); // 제일 위에 있는 카드를 바닥에 버림
      deque.offerLast(deque.pollFirst()); // 제일 위에 있는 카드를 제일 밑으로 옮김
    }
    System.out.println(deque.poll());
  }
}
