import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class B2138 {
  public static final int INF = 987654321;
  public static int N;
  public static char[] targetBulbStatus;

  public static void NOT(char[] bulbStatus, int i){
    if (bulbStatus[i] == '0')
      bulbStatus[i] = '1';
    else
      bulbStatus[i] = '0';
  }
  
  public static int getChangeCnt(char[] bulbStatus, int cntInitialValue){
    int cnt = cntInitialValue;
    for(int i=1; i<N; ++i){
      if (bulbStatus[i-1] != targetBulbStatus[i-1]){
        ++cnt;
        NOT(bulbStatus, i-1);
        NOT(bulbStatus, i);
        if (i != N-1)
          NOT(bulbStatus, i+1);
      }
    } 
    if (bulbStatus[N-1] != targetBulbStatus[N-1]) 
      return INF;
    return cnt;
  }
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    char[] bulbStatus1 = br.readLine().toCharArray();
    // 첫번째 전구를 켜고 시작
    char[] bulbStatus2 = bulbStatus1.clone();
    // 켜지 않고 시작
    targetBulbStatus = br.readLine().toCharArray();
    if (N >= 3) {
      NOT(bulbStatus1, 0);
      NOT(bulbStatus1, 1);
    }
    
    int cnt1 = getChangeCnt(bulbStatus1, 1);
    int cnt2 = getChangeCnt(bulbStatus2, 0);
    
    if (cnt1 == INF && cnt2 == INF)
      bw.write("-1");
    else
      bw.write(String.valueOf(Math.min(cnt1, cnt2)));
    bw.flush();
    bw.close();
    br.close();
  }
}