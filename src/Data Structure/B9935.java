// 문자열 폭발
import java.io.*;
import java.util.*;

public class B9935 {
  static int top = 0;
  static char stack[];
  static void push(char c) {
    stack[top++] = c;
  }
  static char pop() {
    return stack[--top];
  }
  static char peek() {
    return stack[top - 1];
  }
  static boolean isEmpty() {
    return top == 0;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String originStr = br.readLine();
    String bombStr = br.readLine();
    int originLen = originStr.length();
    int bombLen = bombStr.length();
    stack = new char[originLen + 1];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < originLen; ++i) {
      push(originStr.charAt(i));
      // 만약 넣어진 한 글자가 폭발 문자열의 마지막와 같다면
      if (peek() == bombStr.charAt(bombLen - 1)) {
        // 폭탄 문자열의 끝부터 처음까지 top - 1부터 역순으로 비교
        boolean isBomb = true;
        int targetIdx = top - 1;
        if (targetIdx < bombLen - 1)
          continue;
        for (int j = bombLen - 1; j >= 0; --j) {
          // 폭탄 문자열과 다르다면 플래그를 변경하고 탈출
          if (!(bombStr.charAt(j) == stack[targetIdx--])) {
            isBomb = false;
            break;
          }
        }
        // 폭탄 문자열이라면 폭탄 문자열 삭제
        if (isBomb) {
          for (int j = 0; j < bombLen; ++j)
            pop();
        }
      }
    }
    // 문자열이 남아있지 않다면 FRULA 출력
    if (isEmpty())
      sb.append("FRULA");
    // 남은 문자열을 정방향 출력
    else {
      for (int i = 0; i < top; ++i) {
        sb.append(stack[i]);
      }
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}