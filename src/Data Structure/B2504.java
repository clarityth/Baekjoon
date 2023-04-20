// 괄호의 값
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class B2504 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String inputStr = br.readLine();
    Stack<Character> bracketStack = new Stack<Character>();
    int finalValue = 0, tempValue = 0;
    
    for (int i = 0; i < inputStr.length(); ++i){
      char bracket = inputStr.charAt(i);
      if (bracket == '('){
        // 여는 괄호일 경우 2를 곱해줌
        bracketStack.push(bracket);
        if (tempValue == 0)
          tempValue = 2;
        else
          tempValue *= 2;
      } 
      else if (bracket == '['){
        // 여는 괄호일 경우 3을 곱해줌
        bracketStack.push(bracket);
        if (tempValue == 0)
          tempValue = 3;
        else
          tempValue *= 3;
      }
      else if (bracket == ')'){
        if (bracketStack.isEmpty() || bracketStack.peek() != '('){
          // 정상적이지 않은 괄호
          finalValue = 0;
          break;
        }
        bracketStack.pop();
        if (inputStr.charAt(i - 1) == '(') {
          // 직전이 여는 괄호였다면, 계산한 값을 더해주고 2로 나누어줌
          finalValue += tempValue;
          tempValue /= 2;
        }
        else
          // 직전이 여는 괄호가 아니라면, 2로 나누어줌
          tempValue /= 2;
      }
      else if (bracket == ']'){
        if (bracketStack.isEmpty() || bracketStack.peek() != '['){
          // 정상적이지 않은 괄호
          finalValue = 0;
          break;
        }
        bracketStack.pop();
        if (inputStr.charAt(i-1) == '['){
          // 직전이 여는 괄호였다면, 계산된 값을 더해주고 3을 나눠줌
          finalValue += tempValue;
          tempValue /= 3;
        }
        else {
          // 여는 괄호가 아니라면, 3을 나눠줌
          tempValue /= 3;
        }
      }
    }
    if (!bracketStack.isEmpty())
      finalValue = 0;
    // !예외 처리: 전부 끝났는데 괄호가 스택에 남아 있는 경우
    bw.write(String.valueOf(finalValue));
    bw.flush();
    bw.close();
    br.close();
  }
}