import java.util.Scanner;
import java.util.Stack;

public class B10799 {
    // 쇠막대기
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack <Character> st = new Stack<>();

        int cnt = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){ // 막대 시작
                st.push(c);
            }
            if (c == ')'){
                st.pop();
                if (s.charAt(i-1) == '('){ // 레이저일 경우
                    cnt += st.size();
                }
                else { // 막대의 끝일 경우
                    cnt++;
                }

            }
        }
        System.out.println(cnt);
    }
}
