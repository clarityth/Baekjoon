// 균형잡힌 세상
import java.util.Scanner;
import java.util.Stack;

public class B4949 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String str = sc.nextLine();
      if (str.equals(".")) 
        break;
      System.out.println(balance(str));
    }
  }

  public static String balance(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(') // 여는 괄호일 경우, push
        s.push(c);
      else if (c == '[') 
        s.push(c);
      else if (c == ')') {
        if (s.empty() || s.peek() != '(')  // 스택이 비었거나, 스택의 top이 여는 괄호가 아닐경우
          return "no";
        else 
          s.pop();
      } else if (c == ']') {
        if (s.empty() || s.peek() != '[') 
          return "no";
        else 
          s.pop();
      }
    }
    if (s.empty())
      return "yes";
    else 
      return "no";
  }
}
