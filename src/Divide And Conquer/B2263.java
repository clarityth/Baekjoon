import java.io.*;
import java.util.*;

public class B2263 {
  static void preOrder(int in_start, int in_end, int post_start, int post_end) {
    if (in_start > in_end || post_start > post_end)
      return;
    // 루트 = postOrder의 마지막
    int root = postOrder[post_end];
    sb.append(root + " ");
    int rootIdx = hm.get(root);
    // inOrder 순회에서 루트의 왼쪽에 있는 리프의 갯수
    int left = rootIdx - in_start;
    // left sub tree
    preOrder(in_start, rootIdx - 1, post_start, post_start + left - 1);
    // right sub tree
    preOrder(rootIdx + 1, in_end, post_start + left, post_end - 1);
  }
  static StringBuilder sb;
  static final int INF = 987654321;
  static int n, rootIdx;
  static int[] inOrder, postOrder;
  static HashMap<Integer, Integer> hm;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    inOrder = new int[n];
    postOrder = new int[n];
    hm = new HashMap<Integer, Integer>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      inOrder[i] = num;
      hm.put(num, i);
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) 
      postOrder[i] = Integer.parseInt(st.nextToken());
    
    sb = new StringBuilder();
    preOrder(0, n-1, 0, n-1);
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}