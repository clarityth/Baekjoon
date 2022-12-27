import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;
import java.util.HashMap;

public class B13711 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    // int[] order = new int[N];
    int[] sorted = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i){
      // hashmap에 <숫자, 입력 순서> 입력
      hm.put(Integer.parseInt(st.nextToken()), i);
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i){
      // 두번째 수열의 원소가 첫번째 수열에서 입력된 순서대로 저장
      sorted[i] = hm.get(Integer.parseInt(st.nextToken()));
    }
    Vector<Integer> v = new Vector<Integer>();
    // 벡터 내의 마지막 원소보다 현재 들어올 값이 큰 경우, 벡터의 맨 뒤에 추가
    // 작을 경우, 해당 숫자가 들어가야할 자리에 있는 원소를 교체
    for(int n : sorted){
      if (v.isEmpty())
        v.add(n);
      else if (v.lastElement() < n)
        v.add(n);
      else
        v.set(-Collections.binarySearch(v, n)-1, n);
    }
    bw.write(String.valueOf(v.size()));
    bw.flush();
    bw.close();
    br.close();
  }
}