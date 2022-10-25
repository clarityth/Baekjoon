import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {
    // 요세푸스 문제
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<n; i++){ // enqueue
            q.add(i+1);
        }

        sb.append("<");
        while(! q.isEmpty()) { // dequeue
            for (int i = 0; i < k - 1; i++) { // k-1번 front의 원소를 rear에 삽입
                q.add(q.remove());
            }
            if(q.size() == 1){ // front의 원소를 삭제
                sb.append(q.remove());
            }
            else {
                sb.append(q.remove());
                sb.append(", ");
            }

        }
        sb.append(">");
        System.out.println(sb);
    }
}
