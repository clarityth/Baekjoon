import java.io.*;
import java.util.*;

public class B11501 {
  static long stockPrices[], maxStockPrice = 0;
  static int getMaxStockIdx(int startIdx, int N) {
    // N부터 startIdx까지 역방향으로 순회하며, 가장 높은 주식 가격의 인덱스를 리턴해주는 함수
    int idx = 0;
    // 모든 금액이 역순으로 배치 되어 있을 때, 정방향 순회시 시간 초과 발생 -> 역방향으로 순회 
    for (int i = N-1; i >= startIdx; --i) {
      if (stockPrices[i] > maxStockPrice) {
        maxStockPrice = stockPrices[i];
        idx = i;
      }
    }
    return idx;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; ++i) {
      int N = Integer.parseInt(br.readLine());
      long profit = 0l;
      int maxStockIdx = 0;
      maxStockPrice = 0l;
      stockPrices = new long[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; ++j) {
        stockPrices[j] = Long.parseLong(st.nextToken());
        if (stockPrices[j] > maxStockPrice) {
          maxStockPrice = stockPrices[j];
          maxStockIdx = j;
        } 
      }
      for (int j = 0; j < N; ++j) {
        if (j < maxStockIdx) {
          profit += maxStockPrice - stockPrices[j];
        } else if (j > maxStockIdx) {
          maxStockPrice = 0;
          maxStockIdx = getMaxStockIdx(j, N);
          if (maxStockIdx != j)
            profit += maxStockPrice - stockPrices[j];
        }
      }
      bw.write(String.valueOf(profit) + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}