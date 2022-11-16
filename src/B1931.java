import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] time = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startTime = Integer.parseInt(st.nextToken());
      int endTime = Integer.parseInt(st.nextToken());
      time[i][0] = startTime;
      time[i][1] = endTime;
    }
    Arrays.sort(time, new Comparator<int[]>() {
      @Override 
      public int compare(int[] o1, int[] o2) {
        // 종료 시간이 같을 경우, 시작 시간 기준 오름차순 정렬
        if (o1[1] == o2[1])
          return o1[0] - o2[0];
        else
          return o1[1] - o2[1];
      }
    });

    int maxMeeting = 0, prevEndTime = 0;
    for (int i = 0; i < N; i++) {
      // 현재 회의의 시작 시간이 이전 회의의 종료 시간 이후일 경우, 갱신
      if (time[i][0] >= prevEndTime) {
        prevEndTime = time[i][1];
        maxMeeting++;
      }
    }
    System.out.println(maxMeeting);
  }
}