import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class B10866 {
    // 덱
    public static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            String str = sc.next();

            switch(str){
                case "push_front":
                    dq.offerFirst(sc.nextInt());
                    break;

                case "push_back":
                    dq.offerLast(sc.nextInt());
                    break;

                case "pop_front":
                    sb.append(pop_front()+"\n");
                    break;

                case "pop_back":
                    sb.append(pop_back()+"\n");
                    break;

                case "size":
                    sb.append(dq.size()+"\n");
                    break;

                case "empty" :
                    sb.append(empty()+"\n");
                    break;

                case "front" :
                    sb.append(front()+"\n");
                    break;

                case "back" :
                    sb.append(back()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static int pop_front() {
        if (dq.isEmpty())
            return -1;
        else
            return dq.pollFirst();
    }

    public static int pop_back() {
        if (dq.isEmpty())
            return -1;
        else
            return dq.pollLast();
    }

    public static int empty() {
        if (dq.isEmpty())
            return 1;
        else
            return 0;
    }

    public static int front(){
        if (dq.isEmpty())
            return -1;
        else
            return dq.peekFirst();
    }

    public static int back(){
        if (dq.isEmpty())
            return -1;
        else
            return dq.peekLast();
    }
}
