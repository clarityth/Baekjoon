// 단어 뒤집기 2 
import java.io.*;
import java.util.*;

public class B17413 {
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    String str = br.readLine() + " ";
    for (int i = 0; i < str.length(); ++i) {
      char c = str.charAt(i);
      if (c == ' ') {
        while (!stack.empty()) { // 단어 뒤집기
          sb.append(stack.pop());
        }
        sb.append(" ");
      }
      else if (c == '<'){
        while (!stack.isEmpty()) { // 단어 뒤집기
          sb.append(stack.pop());
        }
        int idx = str.indexOf('>', i); // i 이후 처음 등장하는 >의 인덱스
        sb.append(str, i, idx + 1); // 태그는 정방향으로 삽입
        i = idx; // 인덱스 재지정
      }
      else {
        stack.push(c);
      }
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}