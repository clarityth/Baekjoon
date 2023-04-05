import java.io.*;
import java.util.*;

public class B1918 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    Stack<Character> op = new Stack<Character>();
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      // 우선순위가 낮은 연산자를 만날때까지 pop하고, 자신을 push
      if (c == '+' || c == '-') {
        if (op.isEmpty()) {
          op.push(c);
          continue;
        }
        while (!op.isEmpty()) {
          if (op.peek() != '(')
            sb.append(op.pop());
          else
            break;
        }
        op.push(c);
      }
  
      else if (c == '*' || c == '/') {
        while (!op.isEmpty()) {
          char top = op.peek();
          if (top == '+' || top == '-' || top == '(')
            break;
          sb.append(op.pop());
        }
        op.push(c);
      } 
      else if (c == '(') {
        op.push('(');
      } 
      else if (c == ')') {
        // 닫힌 괄호인 경우, 여는 괄호를 만날때까지 pop하고 여는 괄호를 삭제
        while (!op.isEmpty()) { 
          if (op.peek() == '(') {
            op.pop();
            break;
          }
          else
            sb.append(op.pop());
        }
      }
      // 피연산자의 경우, 그냥 출력
      else {
        sb.append(c);
      }
    }
    // 남아있는 연산자들을 출력
    while (!op.isEmpty()) 
      sb.append(op.pop());
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}