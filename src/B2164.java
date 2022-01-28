import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B2164 {
    // 카드2
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            deque.offerLast(i);
        }
        for (int i=0; i<n-1; i++){
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }
}
