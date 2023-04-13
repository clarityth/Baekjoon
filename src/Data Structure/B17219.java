import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class B17219{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    HashMap<String, String> hm = new HashMap<>();
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      String site = st.nextToken();
      String pw = st.nextToken();
      hm.put(site, pw);
    }
    for(int i=0; i<M; i++){
      String searchSite = br.readLine();
      sb.append(hm.get(searchSite)+"\n");
    }
    System.out.println(sb);
  }
}