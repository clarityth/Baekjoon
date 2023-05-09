// 이진 검색 트리
import java.io.*;
import java.util.*;

public class B5639 {
  static StringBuilder sb;
  static Vector<Integer> pre;
  static void post(int start, int end) {
    if (start >= end)
      return;
    int root = -1;
    for (int i = start + 1; i < end; ++i) {
      if (pre.get(i) > pre.get(start)) {
        root = i;
        break;
      }
    }
    // RST가 존재하지 않는 경우 -> LST 순회 후 자기 자신을 출력
    if (root == -1) {
      post(start + 1, end);
      sb.append(pre.get(start)).append("\n");
    }
    // LST-RST 순으로 순회 후 자기 자신을 출력
    else {
      post(start + 1, root);
      post(root, end);
      sb.append(pre.get(start)).append("\n");
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int root = Integer.parseInt(br.readLine());
    pre = new Vector<Integer>();
    pre.add(root);
    String input = "";
    // EOF까지 입력을 받음
    while (true) {
      input = br.readLine();
      if (input == null || input.equals("")) {
        break;
      }
      pre.add(Integer.parseInt(input));
    }
    sb = new StringBuilder();
    post(0, pre.size());
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}