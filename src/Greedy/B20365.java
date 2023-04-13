import java.io.*;
import java.util.*;

public class B20365 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    String str = br.readLine();
    // 전체를 이미 각각 파란색, 빨간색으로 칠한 상태에서 시작한다고 가정
    int BlueWorkCnt = 1, RedWorkCnt = 1;
    
    // 전체를 이미 빨간색으로 칠한 상태에서 파란색을 덧씌우는 과정
    for(int i=0; i<N; ++i){
      if (str.charAt(i) == 'B'){
        while (str.charAt(i) == 'B'){
          i++;
          if (i >= N)
            break;
        }
        ++BlueWorkCnt;
      }
    }

    // 전체를 이미 파란색으로 칠한 상태에서 빨간색을 덧씌우는 과정
    for(int i=0; i<N; ++i){
      if (str.charAt(i) == 'R'){
        while (str.charAt(i) == 'R'){
          i++;
          if (i >= N)
            break;
        }
        ++RedWorkCnt;
      }
    }
    // 두 과정의 최솟값 출력
    bw.write(String.valueOf(Math.min(BlueWorkCnt, RedWorkCnt)));
    bw.flush();
    bw.close();
    br.close();
  }
}