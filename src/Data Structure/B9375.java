import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class B9375 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      Map<String, Integer> catagoryMap = new HashMap<String, Integer>();
      for (int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String clothes = st.nextToken();
        String catagory = st.nextToken();
        catagoryMap.put(catagory, catagoryMap.getOrDefault(catagory, 0) + 1);
      }
      int res = 1;
      for (Entry<String, Integer> es : catagoryMap.entrySet()) {
        int temp = es.getValue();
        res *= temp+1;
      }
      sb.append(res-1 + "\n");
    }
    System.out.println(sb);
  }
}
