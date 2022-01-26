import java.util.Scanner;
import java.util.Stack;

public class B1874 {
    // 스택 수열
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 1;
        for (int i=0; i<n; i++){
            if (st.empty()){ // 비어있을때 예외처리
                st.push(start++);
                sb.append("+\n");
            }
            if (st.peek() == arr[i]){ // 입력된 숫자와 peek 값이 같을 때, pop
                st.pop();
                sb.append("-\n");
            }
            else if (st.peek() < arr[i]) { // 입력된 숫자가 peek 값보다 클 때, 같아질때까지 push
                while (start <= arr[i]) {
                    st.push(start++);
                    sb.append("+\n");
                }
                st.pop(); // 같아진 순간 pop
                sb.append("-\n");
            }
            else { // 입력된 숫자가 peek 값보다 작을 때, 수열 생성 불가능
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}