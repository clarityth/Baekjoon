import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11866 {
    // 요세푸스 문제 0
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue <Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i=1; i<=n; i++){
            q.offer(i);
        }

        sb.append("<");
        for (int i=0; i<n; i++) {
            for (int j = 0; j < k - 1; j++) {
                q.offer(q.poll());
            }
            sb.append(q.poll());

            if (q.size() == 0) {
                sb.append(">");
            }
            else {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
