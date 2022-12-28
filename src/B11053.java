import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }
    Vector<Integer> lis = new Vector<Integer>();
    for (int e : sequence) {
      if (lis.isEmpty() || lis.lastElement() < e)
        // 벡터가 비어있거나 벡터의 마지막 원소보다 현재 원소가 더 크다면 맨 뒤에 삽입
        lis.add(e);
      else {
        // 해당 원소가 삽입될 자리를 찾아 기존 원소를 교체
        int pos = Collections.binarySearch(lis, e);
        /* Collections.binarySearch() -> 해당 원소를 발견했다면, 그 위치를 리턴  
                                         발견하지 못했다면, -InsertionPoint - 1을 리턴 (*Insertion Point : 해당 원소가 있었다면 삽입되었을 위치) */
        if (pos < 0) {
          pos = (pos * -1) - 1;
        }
        lis.set(pos, e);
      }
    }
    bw.write(String.valueOf(lis.size()));
    bw.flush();
    bw.close();
    br.close();
  }
}