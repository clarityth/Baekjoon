import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;
import java.util.Stack;

public class B11722 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] sequence = new int[N];
    int[] idxOrder = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < N; ++i) 
      sequence[i] = Integer.parseInt(st.nextToken());
    
    Vector<Integer> v = new Vector<Integer>();
    int idx = -1;
    for(int i = 0; i < N; ++i){
      int num = sequence[i];
      if (v.isEmpty()){
        v.add(num);
        idx = 0;
      } 
      else if (v.lastElement() > num){
        v.add(num);
        idx = v.size()-1;
      }
      else {
        idx = Collections.binarySearch(v, num, Collections.reverseOrder());
        if (idx < 0){
          idx = (-1 * idx) - 1;
        }
        v.set(idx, num);
      }
      idxOrder[i] = idx;
    }
    bw.write(String.valueOf(v.size()));
    bw.flush();
    bw.close();
    br.close();
  }
}