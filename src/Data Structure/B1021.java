// 회전하는 큐
import java.util.*;

public class B1021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> q = new LinkedList<>();

        int n = sc.nextInt(); // 큐의 크기
        int m = sc.nextInt(); // 뽑아내려고 하는 수의 갯수

        for (int i=1; i<=n; i++){
            q.offerLast(i); // 초기 인덱스를 값으로 지정
        }

        int cnt = 0;
        for (int i=0; i<m; i++){
            int p = sc.nextInt(); // 뽑아내려고 하는 수의 위치 (초기)
            int idx = 0;
            Iterator<Integer> it = q.iterator();
            while (it.hasNext()){
                int num = it.next();
                idx++;
                if(num == p){
                    break;
                }
            }
            if (idx <= q.size()-idx+1) { // 앞에서 뽑는게 최소횟수일 경우 (뒤부터 셀 경우 한 칸 더 밀어줘야함)
                while (true) {
                    if (q.peekFirst() == p) {
                        q.pollFirst();
                        break;
                    }
                    ++cnt;
                    q.offerLast(q.peekFirst());
                    q.pollFirst();

                }
            }
            else { // 뒤에서 뽑는게 최소횟수일 경우
                while (true) {
                    if (q.peekFirst() == p){
                        q.pollFirst();
                        break;
                    }
                    ++cnt;
                    q.offerFirst(q.peekLast());
                    q.pollLast();
                }
            }
        }
        System.out.println(cnt);
    }
}
