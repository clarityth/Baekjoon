// 비밀번호 찾기
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    HashMap<String, String> hm = new HashMap<>();
    for (int i = 0; i < N; ++i){
      st = new StringTokenizer(br.readLine());
      String site = st.nextToken();
      String pw = st.nextToken();
      hm.put(site, pw);
    }
    
    for (int i = 0; i < M; ++i){
      String searchSite = br.readLine();
      sb.append(hm.get(searchSite) + "\n");
    }
    bw.flush();
    bw.write(sb.toString());
    bw.close();
    br.close();
  }
}