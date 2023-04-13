import java.io.*;
import java.util.*;

public class B21921 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    // 윈도우 사이즈
    int dailyVisitor[] = new int[N];
    int maxVisitor = 0, accumSum = 0, maxVisitorDays = 1;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      dailyVisitor[i] = Integer.parseInt(st.nextToken());
      if (i >= 0 && i < X)
        maxVisitor += dailyVisitor[i];
    }
    accumSum = maxVisitor;
    
    // 슬라이드의 길이 (이동 칸수)
    for (int i = 0; i < N - X; ++i) {
      // 누적합 계산
      accumSum = accumSum - dailyVisitor[i] + dailyVisitor[X + i];
      if (accumSum > maxVisitor) {
        maxVisitor = accumSum;
        maxVisitorDays = 1;
      }
      else if (accumSum == maxVisitor)
        maxVisitorDays++;
    }
    if (maxVisitor == 0)
      bw.write("SAD");
    else {
      bw.write(String.valueOf(maxVisitor) + "\n" + String.valueOf(maxVisitorDays));
    }
    bw.flush();
    bw.close();
    br.close();
  }
}