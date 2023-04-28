// 베스트셀러
import java.io.*;
import java.util.*;

public class B1302 {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    HashMap<String, Integer> salesRate = new HashMap<>();
    while (N-- > 0) {
      String bookName = br.readLine();
      int salesCnt = salesRate.getOrDefault(bookName, -1);
      if (salesCnt == -1) {
        salesRate.put(bookName, 1);
      }
      else {
        salesRate.replace(bookName, salesCnt + 1);
      }
    }
    String bestSeller = "";
    int maxSalesCnt = 0;
    for (Map.Entry<String, Integer> es : salesRate.entrySet()) {
      int curSalesCnt = es.getValue();
      String curBookName = es.getKey();
      if (curSalesCnt > maxSalesCnt) {
        maxSalesCnt = curSalesCnt;
        bestSeller = curBookName;
      }
      else if (curSalesCnt == maxSalesCnt) {
        // 제목이 사전 순으로 앞서 있다면 갱신
        if (bestSeller.compareTo(curBookName) > 0){
          bestSeller = curBookName;
        }
      }
    }
    bw.flush();
    bw.write(bestSeller);
    bw.close();
    br.close();
  }
}