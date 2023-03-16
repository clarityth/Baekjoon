import java.io.*;
import java.util.*;

public class B2668 {
  static int N, startIdx, table[];
  // 인덱스의 오름차순 정렬을 위해 treeSet 구조 사용
  static TreeSet<Integer> temp;
  static TreeSet<Integer> res;
  static boolean visited[];

  static void dfs(int nowIdx) {
    if (!visited[nowIdx]) {
      int nextIdx = table[nowIdx];
      visited[nowIdx] = true;
      temp.add(nowIdx);
      dfs(nextIdx);
    }
    else {
      // 시작 인덱스와 현재 인덱스가 같은 경우 (cycle이 생기는 경우) -> 두 집합이 일치하게 됨, 따라서 temp에 저장되어 있는 모든 정수들을 res로 옮김
      if (startIdx == nowIdx) {
        for (int idx : temp)
          res.add(idx);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    table = new int[N + 1];
    for (int i = 1; i <= N; ++i) 
      table[i] = Integer.parseInt(br.readLine());
    res = new TreeSet<Integer>();
    for (int i = 1; i <= N; ++i){
      visited = new boolean[N + 1];
      temp = new TreeSet<Integer>();
      startIdx = i;
      dfs(i);
    }
    bw.write(String.valueOf(res.size()) + "\n");
    for (int num : res)
      bw.write(String.valueOf(num) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
