import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B18258 {
    // 큐 2
    // queue 시간초과 해결 -> deque 사용
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offerLast(num);
                    break;

                case "pop" :
                    if (q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.pollFirst()).append("\n");
                    break;

                case "size" :
                    sb.append(q.size()).append("\n");
                    break;

                case "empty" :
                    if (q.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                    break;

                case "front" :
                    if (q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.peek()).append("\n");
                    break;

                case "back" :
                    if (q.isEmpty())
                        sb.append("-1").append("\n");
                    else
                        sb.append(q.peekLast()).append("\n");
                        break;
            }
        }
        System.out.println(sb);
    }
}
