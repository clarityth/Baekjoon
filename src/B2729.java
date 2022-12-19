import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class B2729 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    boolean isRounded = false, isAllZero = true;
    char AChar, BChar;
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Stack<Character> stack = new Stack<>();
      String A = st.nextToken();
      String B = st.nextToken();
      int ALen = A.length() - 1;
      int BLen = B.length() - 1;
      while (ALen >= 0 && BLen >= 0) {
        AChar = A.charAt(ALen--);
        BChar = B.charAt(BLen--);
        if (!isRounded) {
          if (AChar == '0' && BChar == '0') {
            stack.push('0');
            isRounded = false;
          } else if (AChar == '0' && BChar == '1') {
            isAllZero = false;
            stack.push('1');
            isRounded = false;
          } else if (AChar == '1' && BChar == '0') {
            isAllZero = false;
            stack.push('1');
            isRounded = false;
          } else if (AChar == '1' && BChar == '1') {
            isAllZero = false;
            stack.push('0');
            isRounded = true;
          }
        } else {
          if (AChar == '0' && BChar == '0') {
            stack.push('1');
            isRounded = false;
          } else if (AChar == '0' && BChar == '1') {
            isAllZero = false;
            stack.push('0');
            isRounded = true;
          } else if (AChar == '1' && BChar == '0') {
            isAllZero = false;
            stack.push('0');
            isRounded = true;
          } else if (AChar == '1' && BChar == '1') {
            isAllZero = false;
            stack.push('1');
            isRounded = true;
          }
        }
      }
      if (ALen < 0 && BLen >= 0) {
        while (BLen >= 0) {
          BChar = B.charAt(BLen--);
          if (isRounded) {
            if (BChar == '1') {
              isAllZero = false;
              stack.push('0');
              isRounded = true;
            } else {
              stack.push('1');
              isRounded = false;
            }
          } else {
            stack.push(BChar);
            isRounded = false;
          }
        }
      } else if (BLen < 0 && ALen >= 0) {
        while (ALen >= 0) {
          AChar = A.charAt(ALen--);
          if (isRounded) {
            if (AChar == '1') {
              isAllZero = false;
              stack.push('0');
              isRounded = true;
            } else {
              stack.push('1');
              isRounded = false;
            }
          } else {
            stack.push(AChar);
            isRounded = false;
          }
        }
      }
      if (isAllZero) {
        System.out.println("0");
        System.exit(0);
      }
      if (isRounded) {
        stack.push('1');
      }
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      boolean isStartedZero = true;
      for (int j = 0; j < sb.length(); j++) {
        if (sb.charAt(j) == '0') {
          if (isStartedZero)
            sb.deleteCharAt(j);
        } else {
          isStartedZero = false;
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
