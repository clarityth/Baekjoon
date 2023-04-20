// 프린터 큐
import java.util.*;

public class B1966 {
  public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     StringBuilder sb = new StringBuilder();
     int t = sc.nextInt();
     for (int i = 0; i < t; i++){
       int n = sc.nextInt(); // 문서의 갯수
       int m = sc.nextInt(); // 출력해야하는 문서의 위치
       LinkedList <int[]> q = new LinkedList<int[]>(); // 위치 정보, 중요도를 큐에 삽입
       for (int j = 0; j < n; j++) 
         q.add(new int[] {j, sc.nextInt()});
       int cnt = 0;
       while (!q.isEmpty()){
         int[] first = q.poll(); // 현재 큐의 가장 앞에 있는 문서의 중요도를 확인
         boolean isMax = true;
         for (int j = 0; j < q.size(); j++) {
           if (q.get(j)[1] > first[1]) { // 현재 첫번째 문서보다 중요도가 높은 문서가 하나라도 있다면, 큐의 가장 뒤에 재배치
             q.offer(first);          
             for (int k = 0; k < j; k++) {
               q.offer(q.poll()); // 중요도가 큰 문서와 첫번째 문서 사이의 문서들 재배치
             }
             isMax = false;
             break;
           }
         }
         if (isMax == false)  // 현재 문서가 중요도가 가장 높지 않으면
           continue; // 반복
         cnt++;
         if (first[0] == m)  // 찾는 문서와 현재 첫번째 문서가 일치한다면
           break; // 종료
       }
       sb.append(cnt+"\n");
    }
    System.out.println(sb);
  }
}
