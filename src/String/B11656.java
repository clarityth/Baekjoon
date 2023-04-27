// 접미사 배열
import java.io.*;
import java.util.*;

public class B11656 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String input = br.readLine();
    String[] dict = new String[input.length()];
    for (int i = 0; i < input.length(); ++i) {
      dict[i] = input.substring(i, input.length());
    }
    Arrays.sort(dict);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); ++i) {
      sb.append(dict[i] + "\n");
    }
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}